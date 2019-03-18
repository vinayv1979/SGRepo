package com.sss.addresslookup.osma.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class OSMAResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<OSMAAddress> address;

	public ArrayList<OSMAAddress> getAddress() {
		return address;
	}

	public void setAddress(ArrayList<OSMAAddress> address) {
		this.address = address;
	}

}
