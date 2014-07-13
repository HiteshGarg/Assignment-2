/**
 * 
 */
package com.nagarro.training.assignment2.userInterface;

import java.util.Collections;

import com.nagarro.training.assignment2.flight.Flight;
import com.nagarro.training.assignment2.flightDTO.FlightDTO;

/**
 * @author Hitesh
 *
 */
public class Output {

	public static void outputDisplay(FlightDTO dto) {

		if (dto.getSearchedFlights() == null) {
			System.out.println("No Flights found for given Locations");
		} else if (dto.getSearchedFlights().size() == 0) {
			System.out
					.println("Sorry No flight for this combination of Date and Class");
		} else {
			
			if(dto.getOutput_preferences().equalsIgnoreCase("1")){
			Collections.sort(dto.getSearchedFlights(), Flight.FareSorter);
			
			}else{
				Collections.sort(dto.getSearchedFlights(), Flight.FareDurationSorter);
			}
			System.out.printf("\n|%-10s | %-20s |%-20s |%-20s |%-20s |\n",
					"Flight No", "Valid Till", "Flight Time",
					"Flight Duration", "Fare");
			for (Flight flight : dto.getSearchedFlights()) {

				System.out.printf("|%-10s | %-20s |%-20s |%-20s |%-20d |\n",
						flight.getFlight_no(), flight.getValid_till(),
						flight.getFlight_time(), flight.getFlight_duration(),
						flight.getFare());
			}
		}
	}

}
