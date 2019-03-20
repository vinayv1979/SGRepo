package com.sss.addresslookup.service;

import com.sss.addresslookup.api.pojo.Address;


public interface AddressLookupSrvIntf {
	
	public Address osmaPostCodeSearch(String postCode);
	
	
}
