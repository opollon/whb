package de.broscode.wsv.platform.handlers;

import java.util.Iterator;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import de.broscode.wsv.entities.Resident;
import de.broscode.wsv.platform.editors.ResidentEditorInput;
import de.broscode.wsv.platform.ids.PlatformIDs;

public class ResidentEditHandler implements IHandler {

	private IWorkbenchPage page;
	
	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		page = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (!(selection instanceof IStructuredSelection))
		return null;
		for (Iterator<?> it = ((IStructuredSelection)selection).iterator(); it.hasNext();) {
		Object obj = it.next();
		if (obj instanceof Resident) {
		try {
			page.openEditor(new ResidentEditorInput((Resident) obj), PlatformIDs.EDITOR_ID_RESIDENT_EDITOR);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		}		
		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
