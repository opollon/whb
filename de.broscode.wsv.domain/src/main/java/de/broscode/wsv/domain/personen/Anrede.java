package de.broscode.wsv.domain.personen;

public enum Anrede {
	FRAU (0, "Frau"),
	HERR (1, "Herr"),
	DOKTOR (2, "Doktor"),
	PROFESSOR (3, "Professor");
	
	private final int index;
	private final String value;
	
	Anrede(int index, String value) {
		this.index = index;
		this.value = value;
	}
	
	String value () {
		return value;
	}
	
	int index () {
		return index;
	}
}
