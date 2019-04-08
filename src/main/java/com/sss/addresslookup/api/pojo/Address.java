package com.sss.addresslookup.api.pojo;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement (name="address")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address implements Serializable{
	
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "results")
	private ArrayList<Results> results;
	
	public int getTotalResultsXXXX() {
		return totalResultsXXXX;
	}


	public void setTotalResultsXXXX(int totalResultsXXXX) {
		this.totalResultsXXXX = totalResultsXXXX;
	}


	@XmlElement(name = "totalResultsXXXX")
	private int totalResultsXXXX; 




	

	public ArrayList<Results> getResults() {
		return results;
	}


	public void setResults(ArrayList<Results> results) {
		this.results = results;
	}

}
