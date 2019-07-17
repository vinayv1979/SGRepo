package com.sss.addresslookup.search.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sss.addresslookup.api.pojo.Address;
import com.sss.addresslookup.api.pojo.ErrorResponse;
import com.sss.addresslookup.exception.AddressNotFoundException;
import com.sss.addresslookup.exception.AddressValidationException;
import com.sss.addresslookup.service.AddressLookupSrvIntf;

@RestController
public class PostCodeLookupController {
	
	
	private static final Logger logger = Logger.getLogger(PostCodeLookupController.class);

	@Autowired
	private AddressLookupSrvIntf addressLookupSrvIntf;

	@RequestMapping(value = "/addresslookup/{postcode}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody ResponseEntity<Object> postCodeLookup(@PathVariable String postcode) {
		
		logger.info("postcode :"+ postcode);

		System.out.println("postcode :"+ postcode);
		
		String pc = postcode.replaceAll("\\s", "");
		
		logger.info("PC :"+ pc);

		if (StringUtils.hasText(pc) && pc.length() != 0) {

			Address address = addressLookupSrvIntf.osmaPostCodeSearch(pc);

			return new ResponseEntity<Object>(address, HttpStatus.OK);

		} else {

			throw new AddressValidationException("Input not correct or null");

		}

	}

	@ExceptionHandler(AddressValidationException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}

	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler1(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}

}
