package com.pd.projects.numerology.services.impl;

import com.pd.projects.numerology.services.NameNumerology;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChaldeanNameNumerology implements NameNumerology {

    private static final Map<Character,Integer> chaldeanChart=new HashMap<>();

    public ChaldeanNameNumerology(){
        if(chaldeanChart.isEmpty()){
            createChart();
        }

    }

    /**
     * Provides name number as per Chaldean chart for a given name string.
     * @param firstName String type first name whose name number is requested
     * @return name number calculated using Chaldean chart.
     */
    @Override
    public int getNameNumber(String firstName) {

        char[] characters = firstName.toLowerCase().toCharArray();
        int totalSum=0;

        for(char c:characters){
            totalSum=totalSum+chaldeanChart.get(c);
        }

        return reduceNumberSingleDigit(totalSum);
    }

    /**
     * Helper method to create Chaldean chart map
     */
    private void createChart(){

        chaldeanChart.put('a',1);
        chaldeanChart.put('i',1);
        chaldeanChart.put('j',1);
        chaldeanChart.put('q',1);
        chaldeanChart.put('y',1);

        chaldeanChart.put('b',2);
        chaldeanChart.put('k',2);
        chaldeanChart.put('r',2);

        chaldeanChart.put('c',3);
        chaldeanChart.put('g',3);
        chaldeanChart.put('l',3);
        chaldeanChart.put('s',3);

        chaldeanChart.put('d',4);
        chaldeanChart.put('m',4);
        chaldeanChart.put('t',4);

        chaldeanChart.put('h',5);
        chaldeanChart.put('e',5);
        chaldeanChart.put('n',5);
        chaldeanChart.put('x',5);

        chaldeanChart.put('u',6);
        chaldeanChart.put('v',6);
        chaldeanChart.put('w',6);

        chaldeanChart.put('o',7);
        chaldeanChart.put('z',7);

        chaldeanChart.put('f',8);
        chaldeanChart.put('p',8);

    }
}
