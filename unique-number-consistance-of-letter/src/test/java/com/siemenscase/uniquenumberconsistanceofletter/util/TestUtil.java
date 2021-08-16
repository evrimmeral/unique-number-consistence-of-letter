package com.siemenscase.uniquenumberconsistanceofletter.util;

import com.siemenscase.uniquenumberconsistanceofletter.service.FileReaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    private static final Logger log = LoggerFactory.getLogger(FileReaderService.class);

    public final static String testMockFilePath = "A path string for moc file service";
    public final static String testRealFilePath = "WordList.txt";

    public final static String invalidCharacterSetWithUpperCase = "ABC";
    public final static String invalidCharacterSetWithNumeric = "1234";
    public final static String invalidCharacterSetSingleCharacter = "a";
    public final static String validCharacterSet = "abc";
    public final static String validCharacterSet2 = "ccaaffddecee";
    public final static String validCharacterSet3 = "aaaabbbb";


    public static String generateTestCharacterSet(String type){
        String charSetForTest = null;

        switch (type){
            case "Upper":
                charSetForTest = invalidCharacterSetWithUpperCase;
                break;
            case "Numeric":
                charSetForTest = invalidCharacterSetWithNumeric;
                break;
            case "Single":
                charSetForTest =  invalidCharacterSetSingleCharacter;
                break;
            case "Valid":
                charSetForTest = validCharacterSet;
                break;
            default:
                log.info("Character Set Test Type should be passed as parameter. Please Update your test case.");
                break;

        }
        return charSetForTest;
    }

    public  static List<String> generateTestWordList(String type){
        List<String> testWords = new ArrayList<>();
        switch (type){
            case "Upper":
                testWords.add(invalidCharacterSetWithUpperCase);
                break;
            case "Numeric":
                testWords.add(invalidCharacterSetWithNumeric);
                break;
            case "Single":
                testWords.add(invalidCharacterSetSingleCharacter);
                break;
            case "Valid":
                testWords.add(validCharacterSet);
                break;
            case "CompositeInvalid":
                testWords.add(invalidCharacterSetSingleCharacter);
                testWords.add(invalidCharacterSetWithNumeric);
                testWords.add(validCharacterSet);
                testWords.add(invalidCharacterSetSingleCharacter);
                break;
            case "CompositeValid":
                testWords.add(validCharacterSet);
                testWords.add(validCharacterSet2);
                testWords.add(validCharacterSet3);
                break;
            default:
                log.info("Character Set Test Type should be passed as parameter. Please Update your test case.");
                break;
        }
        return testWords;
    }
}
