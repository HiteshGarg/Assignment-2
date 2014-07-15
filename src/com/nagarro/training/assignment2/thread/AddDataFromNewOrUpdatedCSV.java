/**
 * 
 */
package com.nagarro.training.assignment2.thread;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.nagarro.training.assignment2.Constants.Constants;
import com.nagarro.training.assignment2.DTOclasses.CsvFilesDTO;
import com.nagarro.training.assignment2.customException.NewCustomException;
import com.nagarro.training.assignment2.dataStructure.SingletonClass;
import com.nagarro.training.assignment2.flight.Flight;
import com.nagarro.training.assignment2.validators.StringDateConverter;


/**
 * @author hiteshgarg
 * 
 */
public class AddDataFromNewOrUpdatedCSV {

	private BufferedReader reader;

	public void addUpdatedFilesData(CsvFilesDTO csvDto) {

		Map<String, Map<String, Set<Flight>>> flightData;
		SingletonClass singleton = SingletonClass.getInstance();
		/*
		 * Initialize the HashMap stored in SingletonClass if it is null
		 */
		if (singleton.getFlightDataCollection() == null) {
			flightData = new HashMap<String, Map<String, Set<Flight>>>();
			singleton.setFlightDataCollection(flightData);
		}

		/*
		 * If the CSV file in the List is a newly added file than it creates a
		 * new entry in the Hash map assigning filename as Key and initializes a
		 * new sub map - Hash map as Value
		 */
		for (int i = 0; i < csvDto.getUpdatedFiles().size(); i++) {
			if (singleton.getFlightDataCollection().get(
					csvDto.getUpdatedFiles().get(i)) == null) {
				singleton.getFlightDataCollection().put(
						csvDto.getUpdatedFiles().get(i),
						new HashMap<String, Set<Flight>>());
			}

			try {
				readCsvAddData(csvDto.getUpdatedFiles().get(i));
			} catch (NewCustomException exception) {
				exception.printMessage();
			}

		}
	}

	/*
	 * This Method receives filename . Read it Line by Line. Create an object of
	 * Flight class and stores it in the map with the relevant filename as key
	 * For the sub map it creates a key by concatenating Departure Location and
	 * Arrival Location and checks if it exists If the Key exists already the
	 * object is added to the List otherwise a new entry is created in the Outer
	 * Map using Departure Location and Arrival Location as Key.
	 */
	public void readCsvAddData(String csvFile) throws NewCustomException {

		Map<String, Set<Flight>> innerMap = SingletonClass.getInstance()
				.getFlightDataCollection().get(csvFile);
		csvFile = Constants.CSV_FILES_URL + "/" + csvFile;

		try {
			reader = new BufferedReader(new FileReader(csvFile));
			String inputLine = "";
			reader.readLine();

			while ((inputLine = reader.readLine()) != null) {
				String data[] = inputLine.split(Constants.CSV_SPLIT_DELIMITTER);
				Flight flight = new Flight();
				flight.setFlight_no(data[0]);
				flight.setDep_loc(data[1]);
				flight.setArr_loc(data[2]);

				Date date = StringDateConverter.StringToDateConvertor(data[3]);
				if (date == null) {
					continue;
				}
				flight.setValid_till(date);
				flight.setFlight_time(data[4]);
				flight.setFlight_duration(data[5]);
				flight.setFare(Integer.parseInt(data[6]));
				flight.setSeat_avail(data[7]);
				flight.setFlight_class(data[8]);

				String DepArrKey = data[1] + data[2];
				if (!(innerMap.containsKey(DepArrKey))) {
					innerMap.put(DepArrKey, new HashSet<Flight>());
				}
				innerMap.get(DepArrKey).add(flight);
			}
		} catch (FileNotFoundException e) {
			throw new NewCustomException("Sorry the Files are not Found");
		} catch (IOException e) {
			throw new NewCustomException("Unexpected Input Output Exceptions while Reading the File");
		}
	}

}