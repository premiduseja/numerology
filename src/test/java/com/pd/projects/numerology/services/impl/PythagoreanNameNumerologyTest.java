package com.pd.projects.numerology.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PythagoreanNameNumerologyTest {

    private PythagoreanNameNumerology numerology;

    @BeforeEach
    void setUp() {
        numerology = new PythagoreanNameNumerology();
    }

    @Test
    void getNameNumber_ReturnsZero_WhenInputIsNull() {
        assertEquals(0, numerology.getNameNumber(null));
    }

    @Test
    void getNameNumber_ReturnsZero_WhenInputIsEmpty() {
        assertEquals(0, numerology.getNameNumber(""));
    }

    @Test
    void getNameNumber_CalculatesCorrectly_ForSingleLetter() {
        assertEquals(1, numerology.getNameNumber("A"));
        assertEquals(2, numerology.getNameNumber("B"));
        assertEquals(9, numerology.getNameNumber("I"));
    }

    @Test
    void getNameNumber_CaseInsensitive() {
        assertEquals(numerology.getNameNumber("abc"), numerology.getNameNumber("ABC"));
    }

    @Test
    void getNameNumber_CalculatesCorrectly_ForMultipleLetters() {
        // A(1) + B(2) + C(3) = 6
        assertEquals(6, numerology.getNameNumber("ABC"));
        // J(1) + O(6) + H(8) + N(5) = 20 -> 2+0=2
        assertEquals(2, numerology.getNameNumber("John"));
    }

    @Test
    void getNameNumber_HandlesAllAlphabets() {
        // Sum of all mapped values, then reduced to single digit
        assertTrue(numerology.getNameNumber("ABCDEFGHIJKLMNOPQRSTUVWXYZ") > 0);
    }

    @Test
    void getNameNumber_ThrowsException_ForInvalidCharacter() {
        assertThrows(NullPointerException.class, () -> numerology.getNameNumber("A!"));
        assertThrows(NullPointerException.class, () -> numerology.getNameNumber("A1"));
        assertThrows(NullPointerException.class, () -> numerology.getNameNumber("A B"));
    }

    @Test
    void constructor_DoesNotThrow_WhenMapAlreadyInitialized() {
        // Should not throw or reinitialize static map
        new PythagoreanNameNumerology();
    }
}