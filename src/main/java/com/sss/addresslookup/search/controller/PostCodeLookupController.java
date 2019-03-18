package com.sss.addresslookup.search.controller;

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

	@Autowired
	private AddressLookupSrvIntf addressLookupSrvIntf;

	@RequestMapping(value = "/addresslookup/{postcode}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public @ResponseBody ResponseEntity<Object> postCodeLookup(@PathVariable String postcode) {

		if (StringUtils.hasText(postcode) && postcode.length() != 0) {
			
			
			Address address = addressLookupSrvIntf.osmaPostCodeSearch(postcode);

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
