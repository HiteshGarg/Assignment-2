/**
 * 
 */
package com.nagarro.training.assignment2.thread;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.nagarro.training.assignment2.Constants.Constants;
import com.nagarro.training.assignment2.flight.Flight;
import com.nagarro.training.assignment2.flightDTO.FlightDTO;

/**
 * @author hiteshgarg
 * 
 */
public class AddDataFromNewOrUpdatedCSV {

	public void addUpdatedFilesData(FlightDTO dto) {
		Map<String, Map<String, Set<Flight>>> flightData;

		if (dto.getFlightDataCollection() == null) {
			flightData = new HashMap<String, Map<String, Set<Flight>>>();
			dto.setFlightDataCollection(flightData);
		}

		for (int i = 0; i < dto.getUpdatedFiles().size(); i++) {
			if (dto.getFlightDataCollection().get(dto.getUpdatedFiles().get(i)) != null) {
				dto.getFlightDataCollection().remove(
						dto.getUpdatedFiles().get(i));
			}
			dto.getFlightDataCollection().put(dto.getUpdatedFiles().get(i),
					new HashMap<String, Set<Flight>>());
			
			readCsvAddData(dto.getUpdatedFiles().get(i), dto);
			
		}
		
/*		for(Map.Entry<String, Map<String, Set<Flight>>> map: dto.getFlightDataCollection().entrySet()){
			for(Map.Entry<String, Set<Flight>> innerMap : map.getValue().entrySet()){
				Set<Flight> innerSet = innerMap.getValue();
				Iterator<Flight> iter = innerSet.iterator();
			    while (iter.hasNext()) {
			     System.out.println(iter.next().getFlight_no());
			    }
			}
		}
*/	}
	
	public void readCsvAddData(String csvFile, FlightDTO dto){
		Map<String, Set<Flight>> innerMap= dto.getFlightDataCollection().get(csvFile);
		csvFile = Constants.CSV_FILES_URL+"/"+csvFile;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(csvFile));
			String inputLine = "";
			reader.readLine();
			while((inputLine=reader.readLine() )!= null){
				String data[] = inputLine.split(Constants.CSV_SPLIT_DELIMITTER);
				Flight flight = new Flight();
				flight.setFlight_no(data[0]);
				flight.setDep_loc(data[1]);
				flight.setArr_loc(data[2]);				
				flight.setValid_till(StringToDateConvertor(data[3]));
				flight.setFlight_time(data[4]);
				flight.setFlight_duration(data[5]);
				flight.setFare(Integer.parseInt(data[6]));
				flight.setSeat_avail(data[7]);
				flight.setFlight_class(data[8]);
				
				String DepArrKey = data[1] + data[2];
				if(!(innerMap.containsKey(DepArrKey))){
					innerMap.put(DepArrKey, new HashSet<Flight>());
				}
				innerMap.get(DepArrKey).add(flight);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR 1");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR 2");
		}
	}
	
	public Date StringToDateConvertor(String input){
			
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
      Date date = new Date();
      try {
          formatter.setLenient(false);
          date = formatter.parse(input);
//          System.out.println(date);
      } catch (ParseException e) {
          System.out.println(Constants.INCORRECT_DATE_ERROR);
          System.out.println("Check for error in files... System is exiting");
          System.exit(1);
//          return null;
      }
      return date;
	}
	
}