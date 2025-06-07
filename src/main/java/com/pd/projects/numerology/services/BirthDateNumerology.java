package com.pd.projects.numerology.services;

/**
 * Interface for calculating the birth number based on a date of birth.
 * The birth number is derived from the digits of the date of birth
 * and is reduced to a single digit.
 */
public interface BirthDateNumerology extends Numerology {
    /**
     * Provides the birth number for the given date of birth.
     * The birth number is calculated by summing the digits of the date of birth
     * until a single digit is obtained.
     *
     * @param birthdayDate Integer representing the date of birth in the format "dd"
     * @return the single-digit birth number
     */
    int getBirthNumber(int birthdayDate);

    /**
     * Provides the birth number for the given date of birth.
     * The birth number is calculated by summing the digits of the date of birth
     * until a single digit is obtained.
     *
     * @param fullBirthDate String representing the date of birth in the format "mm-dd-yyyy" or similar.
     * @return the single-digit birth number
     */
    int getDestinyNumber(String fullBirthDate);
}
