package com.sss.addresslookup.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sss.addresslookup.api.pojo.Address;
import com.sss.addresslookup.api.pojo.Results;

import com.sss.addresslookup.osma.pojo.OSMAAddress;
import com.sss.addresslookup.osma.pojo.OSMAResult;
import com.sss.addresslookup.osma.pojo.OSMAResults;

@Service
public class AddressLookupSrvImpl implements AddressLookupSrvIntf {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sss.addresslookup.service.AddressLookupSrvIntf#osmaPostCodeSearch(java.
	 * lang.String)
	 */
	public Address osmaPostCodeSearch(String postCode)  {

		final String uri = "http://demo7168884.mockable.io/addresslookup/";

		Address address = null;
		OSMAResults osmaResults = null;

		// Define the param
		Map<String, String> params = new HashMap<String, String>();
		params.put("postcode", postCode);

		RestTemplate restTemplate = new RestTemplate();

		osmaResults = restTemplate.getForObject(uri, OSMAResults.class, params);

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
					results.setAddress_street(osmaAddress.getBuilding_number() + " " + osmaAddress.getThoroughfare());
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

}
