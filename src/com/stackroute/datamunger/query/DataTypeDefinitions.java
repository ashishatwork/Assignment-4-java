package com.stackroute.datamunger.query;

import java.util.Arrays;

//this class contains the data type definitions
public class DataTypeDefinitions {
	private String[] dataTypes;

	public void setDataTypes(String[] dataTypes) {
		this.dataTypes = dataTypes;
	}

	/*
	 * this class should contain a member variable which is a String array, to hold
	 * the data type for all columns for all data types and should override toString() method as well.
	 */	
	public String[] getDataTypes() {
		return this.dataTypes;
	}

	@Override
	public String toString() {
		return "DataTypeDefinitions{" +
				"dataTypes=" + Arrays.toString(dataTypes) +
				'}';
	}
}
