package com.nagarro.training.assignment2.csvServices;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nagarro.training.assignment2.Constants.Constants;
import com.nagarro.training.assignment2.DTOclasses.CsvFilesDTO;
import com.nagarro.training.assignment2.customException.NewCustomException;

/**
 * @author hiteshgarg
 * 
 */
public class SearchCsvFiles implements Runnable {

	/*
	 * Continuously run in background and add the updated or newly added CSV
	 * files in the Data Store
	 */
	
	@Override
	public void run(){
		CsvFilesDTO csvDto = new CsvFilesDTO();
		csvDto.setCsvListTime(new HashMap<String, FileTime>());

		while (true) {
			try {
				/*
				 * Search the Directory after a duration of 1 minute for the
				 * updated or newly added files
				 */
				searchCSVinDirectory(csvDto);
				Thread.sleep(60 * 1000);
			} catch (InterruptedException e) {
				System.out.println("Unexpected Error. Please try again");
			}catch (NewCustomException exception) {
				exception.printMessage();
			}
		}
	}

	
	public void searchCSVinDirectory(CsvFilesDTO csvDto) throws NewCustomException {
		try {
			File file = new File(Constants.CSV_FILES_URL);
			List<String> updatedFiles = new ArrayList<>();

			String[] filenames = file.list();

			/*
			 * Filter out all the csv files newly added csv files and setting
			 * their lastmodified time as null
			 */
			for (int i = 0; i < filenames.length; i++) {
				if (filenames[i].endsWith(".csv")
						&& (!csvDto.getCsvListTime().containsKey(filenames[i]))) {
					csvDto.getCsvListTime().put(filenames[i], null);
				}
			}

			/*
			 * Here we Get the List of all filtered csv files access their
			 * Attributes And if thier Last Modified time is more than the
			 * previously stored time than it adds the filename to Updated Files
			 * List
			 */

			for (Map.Entry<String, FileTime> map : csvDto.getCsvListTime()
					.entrySet()) {
				Path path = Paths.get(Constants.CSV_FILES_URL, map.getKey());
				BasicFileAttributes fileAttributes = Files.readAttributes(path,
						BasicFileAttributes.class);

				if (map.getValue() == null
						|| !map.getValue().equals(
								fileAttributes.lastModifiedTime())) {
					updatedFiles.add(map.getKey());
					map.setValue(fileAttributes.lastModifiedTime());
				}
			}

			csvDto.setUpdatedFiles(updatedFiles);

			/*
			 * If updated files are found then they are added to the Data
			 * Structure
			 */
			if (updatedFiles.size() > 0) {
				new AddDataFromNewOrUpdatedCSV().addUpdatedFilesData(csvDto);
			}
		} catch (IOException e) {
			throw new NewCustomException("Problem in Input output operations of File..Reading File Attributes");
		}
		catch(Exception e){
			throw new NewCustomException("Unexpected Error while reading CSV file attributes");
		}
	}

}
