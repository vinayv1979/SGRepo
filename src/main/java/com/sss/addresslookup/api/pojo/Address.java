package com.sss.addresslookup.api.pojo;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address implements Serializable {
	
	
	

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "results")
	private ArrayList<Results> results;


	public int getTotalResults1234567() {
		return totalResults1234567;
	}

	public void setTotalResults1234567(int totalResults1234567) {
		this.totalResults1234567 = totalResults1234567;
	}

	@XmlElement(name = "totalResultsTest1234567")
	private int totalResults1234567;




	public ArrayList<Results> getResults() {
		return results;
	}

	public void setResults(ArrayList<Results> results) {
		this.results = results;
	}

}
