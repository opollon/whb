package de.broscode.wsv.platform.editors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import de.broscode.wsv.entities.Resident;

public class ResidentEditor extends EditorPart {

	private Resident 	bewohner;
	private CTabFolder 	tabFolder;
	private Text 		txtLastName, txtFirstName, txtBirthName, txtFormOfAddress, txtDateOfBirth, txtBirthplace, txtCountryOfBirth, 
						txtNationality, txtReligion, txtFamilyStatus, txtDateOfJoining, txtDateOfResignation, txtReferenceNumber, 
						txtMobileNumber, txtPersonalID, txtStreet, txtHouseNumber, txtPostcode, txtCity;
	
	public ResidentEditor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		setSite(site);
		setInput(input);
		this.bewohner = ((ResidentEditorInput) input).getCharacter();
		Assert.isTrue(input instanceof ResidentEditorInput,
				"Input object needs to be ResidentEditorInput!");
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		setPartName(bewohner.getName() + " " + bewohner.getLastName());
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite composite = new Composite(scrolledComposite, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		Composite container = new Composite(composite, SWT.NONE);
		GridData gd_container = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_container.widthHint = 580;
		container.setLayoutData(gd_container);
		container.setLayout(new GridLayout(1, false));
		
		{   
			Composite referenceDataContainer = new Composite(container, SWT.BORDER);
			referenceDataContainer.setLayout(new GridLayout(5, false));
			
			Label lblLastName = new Label(referenceDataContainer, SWT.NONE);
			lblLastName.setText("Name");
			
			txtLastName = new Text(referenceDataContainer, SWT.BORDER);
			GridData gd_txtLastName = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
			gd_txtLastName.widthHint = 150;
			txtLastName.setLayoutData(gd_txtLastName);
			
			Composite composite_1 = new Composite(referenceDataContainer, SWT.NONE);
			GridData gd_composite_1 = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1);
			gd_composite_1.heightHint = 14;
			gd_composite_1.widthHint = 28;
			composite_1.setLayoutData(gd_composite_1);
			
			Label lblFirstName = new Label(referenceDataContainer, SWT.NONE);
			lblFirstName.setText("Vorname");
			
			txtFirstName = new Text(referenceDataContainer, SWT.BORDER);
			GridData gd_txtFirstName = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
			gd_txtFirstName.widthHint = 150;
			txtFirstName.setLayoutData(gd_txtFirstName);
			
			Label lblBirthName = new Label(referenceDataContainer, SWT.NONE);
			lblBirthName.setText("Geburtsname");
			
			txtBirthName = new Text(referenceDataContainer, SWT.BORDER);
			txtBirthName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
			new Label(referenceDataContainer, SWT.NONE);
			
			Label lblFormOfAddress = new Label(referenceDataContainer, SWT.NONE);
			lblFormOfAddress.setText("Anrede");
			
			txtFormOfAddress = new Text(referenceDataContainer, SWT.BORDER);
			txtFormOfAddress.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
			
			Label lblDateOfBirth = new Label(referenceDataContainer, SWT.NONE);
			lblDateOfBirth.setText("Geburtsdatum");
			
			txtDateOfBirth = new Text(referenceDataContainer, SWT.BORDER);
			txtDateOfBirth.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
			new Label(referenceDataContainer, SWT.NONE);
			
			Label lblBirthplace = new Label(referenceDataContainer, SWT.NONE);
			lblBirthplace.setText("Geburtsort");
			
			txtBirthplace = new Text(referenceDataContainer, SWT.BORDER);
			txtBirthplace.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
			
			Label lblCountryOfBirth = new Label(referenceDataContainer, SWT.NONE);
			lblCountryOfBirth.setText("Geburtsland");
			
			txtCountryOfBirth = new Text(referenceDataContainer, SWT.BORDER);
			txtCountryOfBirth.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
			new Label(referenceDataContainer, SWT.NONE);
			
			Label lblNationality = new Label(referenceDataContainer, SWT.NONE);
			lblNationality.setText("Nationalit\u00E4t");
			
			txtNationality = new Text(referenceDataContainer, SWT.BORDER);
			txtNationality.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
			
			Label lblReligion = new Label(referenceDataContainer, SWT.NONE);
			lblReligion.setText("Religion");
			
			txtReligion = new Text(referenceDataContainer, SWT.BORDER);
			txtReligion.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
			new Label(referenceDataContainer, SWT.NONE);
			
			Label lblFamilyStatus = new Label(referenceDataContainer, SWT.NONE);
			lblFamilyStatus.setText("Familienstand");
			
			txtFamilyStatus = new Text(referenceDataContainer, SWT.BORDER);
			txtFamilyStatus.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
			
			Label lblDateOfJoining = new Label(referenceDataContainer, SWT.NONE);
			lblDateOfJoining.setText("Eintrittsdatum");
			
			txtDateOfJoining = new Text(referenceDataContainer, SWT.BORDER);
			txtDateOfJoining.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			new Label(referenceDataContainer, SWT.NONE);
			
			Label lblDateOfResignation = new Label(referenceDataContainer, SWT.NONE);
			lblDateOfResignation.setText("Austrittsdatum");
			
			txtDateOfResignation = new Text(referenceDataContainer, SWT.BORDER);
			txtDateOfResignation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label lblReferenceNumber = new Label(referenceDataContainer, SWT.NONE);
			lblReferenceNumber.setText("Aktenzeichen");
			
			txtReferenceNumber = new Text(referenceDataContainer, SWT.BORDER);
			txtReferenceNumber.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			new Label(referenceDataContainer, SWT.NONE);
			
			Label lblMobileNumber = new Label(referenceDataContainer, SWT.NONE);
			lblMobileNumber.setText("Handynummer");
			
			txtMobileNumber = new Text(referenceDataContainer, SWT.BORDER);
			txtMobileNumber.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			new Label(referenceDataContainer, SWT.NONE);
			new Label(referenceDataContainer, SWT.NONE);
			new Label(referenceDataContainer, SWT.NONE);
			
			Label lblPersonalID = new Label(referenceDataContainer, SWT.NONE);
			lblPersonalID.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblPersonalID.setText("Pers\u00F6nliche IdentNr.");
			
			txtPersonalID = new Text(referenceDataContainer, SWT.BORDER);
			txtPersonalID.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		}
		
