package com.siemenscase.uniquenumberconsistanceofletter.service;

import com.siemenscase.uniquenumberconsistanceofletter.util.TestCaseEnums;
import com.siemenscase.uniquenumberconsistanceofletter.util.TestUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class MinimumDeletionNumberServiceTest {

    @InjectMocks
    MinimumDeletionNumberService minimumDeletionNumberService;


    @Test
    void findMinimumDeletionNumber() {
        String validTestWord = TestUtil.generateTestCharacterSet(TestCaseEnums.CharacterSetTypes.VALID.getValue());
        Integer actual = minimumDeletionNumberService.findMinimumDeletionNumber(validTestWord.toCharArray(),validTestWord.length());
        Integer expected = 2;
        Assert.assertEquals(expected,actual);
    }

}