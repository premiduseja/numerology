package com.pd.projects.numerology.contollers;

import com.pd.projects.numerology.NameChartType;
import com.pd.projects.numerology.services.BirthDateNumerology;
import com.pd.projects.numerology.services.NameNumerology;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class NumerologyControllerTest {

    private NumerologyController controller;
    private NameNumerology chaldeanNameNumerology;
    private NameNumerology pythagoreanNameNumerology;
    private BirthDateNumerology birthNumberNumerology;

    @BeforeEach
    void setUp() {
        chaldeanNameNumerology = mock(NameNumerology.class);
        pythagoreanNameNumerology = mock(NameNumerology.class);
        birthNumberNumerology = mock(BirthDateNumerology.class);

        controller = new NumerologyController();
        controller.chaldeanNameNumerology = chaldeanNameNumerology;
        controller.pythagoreanNameNumerology = pythagoreanNameNumerology;
        controller.birthNumberNumerology = birthNumberNumerology;
    }

    @Test
    void getNameNumber_UsesChaldean_WhenTypeIsChaldean() {
        when(chaldeanNameNumerology.getNameNumber("Alice")).thenReturn(5);
        int result = controller.getNameNumber("Alice", NameChartType.CHALDEAN);
        assertEquals(5, result);
        verify(chaldeanNameNumerology).getNameNumber("Alice");
        verifyNoInteractions(pythagoreanNameNumerology);
    }

    @Test
    void getNameNumber_UsesPythagorean_WhenTypeIsPythagorean() {
        when(pythagoreanNameNumerology.getNameNumber("Bob")).thenReturn(7);
        int result = controller.getNameNumber("Bob", NameChartType.PYTHAGOREAN);
        assertEquals(7, result);
        verify(pythagoreanNameNumerology).getNameNumber("Bob");
        verifyNoInteractions(chaldeanNameNumerology);
    }

    @Test
    void getNameNumber_ReturnsZero_WhenTypeIsUnknown() {
        int result = controller.getNameNumber("Charlie", null);
        assertEquals(0, result);
        verifyNoInteractions(chaldeanNameNumerology, pythagoreanNameNumerology);
    }

    @Test
    void getBirthNumber_DelegatesToService() {
        when(birthNumberNumerology.getBirthNumber(15)).thenReturn(6);
        int result = controller.getBirthNumber(15);
        assertEquals(6, result);
        verify(birthNumberNumerology).getBirthNumber(15);
    }

    @Test
    void getDestinyNumber_DelegatesToService() {
        when(birthNumberNumerology.getDestinyNumber("01-01-2000")).thenReturn(4);
        int result = controller.getDestinyNumber("01-01-2000");
        assertEquals(4, result);
        verify(birthNumberNumerology).getDestinyNumber("01-01-2000");
    }
}