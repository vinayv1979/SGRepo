package com.sss.addresslookup.service;

import java.util.ArrayList;

import java.util.List;



import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
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
	public Address osmaPostCodeSearch(String postCode) {

		// final String uri = "http://demo7168884.mockable.io/addresslookup/";

		/*
		 * String uri =
		 * "https://api.publicsectormapping.gov.scot/osmab-socse-csc10-baa02/os/abpl/address?postcode="
		 * + postCode + "&fieldset=all";
		 */

		Address address = null;
		OSMAResults osmaResults = null;
		String uri = "";

		RestTemplate restTemplate = new RestTemplate();

		BasicAWSCredentials creds = new BasicAWSCredentials("AKIAJENNSX3MFGERUTXQ",
				"EbnfVoF2IyGfF6XW69w1ePIkw1TpZDbZiGjLemBU");
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(creds)).withRegion(Regions.EU_WEST_2).build();

		DynamoDB dynamoDB = new DynamoDB(client);

		Table table = dynamoDB.getTable("Config");

		Item item = table.getItem("ID", "osma-prod");

		// Create and initialize the interceptor
		final List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();

		interceptors
				.add(new BasicAuthorizationInterceptor(item.get("username").toString(), item.get("pwd").toString()));

		restTemplate.setInterceptors(interceptors);

		// Define the param
		// Map<String, String> params = new HashMap<String, String>();
		// params.put("postCode", postCode);
		// osmaResults = restTemplate.getForObject(uri, OSMAResults.class, params);

		if (item.get("test").equals(false)) {

			StringBuilder urlBuilder = new StringBuilder();
			urlBuilder.append(item.get("prod-url").toString());
			urlBuilder.append(item.get("auth").toString());
			urlBuilder.append("/os/abpl/address?postcode=");
			urlBuilder.append(formatPostCode(postCode));
			urlBuilder.append("&fieldset=all");

			uri = urlBuilder.toString();
		} else {
			uri = item.get("test-url").toString();
		}

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
