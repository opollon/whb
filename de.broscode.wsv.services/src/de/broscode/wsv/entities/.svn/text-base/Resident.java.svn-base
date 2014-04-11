package de.broscode.wsv.entities;

public class Resident {

	private final Integer id;
	private String name, lastname, street, zip, city;
	private Country country;

	public Resident() {
		this.id = null;
	}

	public Resident(Integer id, String name, String lastname, String street, String zip, String city, Country country) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.street = street;
		this.zip = zip;
		this.city = city;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastname;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println(this + " " + name);
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resident other = (Resident) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Resident copy() {
		return new Resident(this.id, this.name, this.lastname, this.street, this.zip, this.city, this.country);
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", street=" + street + ", zip=" + zip + ", city=" + city
				+ ", country=" + country + "]";
	}

}