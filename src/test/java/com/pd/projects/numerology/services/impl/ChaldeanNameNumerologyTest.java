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
}