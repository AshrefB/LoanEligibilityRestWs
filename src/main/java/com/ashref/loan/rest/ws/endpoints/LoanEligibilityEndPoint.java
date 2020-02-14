package com.ashref.loan.rest.ws.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashref.loan.rest.ws.payload.requests.CustomerRequest;
import com.ashref.loan.rest.ws.payload.responses.WsResponse;
import com.ashref.loan.rest.ws.services.LoanEligibilityService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/ws")
public class LoanEligibilityEndPoint {
	@Autowired
	private LoanEligibilityService service;

	@PostMapping(path = "/loan/status", 
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<WsResponse> getLoanStatus(@RequestBody CustomerRequest customerRequest) {
		return new ResponseEntity<WsResponse>(service.checkLoanEligibility(customerRequest), HttpStatus.OK);
	}
}
