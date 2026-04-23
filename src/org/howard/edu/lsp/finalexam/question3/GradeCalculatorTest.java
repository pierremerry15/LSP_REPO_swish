package org.howard.edu.lsp.finalexam.question3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class GradeCalculatorTest {

    GradeCalculator calc = new GradeCalculator();

    @Test
    @DisplayName("Test average() normal case")
    public void testAverageNormal() {
        assertEquals(85.0, calc.average(80, 90, 85), 0.001);
    }

    @Test
    @DisplayName("Test letterGrade() returns A")
    public void testLetterGradeA() {
        assertEquals("A", calc.letterGrade(95.0));
    }

    @Test
    @DisplayName("Test letterGrade() returns F")
    public void testLetterGradeF() {
        assertEquals("F", calc.letterGrade(55.0));
    }

    @Test
    @DisplayName("Test isPassing() returns true")
    public void testIsPassingTrue() {
        assertTrue(calc.isPassing(75.0));
    }

    @Test
    @DisplayName("Test isPassing() returns false")
    public void testIsPassingFalse() {
        assertFalse(calc.isPassing(55.0));
    }

    @Test
    @DisplayName("Boundary: all scores at 0")
    public void testAverageBoundaryZero() {
        assertEquals(0.0, calc.average(0, 0, 0), 0.001);
    }

    @Test
    @DisplayName("Boundary: isPassing at exactly 60")
    public void testIsPassingAtExactly60() {
        assertTrue(calc.isPassing(60.0));
    }

    @Test
    @DisplayName("Exception: score below 0")
    public void testNegativeScoreThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.average(-1, 50, 50));
    }

    @Test
    @DisplayName("Exception: score above 100")
    public void testScoreOver100Throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.average(101, 50, 50));
    }
}
