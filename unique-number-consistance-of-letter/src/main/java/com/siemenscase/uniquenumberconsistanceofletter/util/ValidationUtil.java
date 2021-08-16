package com.siemenscase.uniquenumberconsistanceofletter.util;

import com.siemenscase.uniquenumberconsistanceofletter.exception.InvalidCharacterCountException;
import com.siemenscase.uniquenumberconsistanceofletter.exception.InvalidCharacterSetException;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;


/**
 *
 */
@Service
public class ValidationUtil {
    private static final Logger log = LoggerFactory.getLogger(ValidationUtil.class);

    public ValidationUtil(){super();}


    public static Boolean isNullOrEmpty(final Object obj){
        if(obj == null){
            return true;
        }else if(obj instanceof String && Strings.isEmpty((String) obj)){
            return true;
        }
        return false;
    }

    /**
     *
     */
    public static Boolean validateStringLength(String word) throws InvalidCharacterCountException {

        if (word.length() < 1 && word.length() > 300000 ){
            throw new InvalidCharacterCountException("Word character count should be between 1 and 300000");
        }return true;

    }

    /**
     *
     */
    public static Boolean validateWordCharacters(String word) throws InvalidCharacterSetException {
        if (!isMatchingRegex(word)){
            throw new InvalidCharacterSetException("Word characters should be between [a z] and lowercase ");
        }return true;

    }

    private static boolean isMatchingRegex(String input) {
        boolean inputMatches = true;
        Pattern inputRegex = Pattern.compile(".*[a-z].*");

            if (!inputRegex.matcher(input).matches()) {
                inputMatches = false;
            }

        return inputMatches;
    }



    public Boolean validateWord(String word) throws InvalidCharacterCountException, InvalidCharacterSetException {
        if(isNullOrEmpty(word)) {
            log.info("Word can not be null or empty ");
            return false;
        }else if (!validateStringLength(word)){
            return false;

        }else if(!validateWordCharacters(word)){
            return false;
        }
        return true;
    }

}

