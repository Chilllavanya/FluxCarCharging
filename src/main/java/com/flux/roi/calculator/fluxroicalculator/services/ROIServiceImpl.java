package com.flux.roi.calculator.fluxroicalculator.services;

import com.flux.roi.calculator.fluxroicalculator.dtos.ROICalculatorDto;
import com.flux.roi.calculator.fluxroicalculator.response.ROICalculatorResponse;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class ROIServiceImpl implements ROIService{
	
	@Override
	public ROICalculatorResponse calculateROI(ROICalculatorDto roiCalculatorDto) {
		
		
		int grossKWDispensed  = roiCalculatorDto.getAvgChargingSessionDuration()
				* roiCalculatorDto.getStationKWOutput()
				* roiCalculatorDto.getNoOfChargingStations()
				* roiCalculatorDto.getChargingSessionsPerDayPerUnit()
				* roiCalculatorDto.getDaysOfUsePerMonth();

		
		float kwCost = grossKWDispensed * roiCalculatorDto.getKwCost();
		
		float kwGross = grossKWDispensed * roiCalculatorDto.getKwMSRP();
		
		float margin = kwGross - kwCost;
		
		float monthsToPayOff = roiCalculatorDto.getProjectCost() /margin;
		
		float yearsToOff = monthsToPayOff / 12;
		
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		monthsToPayOff = Float.valueOf(decimalFormat.format(monthsToPayOff));
		
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
