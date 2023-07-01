package com.flux.roi.calculator.fluxroicalculator.controller;

import com.flux.roi.calculator.fluxroicalculator.dtos.ROICalculatorDto;
import com.flux.roi.calculator.fluxroicalculator.response.ErrorResponse;
import com.flux.roi.calculator.fluxroicalculator.response.ROICalculatorResponse;
import com.flux.roi.calculator.fluxroicalculator.response.Response;
import com.flux.roi.calculator.fluxroicalculator.services.ROIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roi")
public class ROICalculator {
	
	@Autowired
	ROIService roiService;
	
	@PostMapping("/getroi")
	public ResponseEntity<Response> calculateROI(@RequestBody ROICalculatorDto roiCalculatorDto) throws Exception {
		
		try {
			if (roiCalculatorDto.getAvgChargingSessionDuration() < 0) {
				return new ResponseEntity<>(new ErrorResponse("Avg charging session duration should be greater than 0."), HttpStatus.OK);
				
			}
			if (roiCalculatorDto.getStationKWOutput() < 0) {
				return new ResponseEntity<>(new ErrorResponse("Station KWOutput should be greater than 0."), HttpStatus.OK);
				
			}
			if (roiCalculatorDto.getNoOfChargingStations() < 0) {
				return new ResponseEntity<>(new ErrorResponse("No. of charging stations should be greater than 0."), HttpStatus.OK);
				
			}
			if (roiCalculatorDto.getChargingSessionsPerDayPerUnit() < 0) {
				return new ResponseEntity<>(new ErrorResponse("Charging sessions per day per unit should be greater than 0."), HttpStatus.OK);
				
			}
			if (roiCalculatorDto.getDaysOfUsePerMonth() < 0) {
				return new ResponseEntity<>(new ErrorResponse("Days of use per Month should be greater than 0."), HttpStatus.OK);
				
			}
			if (roiCalculatorDto.getProjectCost() < 0.00) {
				return new ResponseEntity<>(new ErrorResponse("ProjectCost should be greater than 0."), HttpStatus.OK);
				
				
			}
			if (roiCalculatorDto.getKwCost() < 0.00) {
				return new ResponseEntity<>(new ErrorResponse("KWCost should be greater than 0."), HttpStatus.OK);
				
			}
			if (roiCalculatorDto.getKwMSRP() < 0.00) {
				return new ResponseEntity<>(new ErrorResponse("KW_MSRP should be greater than 0."), HttpStatus.OK);
			}
			
			
			ROICalculatorResponse response = roiService.calculateROI(roiCalculatorDto);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
