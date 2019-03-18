package com.sss.addresslookup.osma.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class OSMAResults implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<OSMAResult> results;

	public ArrayList<OSMAResult> getResults() {
		return results;
	}

	public void setResults(ArrayList<OSMAResult> results) {
		this.results = results;
	}

}
