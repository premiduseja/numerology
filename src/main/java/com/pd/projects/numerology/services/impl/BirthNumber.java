package com.pd.projects.numerology.services.impl;

import com.pd.projects.numerology.services.BirthDateNumerology;
import org.springframework.stereotype.Service;

@Service
public class BirthNumber implements BirthDateNumerology {

    /**
     * Provides the birth number for the given date of birth.
     * @param birthdayDate Integer representing the date of birth in the format "dd"
     * @return the single-digit birth number
     */
    @Override
    public int getBirthNumber(int birthdayDate) {
        if (birthdayDate> 31 || birthdayDate < 1) {
            throw new IllegalArgumentException("Birth day number is out of valid range (1-31): " + birthdayDate);
        }
        return reduceNumberSingleDigit(birthdayDate);
    }

    /**
     * Provides the destiny number for the given date of birth.
     * The destiny number is calculated by summing the digits of the date of birth
     * until a single digit is obtained.
     *
     * @param fullBirthDate String representing the date of birth in the format "mm-dd-yyyy" or similar.
     * @return the single-digit destiny number
     */
    @Override
    public int getDestinyNumber(String fullBirthDate) {
        if (fullBirthDate == null || fullBirthDate.isEmpty()) {
            throw new IllegalArgumentException("Full birth date cannot be null or empty");
        }
        String[] dateParts = fullBirthDate.split("-");
        if (dateParts.length < 3) {
            throw new IllegalArgumentException("Full birth date must be in the format 'mm-dd-yyyy'");
        }

        int day = Integer.parseInt(dateParts[1]);
        int month = Integer.parseInt(dateParts[0]);
        int year = Integer.parseInt(dateParts[2]);

        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1) {
            throw new IllegalArgumentException("Invalid date components in full birth date: " + fullBirthDate);
        }

        day= reduceNumberSingleDigit(day);
        month = reduceNumberSingleDigit(month);
        year = reduceNumberSingleDigit(year);
        return reduceNumberSingleDigit(day + month + year);
    }
}
