package com.siemenscase.uniquenumberconsistanceofletter.service;

import ch.qos.logback.core.util.FileUtil;
import com.siemenscase.uniquenumberconsistanceofletter.exception.ResourceNotFoundException;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * A service to read file resource to construct input string list
 */
@Service
public class FileReaderService {

    private static final Logger log = LoggerFactory.getLogger(FileReaderService.class);

     List<String> getWordListFromFile(String filePath){
        Path path = Paths.get(filePath);
        log.info("Retrieving string list from resource");
        List<String> allLines;
        try {
            allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ResourceNotFoundException("Problem occurred during file reading cause:{} ", e.getCause());
        }
        return removeEmptyLines(allLines);

    }

    //method removes empty lines during constructing string list from file resource
    private List<String> removeEmptyLines(List<String> allLines){
        for(int i =0; i < allLines.size(); i++) {
            if(allLines.get(i).equals("")) {
                allLines.remove(i);
            }
        }
        return allLines;
    }


}
