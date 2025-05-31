package com.pd.projects.numerology.contollers;

import com.pd.projects.numerology.NameChartType;
import com.pd.projects.numerology.services.NameNumerology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@SuppressWarnings("unused")
public class NumerologyController {

    @Autowired
    NameNumerology chaldeanNameNumerology;

    @GetMapping("/nameNumber/{nameChartType}/{firstName}")
    public int getNameNumber(@PathVariable("firstName") String firstName,
                             @PathVariable("nameChartType") NameChartType nameChartType){

        int nameNumber=0;

        if (nameChartType == NameChartType.CHALDEAN){
            nameNumber=chaldeanNameNumerology.getNameNumber(firstName);
        }

        return nameNumber;

    }
}
