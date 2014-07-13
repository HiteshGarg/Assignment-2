/**
 * 
 */
package com.nagarro.training.assignment2.userInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.nagarro.training.assignment2.dataStructure.SingletonClass;
import com.nagarro.training.assignment2.flight.Flight;
import com.nagarro.training.assignment2.flightDTO.FlightDTO;

/**
 * @author hiteshgarg
 * 
 */
public class FlightSearch {

	public void searchUserFlight(FlightDTO dto) {

		SingletonClass singleton = SingletonClass.getInstance();
		String DepArrKey = (dto.getDep_loc() + dto.getArr_loc()).toUpperCase();
		dto.setSearchedFlights(null); // Removing any previously searched data
										// in the Set

		/*
		 * Settin
		 */
		for (Map.Entry<String, Map<String, Set<Flight>>> localMap : singleton
				.getFlightDataCollection().entrySet()) {

			for (Map.Entry<String, Set<Flight>> innerMap : localMap.getValue()
					.entrySet()) {

				if (innerMap.getKey().equalsIgnoreCase(DepArrKey)) {
					Set<Flight> flightSet = innerMap.getValue();
					List<Flight> userSearch;

					if (dto.getSearchedFlights() == null) {
						/*
						 * List(ArrayList) is taken so that we could sort the
						 * Collection Based in user preference
						 */
						userSearch = new ArrayList<Flight>();
					} else {
						userSearch = dto.getSearchedFlights();
					}

					Iterator<Flight> iterator = flightSet.iterator();
					while (iterator.hasNext()) {
						Flight flight = iterator.next();
						if ((dto.getFlight_date().before(flight.getValid_till()))
								&& (flight.getFlight_class().contains((CharSequence) dto.getFlight_class().toUpperCase()))) {
							userSearch.add(flight);
						}
					}
					dto.setSearchedFlights(userSearch);
				}
			}
		}
		
		Output.outputDisplay(dto);
		
	}
}
