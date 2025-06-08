package com.pd.projects.numerology.services.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BirthNumberTest {

    // Test cases for getBirthNumber method
    @Test
    void testGetBirthNumber_ValidInput() {
        BirthNumber birthNumber = new BirthNumber();
        assertEquals(5, birthNumber.getBirthNumber(23));
        assertEquals(1, birthNumber.getBirthNumber(10));
    }

    @Test
    void testGetBirthNumber_InvalidInput() {
        BirthNumber birthNumber = new BirthNumber();
        assertThrows(IllegalArgumentException.class, () -> birthNumber.getBirthNumber(32));
        assertThrows(IllegalArgumentException.class, () -> birthNumber.getBirthNumber(0));
    }

    // Test cases for getDestinyNumber method
    @Test
    void testGetDestinyNumber_ValidInput() {
        BirthNumber birthNumber = new BirthNumber();
        assertEquals(4, birthNumber.getDestinyNumber("1990-01-02"));
        assertEquals(8, birthNumber.getDestinyNumber("1999-12-31"));
    }

    @Test
    void testGetDestinyNumber_InvalidInput() {
        BirthNumber birthNumber = new BirthNumber();
        assertThrows(IllegalArgumentException.class, () -> birthNumber.getDestinyNumber("invalid-date"));
        assertThrows(IllegalArgumentException.class, () -> birthNumber.getDestinyNumber(""));
    }

}