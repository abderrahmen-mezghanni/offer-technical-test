package com.technical.test.enumeration;

public enum Gender {
	Male("Male"),
	Female("Female"),
	Other("Other");
	
	public final String label;

	private Gender(String label) {
		this.label = label;
	}
}
