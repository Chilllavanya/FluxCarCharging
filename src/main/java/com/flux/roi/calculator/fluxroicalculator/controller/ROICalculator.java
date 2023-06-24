package com.flux.roi.calculator.fluxroicalculator.controller;

import com.flux.roi.calculator.fluxroicalculator.dtos.ROICalculatorDto;
import com.flux.roi.calculator.fluxroicalculator.response.ROICalculatorResponse;
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
	
	@GetMapping("/getroi")
	public ResponseEntity<ROICalculatorResponse> calculateROI(@RequestBody ROICalculatorDto roiCalculatorDto){
		
		ROICalculatorResponse response  =  roiService.calculateROI(roiCalculatorDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
}
