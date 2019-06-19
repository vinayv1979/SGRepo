package com.sss.addresslookup.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sss.addresslookup.api.pojo.Address;
import com.sss.addresslookup.api.pojo.Results;

import com.sss.addresslookup.osma.pojo.OSMAAddress;
import com.sss.addresslookup.osma.pojo.OSMAResult;
import com.sss.addresslookup.osma.pojo.OSMAResults;

@Service
public class AddressLookupSrvImpl implements AddressLookupSrvIntf {

	public Address osmaPostCodeSearch(String postCode) {

		String uri = "https://api.publicsectormapping.gov.scot/osmab-socse-csc10-baa02/os/abpl/address?postcode="
				+ formatPostCode(postCode) + "&fieldset=all";

		Address address = null;
		OSMAResults osmaResults = null;

		RestTemplate restTemplate = new RestTemplate();

		final List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();

		interceptors.add(new BasicAuthorizationInterceptor("osmab-socse-csc10", "Imeta6Ubun81"));

		restTemplate.setInterceptors(interceptors);

		osmaResults = restTemplate.getForObject(uri, OSMAResults.class);

		ArrayList<Results> arrResult = transformAPISpecificObj(osmaResults);

		if (arrResult.size() > 0) {
			address = new Address();
			address.setResults(arrResult);
			address.setTotalResults(arrResult.size());
		}
		return address;
	}

	/**
	 * @param osmaResults
	 * @return
	 */
	private ArrayList<Results> transformAPISpecificObj(OSMAResults osmaResults) {

		OSMAResult osmaResult;
		Results results;

		StringBuilder builder;

		ArrayList<Results> arrResult = null;

		if (osmaResults.getResults().size() > 0) {
			osmaResult = osmaResults.getResults().get(0);

			if (osmaResult.getAddress().size() > 0) {

				arrResult = new ArrayList<Results>();

				for (int i = 0; i < osmaResult.getAddress().size(); i++) {
					OSMAAddress osmaAddress = osmaResult.getAddress().get(i);
					results = new Results();
					results.setCountry(osmaAddress.getCountry());
					results.setPost_town(osmaAddress.getPost_town());
					results.setAddress_org(osmaAddress.getLa_organisation());

					builder = new StringBuilder();

					if (osmaAddress.getLa_organisation().isEmpty()) {
						if (osmaAddress.getSao_text() != null && osmaAddress.getSao_text().length() > 0) {
							builder.append(osmaAddress.getSao_text() + ", ");
						}

					}

					if (osmaAddress.getBuilding_number() != null && osmaAddress.getBuilding_number().length() > 0) {
						builder.append(osmaAddress.getBuilding_number() + " ");
					} else {

						if (osmaAddress.getPao_start_number() != null
								&& osmaAddress.getPao_start_number().length() > 0) {
							builder.append(osmaAddress.getPao_start_number() + " ");
						}

					}

					if (osmaAddress.getThoroughfare() != null && osmaAddress.getThoroughfare().length() > 0) {
						builder.append(osmaAddress.getThoroughfare());
					}

					results.setAddress_street(builder.toString());
					results.setPostcode(osmaAddress.getPostcode());
					results.setAddress_locality(osmaAddress.getLocality());

					if ((osmaAddress.getBuilding_name() != null && osmaAddress.getBuilding_name().length() > 0)
							&& (osmaAddress.getSub_building_name() != null
									&& osmaAddress.getSub_building_name().length() > 0)) {

						results.setAddress_building(
								osmaAddress.getBuilding_name() + "" + osmaAddress.getSub_building_name());
					} else {
						results.setAddress_building(osmaAddress.getPao_text());

					}
					results.setDelivery_point_suffix(osmaAddress.getDelivery_point_suffix());

					arrResult.add(results);

				}

			}

		}
		return arrResult;

	}

	/**
	 * @param postcode
	 * @return
	 */
	private static String formatPostCode(String postcode) {

		String t = postcode.replaceAll("([A-Z,1-9]{3})([A-Z,1-9]{3})", "$1 $2");
		String finalStr = "";

		String replaceStr = postcode.replaceAll("\\s+", "");

		if (replaceStr.length() == 5) {
			String u = replaceStr.substring(0, 2) + ' ' + replaceStr.substring(2);
			String v = new StringBuilder(replaceStr).insert(2, ' ').toString();
			for (String w : java.util.Arrays.asList(replaceStr, t, u, v)) {
				finalStr = w;
			}

		}

		if (replaceStr.length() == 6) {
			String u = replaceStr.substring(0, 3) + ' ' + replaceStr.substring(3);
			String v = new StringBuilder(replaceStr).insert(3, ' ').toString();
			for (String w : java.util.Arrays.asList(replaceStr, t, u, v)) {
				finalStr = w;
			}

		}

		if (replaceStr.length() == 7) {
			String u = replaceStr.substring(0, 4) + ' ' + replaceStr.substring(4);
			String v = new StringBuilder(replaceStr).insert(4, ' ').toString();
			for (String w : java.util.Arrays.asList(replaceStr, t, u, v)) {
				finalStr = w;
			}

		}
		return finalStr;

	}
}
