/**
 * 
 */
package com.nagarro.training.assignment2.dataStructure;

import java.util.Map;
import java.util.Set;

import com.nagarro.training.assignment2.flight.Flight;

/**
 * @author hiteshgarg
 * 
 */
public class FlightData {
	/*
	 * Instance of Singleton Class
	 */
	private static FlightData singletonInstance;
	/*
	 * Map to store Filenames as the Key and a Sub map as a value. Further that
	 * inner map stores Departure Arrival String as key and Set of relative
	 * Flights form that particular CSV file as its value
	 */
	private Map<String, Map<String, Set<Flight>>> flightDataCollection;

	/**
	 * @return the flightDataCollection
	 */
	public Map<String, Map<String, Set<Flight>>> getFlightDataCollection() {
		return flightDataCollection;
	}

	/**
	 * @param flightDataCollection
	 *            the flightDataCollection to set
	 */
	public void setFlightDataCollection(
			Map<String, Map<String, Set<Flight>>> flightDataCollection) {
		this.flightDataCollection = flightDataCollection;
	}

	public static synchronized FlightData getInstance() {
		if (null == singletonInstance) {
			singletonInstance = new FlightData();
		}
		return singletonInstance;
	}

}
