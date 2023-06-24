package com.flux.roi.calculator.fluxroicalculator.response;

public class ROICalculatorResponse {
	
	private float grossKWDispensed;
	private float kwCost;
	private float kwGross;
	private float margin;
	private float monthsToPayOff;
	private float yearsToOff;
	
	public float getGrossKWDispensed() {
		return grossKWDispensed;
	}
	
	public void setGrossKWDispensed(float grossKWDispensed) {
		this.grossKWDispensed = grossKWDispensed;
	}
	
	public float getKwCost() {
		return kwCost;
	}
	
	public void setKwCost(float kwCost) {
		this.kwCost = kwCost;
	}
	
	public float getKwGross() {
		return kwGross;
	}
	
	public void setKwGross(float kwGross) {
		this.kwGross = kwGross;
	}
	
	public float getMargin() {
		return margin;
	}
	
	public void setMargin(float margin) {
		this.margin = margin;
	}
	
	public float getMonthsToPayOff() {
		return monthsToPayOff;
	}
	
	public void setMonthsToPayOff(float monthsToPayOff) {
		this.monthsToPayOff = monthsToPayOff;
	}
	
	public float getYearsToOff() {
		return yearsToOff;
	}
	
	public void setYearsToOff(float yearsToOff) {
		this.yearsToOff = yearsToOff;
	}
}
