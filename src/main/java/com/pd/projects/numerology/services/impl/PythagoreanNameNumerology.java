package com.pd.projects.numerology.services.impl;

import com.pd.projects.numerology.services.NameNumerology;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Service implementation for calculating name numerology using the Pythagorean system.
 * Provides functionality to compute the numerology number for a given name based on the Pythagorean chart.
 */
@Service
public class PythagoreanNameNumerology implements NameNumerology {

    /**
     * Static map holding the Pythagorean numerology values for each alphabet character.
     */
    private static final Map<Character, Integer> pythagoreanMap = new HashMap<>();

    /**
     * Constructs a new PythagoreanNameNumerology instance and initializes the numerology map if empty.
     */
    public PythagoreanNameNumerology() {
        if (pythagoreanMap.isEmpty()) {
            loadPythagoreanNumerologyMap();
        }
    }

    /**
     * Calculates the numerology number for the given first name using the Pythagorean chart.
     *
     * @param firstName the name for which the numerology number is to be calculated
     * @return the single-digit numerology number, or 0 if the input is null or empty
     */
    @Override
    public int getNameNumber(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            return 0;
        }
        firstName = firstName.toUpperCase();
        int totalNumber = 0;

        for (char c : firstName.toCharArray()) {
            totalNumber = totalNumber + pythagoreanMap.get(c);
        }

        return reduceNumberSingleDigit(totalNumber);
    }

    /**
     * Loads the Pythagorean numerology values into the static map.
     */
    private void loadPythagoreanNumerologyMap() {
        pythagoreanMap.put('A', 1);
        pythagoreanMap.put('B', 2);
        pythagoreanMap.put('C', 3);
        pythagoreanMap.put('D', 4);
        pythagoreanMap.put('E', 5);
        pythagoreanMap.put('F', 6);
        pythagoreanMap.put('G', 7);
        pythagoreanMap.put('H', 8);
        pythagoreanMap.put('I', 9);
        pythagoreanMap.put('J', 1);
        pythagoreanMap.put('K', 2);
        pythagoreanMap.put('L', 3);
        pythagoreanMap.put('M', 4);
        pythagoreanMap.put('N', 5);
        pythagoreanMap.put('O', 6);
        pythagoreanMap.put('P', 7);
        pythagoreanMap.put('Q', 8);
        pythagoreanMap.put('R', 9);
        pythagoreanMap.put('S', 1);
        pythagoreanMap.put('T', 2);
        pythagoreanMap.put('U', 3);
        pythagoreanMap.put('V', 4);
        pythagoreanMap.put('W', 5);
        pythagoreanMap.put('X', 6);
        pythagoreanMap.put('Y', 7);
        pythagoreanMap.put('Z', 8);
    }
}