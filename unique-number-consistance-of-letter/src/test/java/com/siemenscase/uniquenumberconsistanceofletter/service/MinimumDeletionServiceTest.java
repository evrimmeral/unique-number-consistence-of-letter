package com.siemenscase.uniquenumberconsistanceofletter.service;

import com.siemenscase.uniquenumberconsistanceofletter.exception.InvalidCharacterCountException;
import com.siemenscase.uniquenumberconsistanceofletter.exception.InvalidCharacterSetException;
import com.siemenscase.uniquenumberconsistanceofletter.util.TestCaseEnums;
import com.siemenscase.uniquenumberconsistanceofletter.util.TestUtil;
import com.siemenscase.uniquenumberconsistanceofletter.util.ValidationUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class MinimumDeletionServiceTest {


    @InjectMocks
    MinimumDeletionService minimumDeletionService;

    @Mock
    FileReaderService fileReaderService;

    @Mock
    MinimumDeletionNumberService minimumDeletionNumberService;

    @Mock
    ValidationUtil validationUtil;


    @Test
    void whenCharacterSetIsInUpperCase_thenReturn_InvalidCharacterSetException() throws InvalidCharacterSetException, InvalidCharacterCountException {

        Mockito.doReturn(TestUtil.generateTestWordList(TestCaseEnums.CharacterSetTypes.UPPER.getValue())).when(fileReaderService).getWordListFromFile(TestUtil.testMockFilePath);
        Mockito.when(minimumDeletionService.getMinimumDeletionNumberList(TestUtil.testMockFilePath)).thenThrow(new InvalidCharacterSetException("Word characters should be between [a z] and lowercase "));

    }

    @Test
    void whenCharacterSetIsInLessThanOneCharacter_thenReturn_InvalidCharacterSetException() throws InvalidCharacterSetException, InvalidCharacterCountException {

        Mockito.doReturn(TestUtil.generateTestWordList(TestCaseEnums.CharacterSetTypes.SINGLE.getValue())).when(fileReaderService).getWordListFromFile(TestUtil.testMockFilePath);
        Mockito.when(minimumDeletionService.getMinimumDeletionNumberList(TestUtil.testMockFilePath)).thenThrow(new InvalidCharacterCountException("Word character count should be between 1 and 300000"));

    }

    @Test
    void whenCharacterSetIsNumeric_thenReturn_InvalidCharacterSetException() throws InvalidCharacterSetException, InvalidCharacterCountException {

        Mockito.doReturn(TestUtil.generateTestWordList(TestCaseEnums.CharacterSetTypes.NUMERIC.getValue())).when(fileReaderService).getWordListFromFile(TestUtil.testMockFilePath);
        Mockito.when(minimumDeletionService.getMinimumDeletionNumberList(TestUtil.testMockFilePath)).thenThrow(new InvalidCharacterSetException("Word characters should be between [a z] and lowercase "));

    }

    @Test
    void whenCharacterSetIsInValidComposite_thenReturn_InvalidCharacterSetException() throws InvalidCharacterSetException, InvalidCharacterCountException {

        Mockito.doReturn(TestUtil.generateTestWordList(TestCaseEnums.CharacterSetTypes.COMPOSITE_INVALID.getValue())).when(fileReaderService).getWordListFromFile(TestUtil.testMockFilePath);
        Mockito.when(minimumDeletionService.getMinimumDeletionNumberList(TestUtil.testMockFilePath)).thenThrow(new InvalidCharacterSetException("Word characters should be between [a z] and lowercase "));

    }

    @Test
    void whenCharacterSetIsValidComposite_thenReturn_ResultList() throws InvalidCharacterSetException, InvalidCharacterCountException {

        Mockito.doReturn(TestUtil.generateTestWordList(TestCaseEnums.CharacterSetTypes.COMPOSITE_VALID.getValue())).when(fileReaderService).getWordListFromFile(TestUtil.testMockFilePath);
        List<Integer> expected = Arrays.asList(0,0,0);
        List<Integer> actual = minimumDeletionService.getMinimumDeletionNumberList(TestUtil.testMockFilePath);
        Assert.assertEquals(expected,actual);
    }

}