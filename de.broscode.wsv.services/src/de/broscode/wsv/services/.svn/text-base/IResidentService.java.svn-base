package de.broscode.wsv.services;

import java.util.Collection;
import java.util.List;

import de.broscode.wsv.entities.Country;
import de.broscode.wsv.entities.Resident;

/**
 * IAddressService is a simple data providing service which maintains a list of
 * {@link Resident} objects.
 * 
 * @author Ralf Ebert
 */
public interface IResidentService {

	/**
	 * Returns a List<Character> of all known Characters.
	 */
	public List<Resident> getAllResidents();

	/**
	 * Returns a Address by its primary key id.
	 */
	public Resident getAddress(int id);

	/**
	 * Saves a changed address. New addresses created with new Address() are
	 * created automatically and returned with a primary key.
	 */
	public Resident saveAddress(Resident changedOrNewAddress);

	/**
	 * Deletes the address with matching primary key id.
	 */
	public void deleteAddress(int id);

	/**
	 * Returns a list of all known countries as List<Country>.
	 */
	public Collection<Country> getAllCountries();

	/**
	 * Returns a list of all known cities as String[].
	 */
	public String[] getAllCities();

	/**
	 * Adds an IAddressChangeListener which will be notified whenever addresses
	 * are changed, added or removed.
	 */
	public void addAddressChangeListener(IResidentChangeListener listener);

	/**
	 * Removes an IAddressChangeListener.
	 */
	public void removeAddressChangeListener(IResidentChangeListener listener);

}