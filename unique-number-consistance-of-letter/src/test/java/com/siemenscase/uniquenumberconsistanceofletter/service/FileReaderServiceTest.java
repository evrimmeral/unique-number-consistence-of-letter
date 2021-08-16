package com.siemenscase.uniquenumberconsistanceofletter.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class FileReaderServiceTest {


    @InjectMocks
    FileReaderService fileReaderService;

    @Test
    void getWordListFromFile() {
        List<String> expected = Arrays.asList("aaaabbbb","ccaaffddecee","eeee","example","jghvgcbgcb");
        List<String> actual = fileReaderService.getWordListFromFile("WordList.txt");
        Assert.assertEquals(expected,actual);

    }
}