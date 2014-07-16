/**
 * 
 */
package com.nagarro.training.assignment2.userInterface;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import com.nagarro.training.assignment2.DTOclasses.FlightDTO;
import com.nagarro.training.assignment2.flight.Flight;

/**
 * @author Hitesh
 * 
 */
public class Output {

	public static void outputDisplay(List<Flight> SearchedFlights, FlightDTO dto) {

		if (SearchedFlights == null) {
			System.out.println("No Flights found for given Locations");
		} else if (SearchedFlights.size() == 0) {
			System.out
					.println("Sorry No flight for this combination of Date and Class");
		} else {

			if (dto.getOutputPreferences().equalsIgnoreCase("1")) {
				Collections.sort(SearchedFlights, Flight.FareSorter);

			} else {
				Collections.sort(SearchedFlights,
						Flight.FareDurationSorter);
			}
			System.out.printf("\n|%-10s | %-20s |%-20s |%-20s |%-20s |\n",
					"Flight No", "Valid Till", "Flight Time",
					"Flight Duration", "Fare");
			for (Flight flight : SearchedFlights) {

				int fare = flight.getFare();
				if (dto.getFlightClass().equalsIgnoreCase("b")){
					fare = fare + (int) (0.4 * fare);
				}
					System.out.printf(
							"|%-10s | %-20s |%-20s |%-20s |%-20d |\n",
							flight.getFlight_no(), flight.getValid_till(),
							flight.getFlight_time(),
							flight.getFlight_duration(), fare);
			}
		}
	}

}
