package com.flux.roi.calculator.fluxroicalculator.dtos;

import lombok.*;


public class ROICalculatorDto {
	private int avgChargingSessionDuration;
	private int stationKWOutput;
	private int noOfChargingStations;
	private int chargingSessionsPerDayPerUnit;
	private int daysOfUsePerMonth;
	private float projectCost;
	private float kwCost;
	private float kwMSRP;
	
	public int getAvgChargingSessionDuration() {
		return avgChargingSessionDuration;
	}
	
	public void setAvgChargingSessionDuration(int avgChargingSessionDuration) {
		this.avgChargingSessionDuration = avgChargingSessionDuration;
	}
	
	public int getStationKWOutput() {
		return stationKWOutput;
	}
	
	public void setStationKWOutput(int stationKWOutput) {
		this.stationKWOutput = stationKWOutput;
	}
	
	public int getNoOfChargingStations() {
		return noOfChargingStations;
	}
	
	public void setNoOfChargingStations(int noOfChargingStations) {
		this.noOfChargingStations = noOfChargingStations;
	}
	
	public int getChargingSessionsPerDayPerUnit() {
		return chargingSessionsPerDayPerUnit;
	}
	
	public void setChargingSessionsPerDayPerUnit(int chargingSessionsPerDayPerUnit) {
		this.chargingSessionsPerDayPerUnit = chargingSessionsPerDayPerUnit;
	}
	
	public int getDaysOfUsePerMonth() {
		return daysOfUsePerMonth;
	}
	
	public void setDaysOfUsePerMonth(int daysOfUsePerMonth) {
		this.daysOfUsePerMonth = daysOfUsePerMonth;
	}
	
	public float getKwCost() {
		return kwCost;
	}
	
	public void setKwCost(float kwCost) {
		this.kwCost = kwCost;
	}
	
	public float getKwMSRP() {
		return kwMSRP;
	}
	
	public void setKwMSRP(float kwMSRP) {
		this.kwMSRP = kwMSRP;
	}
	
	public float getProjectCost() {
		return projectCost;
	}
	
	public void setProjectCost(float projectCost) {
		this.projectCost = projectCost;
	}
}
