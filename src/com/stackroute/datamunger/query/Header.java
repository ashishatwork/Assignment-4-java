package com.stackroute.datamunger.query;

import java.util.Arrays;

//header class
public class Header {
	private String[] headers;

	public void setHeaders(String[] headers) {
		this.headers = headers;
	}

	/*
	 * this class should contain a member variable which is a String array, to hold
	 * the headers and should override toString() method.
	 */
	public String[] getHeaders() {
		return this.headers;
	}

	@Override
	public String toString() {
		return "Header{" +
				"headers=" + Arrays.toString(headers) +
				'}';
	}
}
