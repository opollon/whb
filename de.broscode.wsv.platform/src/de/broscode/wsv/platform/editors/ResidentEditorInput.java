package de.broscode.wsv.platform.editors;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import de.broscode.wsv.entities.Resident;

public class ResidentEditorInput implements IEditorInput {
	private int id;
	private Resident bewohner;
	
	public ResidentEditorInput(Resident resident) {
		super();
		this.id = resident.getId();
		this.bewohner = resident;
	}

	public Resident getCharacter() {
		return bewohner;
	}
	
	public int getId() {
		return id;
		}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class adapter) {
		return null;
	}

	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// Text für den Benutzer, wird initial im Reiter des Editors angezeigt
		return "Bewohner mit der ID: " + id;
	}

	@Override
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToolTipText() {
		return getName();
	}

}
