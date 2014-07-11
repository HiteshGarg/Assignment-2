/**
 * 
 */
package com.nagarro.training.assignment2.thread;

import java.io.File;
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
import com.nagarro.training.assignment2.flightDTO.FlightDTO;

/**
 * @author hiteshgarg
 * 
 */
public class SearchCsvFiles implements Runnable {
	
	FlightDTO dto;
	Map<String, FileTime> csvListTime =  new HashMap<String, FileTime>();

	public SearchCsvFiles(FlightDTO dto) {
		this.dto = dto;
	}

	
	public void searchCSVinDirectory() {
        try {
            File file = new File(Constants.CSV_FILES_URL);
           
            String[] filenames = file.list();
            for (int i=0; i<filenames.length;i++) {
                if (filenames[i].endsWith(".csv") && (!csvListTime.containsKey(filenames[i]))) {
                    csvListTime.put(filenames[i], null);
                }
           }
            List<String> updatedFiles = new ArrayList<>();
            for(Map.Entry<String, FileTime> map : csvListTime.entrySet()){
            	Path path = Paths.get(Constants.CSV_FILES_URL, map.getKey());
            	BasicFileAttributes fileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
            	
            	if(map.getValue()== null || !map.getValue().equals(fileAttributes.lastModifiedTime())){
            		updatedFiles.add(map.getKey());
            		map.setValue(fileAttributes.lastModifiedTime());
            	}
            }
            dto.setUpdatedFiles(updatedFiles);
            
            if(updatedFiles.size()>0){
            new AddDataFromNewOrUpdatedCSV().addUpdatedFilesData(dto);
            }
//            System.out.println(updatedFiles.size());
        } catch (Exception e) {
        	//TODO Auto Generated Catch Block 
            e.printStackTrace();
        } 
	}

	@Override
	public void run() {
		while (true) {
			try {
				searchCSVinDirectory();
				Thread.sleep(60*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	}
}
