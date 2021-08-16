package com.siemenscase.uniquenumberconsistanceofletter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Service to find Number of letters that must be deleted from a word to
 * create a word in which no two letters occur the same number of times
 * is being calculated.
 * Greedy algorithm is implemented with O(N) complexity
 */

@Service
public class MinimumDeletionNumberService {
    private static final Logger log = LoggerFactory.getLogger(MinimumDeletionNumberService.class);

     Integer findMinimumDeletionNumber(char[] word, Integer N) throws RuntimeException {
        log.info("Algorithm applied to find minimum deletion: \n");
        HashMap<Character, Integer> numberOfEachCharacter = new HashMap<>();
        PriorityQueue<Integer> priorityOfEachCharacter = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

        //Setting repetition of each unique character in the char set
        Integer toBeDeleted = 0;
        for (int i = 0; i < N; i++)
        {
            if(numberOfEachCharacter.containsKey(word[i]))
            {
                numberOfEachCharacter.put(word[i], numberOfEachCharacter.get(word[i]) + 1);
            }
            else
            {
                numberOfEachCharacter.put(word[i], 1);
            }
        }

        //Setting repetition of each unique character in the char set with priority
        for (Map.Entry<Character, Integer> it : numberOfEachCharacter.entrySet())
        {
            priorityOfEachCharacter.add(it.getValue());
        }


        //The minimum number of letters should be returned that must be deleted to obtain a
         // word in which every letter occurs a unique number of times.
        while (!priorityOfEachCharacter.isEmpty())
        {
            int priority = priorityOfEachCharacter.peek();
            priorityOfEachCharacter.remove();
            if (priorityOfEachCharacter.isEmpty()) {
                return toBeDeleted;
            }
            if (priority == priorityOfEachCharacter.peek())
            {
                if (priority > 1)
                {
                    priorityOfEachCharacter.add(priority - 1);
                }
                toBeDeleted++;
            }
        }
        return toBeDeleted;
    }
}
