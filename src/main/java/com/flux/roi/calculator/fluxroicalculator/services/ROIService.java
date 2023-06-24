package com.flux.roi.calculator.fluxroicalculator.services;

import com.flux.roi.calculator.fluxroicalculator.dtos.ROICalculatorDto;
import com.flux.roi.calculator.fluxroicalculator.response.ROICalculatorResponse;

public interface ROIService {
	
	ROICalculatorResponse calculateROI(ROICalculatorDto roiCalculatorDto);
}
