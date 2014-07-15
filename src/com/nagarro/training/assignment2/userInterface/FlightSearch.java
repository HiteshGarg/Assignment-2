/**
 * 
 */
package com.nagarro.training.assignment2.userInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.nagarro.training.assignment2.DTOclasses.FlightDTO;
import com.nagarro.training.assignment2.dataStructure.FlightData;
import com.nagarro.training.assignment2.flight.Flight;

/**
 * @author hiteshgarg
 * 
 */
public class FlightSearch {

	public List<Flight> searchUserFlight(FlightDTO dto) {

		FlightData singleton = FlightData.getInstance();
		String DepArrKey = (dto.getDepLoc() + dto.getArrLoc()).toUpperCase();
		List<Flight> SearchedFlights = new ArrayList<Flight>();

		/*
		 * In the code below the data stored in the Data store is being parsed
		 * by retrieving the inner Map one by one that stores all data related
		 * to a particular csv file. It then checks if the Departure Arrival Key
		 * exists in that particular file. Then it search for the relevant
		 * flight data by comparing the user input Flight class and its date.
		 * Adds all the relevant flights in a List and set it in the dto which
		 * is further passed to the class to display the final List of Searched
		 * Flights
		 */
		for (Map.Entry<String, Map<String, Set<Flight>>> localMap : singleton
				.getFlightDataCollection().entrySet()) {
			for (Map.Entry<String, Set<Flight>> innerMap : localMap.getValue()
					.entrySet()) {

				if (innerMap.getKey().equalsIgnoreCase(DepArrKey)) {
					Set<Flight> flightSet = innerMap.getValue();
					
					Iterator<Flight> iterator = flightSet.iterator();
					while (iterator.hasNext()) {
						Flight flight = iterator.next();
						if ((dto.getFlightDate()
								.before(flight.getValid_till()))
								&& (flight.getFlight_class()
										.contains((CharSequence) dto
												.getFlightClass()
												.toUpperCase()))) {
							SearchedFlights.add(flight);
						}
					}
				}
			}
		}
		
		return SearchedFlights;

	}
}
