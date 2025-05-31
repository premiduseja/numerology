package com.pd.projects.numerology.services;

public interface NameNumerology extends Numerology {
    /**
     * Provide name number for the given first name string
     * @param firstName String type first name whose name number is requested
     * @return name number
     */
    int getNameNumber(String firstName);
}
