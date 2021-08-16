package com.siemenscase.uniquenumberconsistanceofletter.service;

import com.siemenscase.uniquenumberconsistanceofletter.exception.InvalidCharacterCountException;
import com.siemenscase.uniquenumberconsistanceofletter.exception.InvalidCharacterSetException;
import com.siemenscase.uniquenumberconsistanceofletter.util.ValidationUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service to read file resource to retrieve string list,
 * Validate each element of list as an input and implement
 * minimum deletion number finding algorithm on each item.
 *
 */

@Service
public class MinimumDeletionService {
    private static final Logger log = LoggerFactory.getLogger(MinimumDeletionService.class);

    private ValidationUtil validationUtil;
    private FileReaderService fileReaderService;
    private MinimumDeletionNumberService minimumDeletionNumberService;

    @Autowired
    public MinimumDeletionService(ValidationUtil validationUtil, FileReaderService fileReaderService, MinimumDeletionNumberService minimumDeletionNumberService) {
        this.validationUtil = validationUtil;
        this.fileReaderService = fileReaderService;
        this.minimumDeletionNumberService = minimumDeletionNumberService;
    }


    public List<Integer> getMinimumDeletionNumberList(String filePath) throws InvalidCharacterSetException, InvalidCharacterCountException {

        log.info("Number of letters that must be deleted from a word to create a word in which no two letters occur the same number of times is being calculated: \n");
        List<String> wordList = fileReaderService.getWordListFromFile(filePath);
        List<Integer> deletionNumberList = new ArrayList<>();
        for(String word: wordList){
            validationUtil.validateWord(word);// Each validation step is being applied for each word
            deletionNumberList.add(minimumDeletionNumberService.findMinimumDeletionNumber(word.toCharArray(),word.length())); //Algorithm is being applied for each word
        }
        return deletionNumberList;
    }


}
