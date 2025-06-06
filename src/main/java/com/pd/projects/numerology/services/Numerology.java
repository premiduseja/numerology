package com.pd.projects.numerology.services;

public interface Numerology {

    /**
     * Reduces any number to single digit by using numerology way for reduction
     * @param number Integer number to be reduced
     * @return single digit reduced integer
     */
    default int reduceNumberSingleDigit(int number){
        int reducedNumber = 0;
        while ( number > 0){
            reducedNumber=reducedNumber+number%10;
            number=number/10;
        }
        // If the reduced number is greater than 9, reduce it again
        if (reducedNumber > 9) {
            reducedNumber = reduceNumberSingleDigit(reducedNumber);
        }
        return reducedNumber;
    }
}
