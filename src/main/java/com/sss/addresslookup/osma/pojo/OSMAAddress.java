package com.sss.addresslookup.osma.pojo;

import java.io.Serializable;

public class OSMAAddress implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String udprn;
	private String change_type;
	private String state;
	private String state_date;
	private String parent_uprn;
	private String rpc;
	private String local_custodian_code;
	private String country;
	private String la_start_date;
	private String last_update_date;
	private String entry_date;
	private String rm_organisation_name;
	private String la_organisation;
	private String department_name;
	private String legal_name;
	private String sub_building_name;
	private String building_name;
	private String building_number;
	private String sao_start_number;
	private String sao_start_suffix;
	private String sao_end_number;
	private String sao_end_suffix;
	private String sao_text;
	private String alt_language_sao_text;
	private String pao_start_number;
	private String pao_start_suffix;
	private String pao_end_number;
	private String pao_end_suffix;
	private String pao_text;
	private String alt_language_pao_text;
	private String usrn;
	private String usrn_match_indicator;
	private String area_name;
	private String level;
	private String official_flag;
	private String os_address_toid;
	private String os_address_toid_version;
	private String os_roadlink_toid;
	private String os_roadlink_toid_version;
	private String os_topo_toid;
	private String os_topo_toid_version;
	private String voa_ct_record;
	private String voa_ndr_record;
	private String street_description;
	private String alt_language_street_description;
	private String dependent_thoroughfare;
	private String thoroughfare;
	private String welsh_dependent_thoroughfare;
	private String welsh_thoroughfare;
	private String double_dependent_locality;
	private String dependent_locality;
	private String locality;
	private String welsh_dependent_locality;
	private String welsh_double_dependent_locality;
	private String town_name;
	private String administrative_area;
	private String post_town;
	private String welsh_post_town;
	private String postcode;
	private String postcode_locator;
	private String postcode_type;
	private String delivery_point_suffix;
	private String addressbase_postal;
	private String po_box_number;
	private String ward_code;
	private String parish_code;
	private String rm_start_date;
	private String multi_occ_count;
	private String voa_ndr_p_desc_code;
	private String voa_ndr_scat_code;
	private String alt_language;
	private String matchscore;
	
	private String uprn;
	public String getUprn() {
		return uprn;
	}
	public void setUprn(String uprn) {
		this.uprn = uprn;
	}
	public String getUdprn() {
		return udprn;
	}
	public void setUdprn(String udprn) {
		this.udprn = udprn;
	}
	public String getChange_type() {
		return change_type;
	}
	public void setChange_type(String change_type) {
		this.change_type = change_type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getState_date() {
		return state_date;
	}
	public void setState_date(String state_date) {
		this.state_date = state_date;
	}
	public String getParent_uprn() {
		return parent_uprn;
	}
	public void setParent_uprn(String parent_uprn) {
		this.parent_uprn = parent_uprn;
	}
	public String getRpc() {
		return rpc;
	}
	public void setRpc(String rpc) {
		this.rpc = rpc;
	}
	public String getLocal_custodian_code() {
		return local_custodian_code;
	}
	public void setLocal_custodian_code(String local_custodian_code) {
		this.local_custodian_code = local_custodian_code;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLa_start_date() {
		return la_start_date;
	}
	public void setLa_start_date(String la_start_date) {
		this.la_start_date = la_start_date;
	}
	public String getLast_update_date() {
		return last_update_date;
	}
	public void setLast_update_date(String last_update_date) {
		this.last_update_date = last_update_date;
	}
	public String getEntry_date() {
		return entry_date;
	}
	public void setEntry_date(String entry_date) {
		this.entry_date = entry_date;
	}
	public String getRm_organisation_name() {
		return rm_organisation_name;
	}
	public void setRm_organisation_name(String rm_organisation_name) {
		this.rm_organisation_name = rm_organisation_name;
	}
	public String getLa_organisation() {
		return la_organisation;
	}
	public void setLa_organisation(String la_organisation) {
		this.la_organisation = la_organisation;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getLegal_name() {
		return legal_name;
	}
	public void setLegal_name(String legal_name) {
		this.legal_name = legal_name;
	}
	public String getSub_building_name() {
		return sub_building_name;
	}
	public void setSub_building_name(String sub_building_name) {
		this.sub_building_name = sub_building_name;
	}
	public String getBuilding_name() {
		return building_name;
	}
	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}
	public String getBuilding_number() {
		return building_number;
	}
	public void setBuilding_number(String building_number) {
		this.building_number = building_number;
	}
	public String getSao_start_number() {
		return sao_start_number;
	}
	public void setSao_start_number(String sao_start_number) {
		this.sao_start_number = sao_start_number;
	}
	public String getSao_start_suffix() {
		return sao_start_suffix;
	}
	public void setSao_start_suffix(String sao_start_suffix) {
		this.sao_start_suffix = sao_start_suffix;
	}
	public String getSao_end_number() {
		return sao_end_number;
	}
	public void setSao_end_number(String sao_end_number) {
		this.sao_end_number = sao_end_number;
	}
	public String getSao_end_suffix() {
		return sao_end_suffix;
	}
	public void setSao_end_suffix(String sao_end_suffix) {
		this.sao_end_suffix = sao_end_suffix;
	}
	public String getSao_text() {
		return sao_text;
	}
	public void setSao_text(String sao_text) {
		this.sao_text = sao_text;
	}
	public String getAlt_language_sao_text() {
		return alt_language_sao_text;
	}
	public void setAlt_language_sao_text(String alt_language_sao_text) {
		this.alt_language_sao_text = alt_language_sao_text;
	}
	public String getPao_start_number() {
		return pao_start_number;
	}
	public void setPao_start_number(String pao_start_number) {
		this.pao_start_number = pao_start_number;
	}
	public String getPao_start_suffix() {
		return pao_start_suffix;
	}
	public void setPao_start_suffix(String pao_start_suffix) {
		this.pao_start_suffix = pao_start_suffix;
	}
	public String getPao_end_number() {
		return pao_end_number;
	}
	public void setPao_end_number(String pao_end_number) {
		this.pao_end_number = pao_end_number;
	}
	public String getPao_end_suffix() {
		return pao_end_suffix;
	}
	public void setPao_end_suffix(String pao_end_suffix) {
		this.pao_end_suffix = pao_end_suffix;
	}
	public String getPao_text() {
		return pao_text;
	}
	public void setPao_text(String pao_text) {
		this.pao_text = pao_text;
	}
	public String getAlt_language_pao_text() {
		return alt_language_pao_text;
	}
	public void setAlt_language_pao_text(String alt_language_pao_text) {
		this.alt_language_pao_text = alt_language_pao_text;
	}
	public String getUsrn() {
		return usrn;
	}
	public void setUsrn(String usrn) {
		this.usrn = usrn;
	}
	public String getUsrn_match_indicator() {
		return usrn_match_indicator;
	}
	public void setUsrn_match_indicator(String usrn_match_indicator) {
		this.usrn_match_indicator = usrn_match_indicator;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getOfficial_flag() {
		return official_flag;
	}
	public void setOfficial_flag(String official_flag) {
		this.official_flag = official_flag;
	}
	public String getOs_address_toid() {
		return os_address_toid;
	}
	public void setOs_address_toid(String os_address_toid) {
		this.os_address_toid = os_address_toid;
	}
	public String getOs_address_toid_version() {
		return os_address_toid_version;
	}
	public void setOs_address_toid_version(String os_address_toid_version) {
		this.os_address_toid_version = os_address_toid_version;
	}
	public String getOs_roadlink_toid() {
		return os_roadlink_toid;
	}
	public void setOs_roadlink_toid(String os_roadlink_toid) {
		this.os_roadlink_toid = os_roadlink_toid;
	}
	public String getOs_roadlink_toid_version() {
		return os_roadlink_toid_version;
	}
	public void setOs_roadlink_toid_version(String os_roadlink_toid_version) {
		this.os_roadlink_toid_version = os_roadlink_toid_version;
	}
	public String getOs_topo_toid() {
		return os_topo_toid;
	}
	public void setOs_topo_toid(String os_topo_toid) {
		this.os_topo_toid = os_topo_toid;
	}
	public String getOs_topo_toid_version() {
		return os_topo_toid_version;
	}
	public void setOs_topo_toid_version(String os_topo_toid_version) {
		this.os_topo_toid_version = os_topo_toid_version;
	}
	public String getVoa_ct_record() {
		return voa_ct_record;
	}
	public void setVoa_ct_record(String voa_ct_record) {
		this.voa_ct_record = voa_ct_record;
	}
	public String getVoa_ndr_record() {
		return voa_ndr_record;
	}
	public void setVoa_ndr_record(String voa_ndr_record) {
		this.voa_ndr_record = voa_ndr_record;
	}
	public String getStreet_description() {
		return street_description;
	}
	public void setStreet_description(String street_description) {
		this.street_description = street_description;
	}
	public String getAlt_language_street_description() {
		return alt_language_street_description;
	}
	public void setAlt_language_street_description(String alt_language_street_description) {
		this.alt_language_street_description = alt_language_street_description;
	}
	public String getDependent_thoroughfare() {
		return dependent_thoroughfare;
	}
	public void setDependent_thoroughfare(String dependent_thoroughfare) {
		this.dependent_thoroughfare = dependent_thoroughfare;
	}
	public String getThoroughfare() {
		return thoroughfare;
	}
	public void setThoroughfare(String thoroughfare) {
		this.thoroughfare = thoroughfare;
	}
	public String getWelsh_dependent_thoroughfare() {
		return welsh_dependent_thoroughfare;
	}
	public void setWelsh_dependent_thoroughfare(String welsh_dependent_thoroughfare) {
		this.welsh_dependent_thoroughfare = welsh_dependent_thoroughfare;
	}
	public String getWelsh_thoroughfare() {
		return welsh_thoroughfare;
	}
	public void setWelsh_thoroughfare(String welsh_thoroughfare) {
		this.welsh_thoroughfare = welsh_thoroughfare;
	}
	public String getDouble_dependent_locality() {
		return double_dependent_locality;
	}
	public void setDouble_dependent_locality(String double_dependent_locality) {
		this.double_dependent_locality = double_dependent_locality;
	}
	public String getDependent_locality() {
		return dependent_locality;
	}
	public void setDependent_locality(String dependent_locality) {
		this.dependent_locality = dependent_locality;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getWelsh_dependent_locality() {
		return welsh_dependent_locality;
	}
	public void setWelsh_dependent_locality(String welsh_dependent_locality) {
		this.welsh_dependent_locality = welsh_dependent_locality;
	}
	public String getWelsh_double_dependent_locality() {
		return welsh_double_dependent_locality;
	}
	public void setWelsh_double_dependent_locality(String welsh_double_dependent_locality) {
		this.welsh_double_dependent_locality = welsh_double_dependent_locality;
	}
	public String getTown_name() {
		return town_name;
	}
	public void setTown_name(String town_name) {
		this.town_name = town_name;
	}
	public String getAdministrative_area() {
		return administrative_area;
	}
	public void setAdministrative_area(String administrative_area) {
		this.administrative_area = administrative_area;
	}
	public String getPost_town() {
		return post_town;
	}
	public void setPost_town(String post_town) {
		this.post_town = post_town;
	}
	public String getWelsh_post_town() {
		return welsh_post_town;
	}
	public void setWelsh_post_town(String welsh_post_town) {
		this.welsh_post_town = welsh_post_town;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getPostcode_locator() {
		return postcode_locator;
	}
	public void setPostcode_locator(String postcode_locator) {
		this.postcode_locator = postcode_locator;
	}
	public String getPostcode_type() {
		return postcode_type;
	}
	public void setPostcode_type(String postcode_type) {
		this.postcode_type = postcode_type;
	}
	public String getDelivery_point_suffix() {
		return delivery_point_suffix;
	}
	public void setDelivery_point_suffix(String delivery_point_suffix) {
		this.delivery_point_suffix = delivery_point_suffix;
	}
	public String getAddressbase_postal() {
		return addressbase_postal;
	}
	public void setAddressbase_postal(String addressbase_postal) {
		this.addressbase_postal = addressbase_postal;
	}
	public String getPo_box_number() {
		return po_box_number;
	}
	public void setPo_box_number(String po_box_number) {
		this.po_box_number = po_box_number;
	}
	public String getWard_code() {
		return ward_code;
	}
	public void setWard_code(String ward_code) {
		this.ward_code = ward_code;
	}
	public String getParish_code() {
		return parish_code;
	}
	public void setParish_code(String parish_code) {
		this.parish_code = parish_code;
	}
	public String getRm_start_date() {
		return rm_start_date;
	}
	public void setRm_start_date(String rm_start_date) {
		this.rm_start_date = rm_start_date;
	}
	public String getMulti_occ_count() {
		return multi_occ_count;
	}
	public void setMulti_occ_count(String multi_occ_count) {
		this.multi_occ_count = multi_occ_count;
	}
	public String getVoa_ndr_p_desc_code() {
		return voa_ndr_p_desc_code;
	}
	public void setVoa_ndr_p_desc_code(String voa_ndr_p_desc_code) {
		this.voa_ndr_p_desc_code = voa_ndr_p_desc_code;
	}
	public String getVoa_ndr_scat_code() {
		return voa_ndr_scat_code;
	}
	public void setVoa_ndr_scat_code(String voa_ndr_scat_code) {
		this.voa_ndr_scat_code = voa_ndr_scat_code;
	}
	public String getAlt_language() {
		return alt_language;
	}
	public void setAlt_language(String alt_language) {
		this.alt_language = alt_language;
	}
	public String getMatchscore() {
		return matchscore;
	}
	public void setMatchscore(String matchscore) {
		this.matchscore = matchscore;
	}

	
	
	
	
	
	

}
