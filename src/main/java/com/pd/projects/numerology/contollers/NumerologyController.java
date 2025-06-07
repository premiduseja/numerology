package com.pd.projects.numerology.contollers;

import com.pd.projects.numerology.NameChartType;
import com.pd.projects.numerology.services.BirthDateNumerology;
import com.pd.projects.numerology.services.NameNumerology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to handle requests related to name numerology calculations.
 * It provides endpoints to calculate the name number based on different numerology systems.
 */
@RestController
@RequestMapping("api/v1/numerology")
@SuppressWarnings("unused")
public class NumerologyController {

    @Autowired
    NameNumerology chaldeanNameNumerology;

    @Autowired
    NameNumerology pythagoreanNameNumerology;

    @Autowired
    BirthDateNumerology birthNumberNumerology;

    /**
     * Endpoint to get the name number based on the specified name chart type and first name.
     *
     * @param firstName The first name for which the name number is to be calculated.
     * @param nameChartType The type of numerology system to use (Chaldean or Pythagorean).
     * @return The calculated name number.
     */
    @GetMapping("/nameNumber/{nameChartType}/{firstName}")
    public int getNameNumber(@PathVariable("firstName") String firstName,
                             @PathVariable("nameChartType") NameChartType nameChartType){

        int nameNumber=0;

        if (nameChartType == NameChartType.CHALDEAN){
            nameNumber=chaldeanNameNumerology.getNameNumber(firstName);
        }else if (nameChartType == NameChartType.PYTHAGOREAN){
            nameNumber=pythagoreanNameNumerology.getNameNumber(firstName);
        }
        return nameNumber;

    }

    /**
     * Endpoint to get the birth number based on the provided birthday.
     *
     * @param birthDayDd The birthday as an integer.
     * @return The calculated birth number.
     */
    @GetMapping("/birthNumber/{birthDayDd}")
    public int getBirthNumber(@PathVariable("birthDayDd") int birthDayDd) {
        return birthNumberNumerology.getBirthNumber(birthDayDd);
    }

    /**
     * Endpoint to get the destiny number based on the provided birth date.
     *
     * @param dateOfBirth The date of birth in any format separated by '-'.
     * @return The calculated destiny number.
     *
     */
    @GetMapping("/destinyNumber/{dateOfBirth}")
    public int getDestinyNumber(@PathVariable("dateOfBirth") String dateOfBirth) {
        return birthNumberNumerology.getDestinyNumber(dateOfBirth);
    }


}
