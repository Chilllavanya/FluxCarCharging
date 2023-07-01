package com.flux.roi.calculator.fluxroicalculator.services;

import com.flux.roi.calculator.fluxroicalculator.dtos.ROICalculatorDto;
import com.flux.roi.calculator.fluxroicalculator.response.ROICalculatorResponse;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class ROIServiceImpl implements ROIService{
	
	@Override
	public ROICalculatorResponse calculateROI(ROICalculatorDto roiCalculatorDto) {
		
		
		float grossKWDispensed  = (roiCalculatorDto.getAvgChargingSessionDuration()
										* roiCalculatorDto.getStationKWOutput()
										* roiCalculatorDto.getNoOfChargingStations()
										* roiCalculatorDto.getChargingSessionsPerDayPerUnit()
										* roiCalculatorDto.getDaysOfUsePerMonth());

		
		double kwCost = grossKWDispensed * roiCalculatorDto.getKwCost();
		
		double kwGross = grossKWDispensed * roiCalculatorDto.getKwMSRP();
		
		double margin = kwGross - kwCost;
		
		double monthsToPayOff = roiCalculatorDto.getProjectCost() /margin;
		
		double yearsToOff = monthsToPayOff / 12;
		
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
//		grossKWDispensed = Float.valueOf(decimalFormat.format(grossKWDispensed));
		kwCost = Double.valueOf(decimalFormat.format(kwCost));
		kwGross = Double.valueOf(decimalFormat.format(kwGross));
		margin = Double.valueOf(decimalFormat.format(margin));
		monthsToPayOff = Double.valueOf(decimalFormat.format(monthsToPayOff));
		yearsToOff = Double.valueOf(decimalFormat.format(yearsToOff));
		
		
		ROICalculatorResponse roiCalculatorResponse = new ROICalculatorResponse();
		
		roiCalculatorResponse.setGrossKWDispensed(grossKWDispensed);
		roiCalculatorResponse.setKwCost(kwCost);
		roiCalculatorResponse.setKwGross(kwGross);
		roiCalculatorResponse.setMargin(margin);
		roiCalculatorResponse.setMonthsToPayOff(monthsToPayOff);
		roiCalculatorResponse.setYearsToOff(yearsToOff);

		return roiCalculatorResponse;
	}
}