		setBewohner();
		

		tabFolder = new CTabFolder(container, SWT.BORDER);
		GridData gd_tabFolder = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_tabFolder.widthHint = 560;
		tabFolder.setLayoutData(gd_tabFolder);
		tabFolder.setSimple(true);
		Display display = Display.getCurrent();
		tabFolder.setSelectionBackground(new Color[]{ 
				display.getSystemColor(SWT.COLOR_WHITE),
                display.getSystemColor(SWT.COLOR_TITLE_BACKGROUND)},
                new int[] {100}, true);
		
		CTabItem tbfAddress = new CTabItem(tabFolder, SWT.NONE);
		tbfAddress.setText("Adresse");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbfAddress.setControl(composite_1);
		composite_1.setLayout(new GridLayout(2, false));
		
		Label lblStreet = new Label(composite_1, SWT.NONE);
		lblStreet.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblStreet.setText("Strasse");
		
		txtStreet = new Text(composite_1, SWT.BORDER);
		GridData gd_txtStreet = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtStreet.widthHint = 120;
		txtStreet.setLayoutData(gd_txtStreet);
		
		Label lblHouseNumber = new Label(composite_1, SWT.NONE);
		lblHouseNumber.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblHouseNumber.setText("Hausnummer");
		
		txtHouseNumber = new Text(composite_1, SWT.BORDER);
		txtHouseNumber.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblPostcode = new Label(composite_1, SWT.NONE);
		lblPostcode.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPostcode.setText("PLZ");
		
		txtPostcode = new Text(composite_1, SWT.BORDER);
		txtPostcode.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblCity = new Label(composite_1, SWT.NONE);
		lblCity.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCity.setText("Ort");
		
		txtCity = new Text(composite_1, SWT.BORDER);
		GridData gd_txtCity = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtCity.widthHint = 120;
		txtCity.setLayoutData(gd_txtCity);
		
		setAddress();
		
		CTabItem tbfHealthInsurance = new CTabItem(tabFolder, SWT.NONE);
		tbfHealthInsurance.setText("Kranken- Pflegekasse/Rentenversicherung");
		
		CTabItem tbfCostsOfCare = new CTabItem(tabFolder, SWT.NONE);
		tbfCostsOfCare.setText("Betreuungskosten");
		
		CTabItem tbfAccounts = new CTabItem(tabFolder, SWT.NONE);
		tbfAccounts.setText("Konten");
		
		CTabItem tbfIds = new CTabItem(tabFolder, SWT.NONE);
		tbfIds.setText("Ausweise");
		
		CTabItem tbfCarer = new CTabItem(tabFolder, SWT.NONE);
		tbfCarer.setText("Betreuer");
		
		CTabItem tbfRelatives = new CTabItem(tabFolder, SWT.NONE);
		tbfRelatives.setText("Angeh\u00F6rige/Kontakte");
		
		CTabItem tbfMedication = new CTabItem(tabFolder, SWT.NONE);
		tbfMedication.setText("Medikamente/\u00C4rzte");
		
		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	
	}


	private void setBewohner() {
		// TODO Auto-generated method stub
		txtLastName.setText(bewohner.getLastName());
		txtFirstName.setText(bewohner.getName());
		txtCountryOfBirth.setText(bewohner.getCountry().getName());
		
	}
	
	private void setAddress() {
		txtStreet.setText(bewohner.getStreet());
		txtCity.setText(bewohner.getCity());
		txtPostcode.setText(bewohner.getZip());
	}
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		tabFolder.setFocus();

	}
}
