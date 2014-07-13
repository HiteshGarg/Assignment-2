/**
 * 
 */
package com.nagarro.training.assignment2.thread;

import com.nagarro.training.assignment2.flightDTO.FlightDTO;

/**
 * @author hiteshgarg
 *
 */
public class ThreadLauncher {
	
	public void initiateThreadClass(FlightDTO dto){
	
		SearchCsvFiles fileSearch = new SearchCsvFiles(dto);
		Thread t1 = new Thread(fileSearch);
		t1.start();			
		
	}

}
