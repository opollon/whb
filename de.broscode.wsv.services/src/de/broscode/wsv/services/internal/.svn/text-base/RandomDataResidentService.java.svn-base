package de.broscode.wsv.services.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import de.broscode.wsv.entities.Country;
import de.broscode.wsv.entities.Resident;
import de.broscode.wsv.services.IResidentChangeListener;
import de.broscode.wsv.services.IResidentService;

/**
 * RandomDataAddressService is an "for practive purpose only" implementation of
 * {@link IResidentService}. It returns randomly created addresses, no
 * persistence happens at all. Also the calls are slowed down using Thread.sleep
 * to imitate the behavior of a service implementation which loads data from a
 * backend server.
 * 
 * @author Ralf Ebert
 */
public class RandomDataResidentService implements IResidentService {

	private final AtomicInteger idSequence = new AtomicInteger(0);
	private final List<Resident> residents;
	private final LinkedHashSet<IResidentChangeListener> addressChangeListeners = new LinkedHashSet<IResidentChangeListener>();
	private final List<Country> countries;

	public RandomDataResidentService() {
		countries = new ArrayList<Country>();
		for (String countryName : RandomData.COUNTRIES) {
			countries.add(new Country(countryName));
		}

		residents = new ArrayList<Resident>();
		for (int i = 1; i <= 50; i++) {
			RandomData rd = new RandomData(i);
			residents.add(new Resident(idSequence.incrementAndGet(), rd.somePersonFirstName(), rd.somePersonLastName(),
					rd.someStreet(), rd.someZipCode(), rd.someCity(), countries.get(0)));
			rd.newData();
		}
	}

	public List<Resident> getAllResidents() {
		simulateSlowNetworkConnection();
		return residents;
	}

	private void simulateSlowNetworkConnection() {
		try {
			Thread.sleep(new RandomData().someNumber(500, 2000));
		} catch (InterruptedException e) {
			// ignore
		}
	}

	public String[] getAllCities() {
		return RandomData.CITIES;
	}

	public Collection<Country> getAllCountries() {
		return Collections.unmodifiableList(countries);
	}

	public void deleteAddress(int id) {
		for (Iterator<Resident> i = residents.iterator(); i.hasNext();) {
			Resident address = i.next();
			if (address.getId() == id) {
				i.remove();
				fireAddressChange();
				return;
			}
		}
	}

	public Resident getAddress(int id) {
		for (Iterator<Resident> i = residents.iterator(); i.hasNext();) {
			Resident address = i.next();
			if (address.getId() == id) {
				return address.copy();
			}
		}
		return null;
	}

	public Resident saveAddress(Resident changedOrNewAddress) {
		if (changedOrNewAddress.getId() == null) {
			// create new address
			Resident createdAddress = new Resident(idSequence.incrementAndGet(), changedOrNewAddress.getName(),
					changedOrNewAddress.getLastName(), changedOrNewAddress.getStreet(), changedOrNewAddress.getZip(),
					changedOrNewAddress.getCity(), changedOrNewAddress.getCountry());
			residents.add(createdAddress);
			fireAddressChange();
			return createdAddress.copy();
		} else {
			// change existing address
			for (Iterator<Resident> i = residents.iterator(); i.hasNext();) {
				Resident address = i.next();
				if (address.getId() == changedOrNewAddress.getId()) {
					address.setName(changedOrNewAddress.getName());
					address.setStreet(changedOrNewAddress.getStreet());
					address.setZip(changedOrNewAddress.getZip());
					address.setCity(changedOrNewAddress.getCity());
					address.setCountry(changedOrNewAddress.getCountry());
					fireAddressChange();
					return getAddress(address.getId());
				}
			}
			throw new IllegalArgumentException("Address " + changedOrNewAddress.getId() + " not found!");
		}
	}

	private void fireAddressChange() {
		for (IResidentChangeListener changeListener : addressChangeListeners) {
			changeListener.addressesChanged();
		}
	}

	public void addAddressChangeListener(IResidentChangeListener listener) {
		this.addressChangeListeners.add(listener);
	}

	public void removeAddressChangeListener(IResidentChangeListener listener) {
		this.addressChangeListeners.remove(listener);
	}

}
