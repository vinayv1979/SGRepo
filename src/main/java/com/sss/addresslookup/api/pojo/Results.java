package com.sss.addresslookup.api.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "results")
@XmlAccessorType(XmlAccessType.NONE)
public class Results implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @XmlElement
	private String country;
    @XmlElement
	private String post_town;
    @XmlElement
	private String address_org;
    @XmlElement
	private String address_street;
    @XmlElement
	private String postcode;
    @XmlElement
	private String address_locality;
    @XmlElement
	private String address_building;
    @XmlElement
	private String delivery_point_suffix;
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPost_town() {
		return post_town;
	}
	public void setPost_town(String post_town) {
		this.post_town = post_town;
	}
	public String getAddress_org() {
		return address_org;
	}
	public void setAddress_org(String address_org) {
		this.address_org = address_org;
	}
	public String getAddress_street() {
		return address_street;
	}
	public void setAddress_street(String address_street) {
		this.address_street = address_street;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress_locality() {
		return address_locality;
	}
	public void setAddress_locality(String address_locality) {
		this.address_locality = address_locality;
	}
	public String getAddress_building() {
		return address_building;
	}
	public void setAddress_building(String address_building) {
		this.address_building = address_building;
	}
	public String getDelivery_point_suffix() {
		return delivery_point_suffix;
	}
	public void setDelivery_point_suffix(String delivery_point_suffix) {
		this.delivery_point_suffix = delivery_point_suffix;
	}


}
