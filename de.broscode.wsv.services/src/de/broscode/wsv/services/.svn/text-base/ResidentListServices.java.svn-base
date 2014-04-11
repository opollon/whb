package de.broscode.wsv.services;

import de.broscode.wsv.services.internal.RandomDataResidentService;

/**
 * AddressBookServices provides an IAddressService implementation as singleton.
 * For practice purposes only, for real applications consider using OSGi
 * Services / Dependency Injection instead of a Singleton class to provide
 * client-side services.
 * 
 * <code>
 * IAddressService addressService = AddressBookServices.getAddressService();
 * </code>
 * 
 * @author Ralf Ebert
 */
public class ResidentListServices {

	private static IResidentService residentService = new RandomDataResidentService();

	public static IResidentService getResidentService() {
		return residentService;
	}

}