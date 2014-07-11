/**
 * 
 */
package com.nagarro.training.assignment2.userInterface;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.nagarro.training.assignment2.flight.Flight;
import com.nagarro.training.assignment2.flightDTO.FlightDTO;

/**
 * @author hiteshgarg
 * 
 */
public class FlightSearch {

	public void searchUserFlight(FlightDTO dto) {

		String DepArrKey = (dto.getDep_loc() + dto.getArr_loc()).toUpperCase();
		dto.setSearchedFilghts(null);
		for (Map.Entry<String, Map<String, Set<Flight>>> localMap : dto
				.getFlightDataCollection().entrySet()) {
			for (Map.Entry<String, Set<Flight>> innerMap : localMap.getValue()
					.entrySet()) {
				System.out.println(DepArrKey);

				if (innerMap.getKey().equalsIgnoreCase(DepArrKey)) {
					Set<Flight> flightSet = innerMap.getValue();
					Set<Flight> userSearch;
					
					if(dto.getSearchedFilghts() == null){
						userSearch = new HashSet<>();
					}else{
						userSearch = dto.getSearchedFilghts();
					}   
					
					Iterator<Flight> iterator = flightSet.iterator();
					while (iterator.hasNext()) {
						Flight flight = iterator.next();
						if ((dto.getFlight_date()
								.before(flight.getValid_till()))
								&& (flight.getFlight_class()
										.contains((CharSequence) dto
												.getFlight_class().toUpperCase()))) {
							userSearch.add(flight);
						}
					}
					dto.setSearchedFilghts(userSearch);
				}
			}
		}
		for(Flight flight: dto.getSearchedFilghts()){
			System.out.println(flight.getFlight_no()+" "+flight.getFlight_class()+" "+flight.getFare());
		}
		
//		for(int i = 0 ; i< dto.getSearchedFilghts().size();i++){
//			System.out.println(i +" "+ dto.getSearchedFilghts());
//		}
	}
}
