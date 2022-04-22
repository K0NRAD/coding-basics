package codinginterviews;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class OO1SolutionTest {
    private OO1Solution solution;

    @BeforeEach
    void setUp() {
        solution = new OO1Solution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "42:42",
            "-42:-42",
            "+42:42",
            "  -42:-42",
            "    + 42:0",
            "              - + - + +2147483699:0",
            "4193 with words:4193",
            "-0815 is the number:-815",
            "                     +140459  -3444444 Hallo Welt:140459",
            "The answer to all questions is 42:0",
            "          + -4000:0",
            "     +2147483699:2147483647",
            "                -2147483699:-2147483648",
            "     +2147483699 this fits that doesn't fit in a 32-bit integer variable   :2147483647",
            "                -2147483699 that doesn't fit in a 32-bit integer variable     :-2147483648"
    }, delimiter = ':')
    public void test001(String numString, int expected) {
        int result = solution.atoi(numString);
        assertEquals(expected, result);
    }
}