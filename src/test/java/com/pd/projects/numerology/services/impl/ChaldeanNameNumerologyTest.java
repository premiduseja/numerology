package com.pd.projects.numerology.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChaldeanNameNumerologyTest {

    private ChaldeanNameNumerology numerology;

    @BeforeEach
    void setUp() {
        numerology = new ChaldeanNameNumerology();
    }

    @Test
    void testGetNameNumber_ValidName() {
        int result = numerology.getNameNumber("John");
        assertTrue(result > 0 && result < 10);
    }

    @Test
    void testGetNameNumber_CaseInsensitive() {
        int lower = numerology.getNameNumber("john");
        int upper = numerology.getNameNumber("JOHN");
        assertEquals(lower, upper);
    }

    @Test
    void testGetNameNumber_SingleCharacter() {
        int result = numerology.getNameNumber("A");
        assertTrue(result > 0 && result < 10);
    }

    @Test
    void testGetNameNumber_EmptyString() {
        assertEquals(0, numerology.getNameNumber(""));
    }

    @Test
    void testGetNameNumber_InvalidCharacter() {
        assertThrows(NullPointerException.class, () -> numerology.getNameNumber("John!"));
    }

    @Test
    void reduceNumberSingleDigit_SumsDigitsCorrectly() {
        // 123 -> 1+2+3 = 6
        assertEquals(6, numerology.reduceNumberSingleDigit(123));
        // 987 -> 9+8+7 = 24 -> 2+4 = 6
        assertEquals(6, numerology.reduceNumberSingleDigit(987));
        // 9 -> 9
        assertEquals(9, numerology.reduceNumberSingleDigit(9));
        // 0 -> 0
        assertEquals(0, numerology.reduceNumberSingleDigit(0));
    }
}