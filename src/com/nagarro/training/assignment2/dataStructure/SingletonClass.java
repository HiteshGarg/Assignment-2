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
public class SingletonClass {
	
	private static SingletonClass singletonInstance;	//Instance of Singleton Class
	//Map to store Filenames and a Submap that stores Departure Arrival key and Set of relative Flights
	private Map<String, Map<String, Set<Flight>>> flightDataCollection;		

	
	/**
	 * @return the flightDataCollection
	 */
	public Map<String, Map<String, Set<Flight>>> getFlightDataCollection() {
		return flightDataCollection;
	}

	/**
	 * @param flightDataCollection the flightDataCollection to set
	 */
	public void setFlightDataCollection(
			Map<String, Map<String, Set<Flight>>> flightDataCollection) {
		this.flightDataCollection = flightDataCollection;
	}

	public static synchronized SingletonClass getInstance(){
		if(null == singletonInstance){
			singletonInstance = new SingletonClass();
		}
		return singletonInstance;
	}


}
