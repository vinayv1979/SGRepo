package com.sss.addresslookup.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sss.addresslookup.api.pojo.Address;
import com.sss.addresslookup.service.AddressLookupSrvIntf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class AddressLookupTest {

	@Autowired
	
	AddressLookupSrvIntf addressLookupSrvIntf;

	@Test
	public void testLookup() {
		
		Address address= addressLookupSrvIntf.osmaPostCodeSearch("G3*JF");
		
		System.out.println(address.getResults().size());
		
		
		
		

	}

}
