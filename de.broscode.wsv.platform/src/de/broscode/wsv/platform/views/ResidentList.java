package de.broscode.wsv.platform.views;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.progress.UIJob;

import de.broscode.wsv.entities.Resident;
import de.broscode.wsv.services.IResidentChangeListener;
import de.broscode.wsv.services.IResidentService;
import de.broscode.wsv.services.ResidentListServices;

public class ResidentList extends ViewPart {

	private List<Resident> allResidents;
	private TableViewer tableViewer;
	
	private IResidentChangeListener residentChangeListener = new IResidentChangeListener() {
		@Override
		public void addressesChanged() {
		refresh();
		}
	};

	public ResidentList() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Resident> refresh() {
		
		Job job = new Job("Test") {
			@Override
				protected IStatus run(IProgressMonitor monitor) {
					if (PlatformUI.getWorkbench().isClosing()) return Status.CANCEL_STATUS;
					IResidentService service = ResidentListServices.getResidentService();
					allResidents = service.getAllResidents();
					
					UIJob uiJob = new UIJob("Update UI") {
						public IStatus runInUIThread(IProgressMonitor monitor) {
							if (PlatformUI.getWorkbench().isClosing()) return Status.CANCEL_STATUS;
							setResidentList(allResidents);
						return Status.OK_STATUS;
						}
					};
					uiJob.schedule();
				return Status.OK_STATUS;
				}
			};
		job.schedule();
		return allResidents;
	}

	private void setResidentList(List<Resident> allResidents2) {
		// Input-Objekt setzen
		tableViewer.setInput(allResidents2);
	}
	
	/** * This is a callback that will allow us to create the viewer and initialize * it. */

	public void createPartControl(Composite parent) {
			
			Composite tableComposite = new Composite(parent, SWT.NONE);
			TableColumnLayout tableColumnLayout = new TableColumnLayout();
			
			// JFace TableViewer
			tableViewer = new TableViewer(tableComposite, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
			
			// SWT Table
			Table table = tableViewer.getTable();
			
			// Spaltenköpfe und Zeilenbegrenzungen sichtbar machen
			table.setHeaderVisible(false);
			table.setLinesVisible(false);
			
			// ArrayContentProvider, da Input-Objekt hier eine Java Collection ist
			tableViewer.setContentProvider(ArrayContentProvider.getInstance());
			
			// Für jede Spalte ein TableViewerColumn erzeugen
			TableViewerColumn viewerNameColumn = new TableViewerColumn(tableViewer, SWT.NONE);
			viewerNameColumn.getColumn().setText("Vorname");
			//viewerNameColumn.getColumn().setWidth(100);
			
			TableViewerColumn viewerLastNameColumn = new TableViewerColumn(tableViewer, SWT.NONE);
			viewerLastNameColumn.getColumn().setText("Nachname");
			//viewerLastNameColumn.getColumn().setWidth(100);
			
			tableColumnLayout.setColumnData(viewerNameColumn.getColumn(), new ColumnWeightData(20, 100, false));
			tableColumnLayout.setColumnData(viewerLastNameColumn.getColumn(), new ColumnWeightData(20, 100, false));
			
			// LabelProvider für jede Spalte setzen
			viewerNameColumn.setLabelProvider(new ColumnLabelProvider() {
				public String getText(Object element) {
					return ((Resident) element).getName();
				}
			});
			
			viewerLastNameColumn.setLabelProvider(new ColumnLabelProvider() {
				public String getText(Object element) {
					return ((Resident) element).getLastName();
				}
			});

			tableComposite.setLayout(tableColumnLayout);

			MenuManager menuManager = new MenuManager();
			tableViewer.getTable().setMenu(menuManager.createContextMenu(tableViewer.getTable()));
			getSite().registerContextMenu(menuManager, tableViewer);
			getSite().setSelectionProvider(tableViewer);
			refresh();
			
			
			tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
				
				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					refresh();
					
				}
			});
			ResidentListServices.getResidentService()
			.addAddressChangeListener(residentChangeListener);
			hookDoubleClickCommand();

		}
	
	public void dispose() {
		ResidentListServices.getResidentService()
		.removeAddressChangeListener(residentChangeListener);
		super.dispose();
		}

	private void hookDoubleClickCommand() {
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
	      public void doubleClick(DoubleClickEvent event) {
	        IHandlerService handlerService = (IHandlerService) getSite()
	            .getService(IHandlerService.class);
	        try {
	          handlerService.executeCommand("de.broscode.wsv.platform.commands.residentedit", null);
	        } catch (Exception ex) {
	          throw new RuntimeException("de.broscode.wsv.platform.commands.residentedit not found");
	        }
	      }
	    });
	}
		
	/** * Passing the focus request to the viewer's control. */

		public void setFocus() {
			tableViewer.getControl().setFocus();
		}

}
