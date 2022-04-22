package codinginterviews;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class OO2SolutionTest {
    private OO2Solution solution;

    @BeforeEach
    void setUp() {
        solution = new OO2Solution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Hello, my name is John:5",
            "Hello:1",
            "love live! mu'sic forever:4",
            "'':0",
    }, delimiter = ':')
    void countSegments_001(String s, int expected) {
        int result = solution.countSegments(s);
        assertEquals(expected, result);
    }

    @Test
    void countSegments_002() {
        String s = """
               But I must explain to you how all this mistaken idea of denouncing pleasure
               and  praising pain was  born and I will  give you a complete account of the
               system, and expound the actual teachings of the great explorer of the truth,
               the master builder of human  happiness. No one rejects, dislikes, or avoids
               pleasure itself, because it  is pleasure, but because those who do not know
               how to pursue pleasure rationally encounter consequences that are extremely
               painful. Nor again is there anyone who loves or pursues or desires to obtain
               pain of itself, because it is  pain, but because occasionally circumstances
               occur in which toil and pain  can procure him some great  pleasure. To take
               a trivial example, which of us  ever undertakes laborious physical exercise,
               except to obtain some advantage from it? But who has any right to find fault
               with a man who chooses to enjoy a pleasure that has no annoying consequences,
               or one who avoids a pain that produces no resultant pleasure?""";

        int result = solution.countSegments(s);
        int expected = 155;
        assertEquals(expected, result);
    }

    @Test
    void countSegments_003() {
        String s = """
               But                   I must explain to you how all this mistaken idea of
               denouncing pleasure               and  praising pain was  born and I will
               give you a complete account of the                system, and expound the
                               actual teachings of the great explorer of the truth,  the
               master                  builder of human  happiness. No       one rejects,
               dislikes, or avoids             pleasure                itself, because it
               is pleasure, but because those who do not know       how to         pursue
               pleasure                                    rationally           encounter
                           consequences that are extremely                       painful.""";

        int result = solution.countSegments(s);
        int expected = 72;
        assertEquals(expected, result);
    }
}