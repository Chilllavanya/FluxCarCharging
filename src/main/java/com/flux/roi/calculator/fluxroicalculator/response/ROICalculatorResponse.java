package com.flux.roi.calculator.fluxroicalculator.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ROICalculatorResponse implements Response {
	
	private double grossKWDispensed;
	private double kwCost;
	private double kwGross;
	private double margin;
	private double monthsToPayOff;
	private double yearsToOff;
	
	
}
