/**
 * 
 */
package com.nagarro.training.assignment2.flightDTO;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.nagarro.training.assignment2.flight.Flight;


/**
 * @author hiteshgarg
 *
 */
public class FlightDTO {

	private String dep_loc;
	private String arr_loc;
	private Date flight_date;
	private String flight_class;
	private String output_preferences;
	private Map<String, Map<String, Set<Flight>>> flightDataCollection;
	private Set<Flight> searchedFilghts;
	private List<String> updatedFiles;
	
	/**
	 * @return the searchedFilghts
	 */
	public Set<Flight> getSearchedFilghts() {
		return searchedFilghts;
	}
	/**
	 * @param searchedFilghts the searchedFilghts to set
	 */
	public void setSearchedFilghts(Set<Flight> searchedFilghts) {
		this.searchedFilghts = searchedFilghts;
	}
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
	/**
	 * @return the updatedFiles
	 */
	public List<String> getUpdatedFiles() {
		return updatedFiles;
	}
	/**
	 * @param updatedFiles the updatedFiles to set
	 */
	public void setUpdatedFiles(List<String> updatedFiles) {
		this.updatedFiles = updatedFiles;
	}
	/**
	 * @return the dep_loc
	 */
	public String getDep_loc() {
		return dep_loc;
	}
	/**
	 * @param dep_loc the dep_loc to set
	 */
	public void setDep_loc(String dep_loc) {
		this.dep_loc = dep_loc;
	}
	/**
	 * @return the arr_loc
	 */
	public String getArr_loc() {
		return arr_loc;
	}
	/**
	 * @param arr_loc the arr_loc to set
	 */
	public void setArr_loc(String arr_loc) {
		this.arr_loc = arr_loc;
	}
	/**
	 * @return the flight_date
	 */
	public Date getFlight_date() {
		return flight_date;
	}
	/**
	 * @param flight_date the flight_date to set
	 */
	public void setFlight_date(Date flight_date) {
		this.flight_date = flight_date;
	}
	/**
	 * @return the flight_class
	 */
	public String getFlight_class() {
		return flight_class;
	}
	/**
	 * @param flight_class the flight_class to set
	 */
	public void setFlight_class(String flight_class) {
		this.flight_class = flight_class;
	}
	/**
	 * @return the output_preferences
	 */
	public String getOutput_preferences() {
		return output_preferences;
	}
	/**
	 * @param output_preferences the output_preferences to set
	 */
	public void setOutput_preferences(String output_preferences) {
		this.output_preferences = output_preferences;
	}
	
}
