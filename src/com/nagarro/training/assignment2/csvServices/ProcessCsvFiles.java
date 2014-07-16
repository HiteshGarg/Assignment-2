/**
 * 
 */
package com.nagarro.training.assignment2.csvServices;

/**
 * @author hiteshgarg
 * 
 */
public class ProcessCsvFiles {

	/*
	 * Launches the Thread that read and Add csv files data to the data store
	 */
	public void initiateThreadClass() {

//		SearchCsvFiles fileSearch = new SearchCsvFiles();
		CsvHandler csvFileHandler = new CsvHandler();
		Thread t1 = new Thread(csvFileHandler);
		t1.start();

	}

}
