package nextstep.fp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LambdaTest {

    private List<Integer> numbers;

    @BeforeEach
    void setup() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    void printAllOld() throws Exception {
        Lambda.printAllOld(numbers);
    }

    @Test
    void printAllLambda() throws Exception {
        Lambda.printAllLambda(numbers);
    }

    @Test
    void runThread() throws Exception {
        Lambda.runThread();
    }

    @Test
    void sumAll() throws Exception {
        int sum = Lambda.sumByCondition(numbers, number -> true);

        assertThat(sum).isEqualTo(21);
    }

    @Test
    void sumAllEven() throws Exception {
        int sum = Lambda.sumByCondition(numbers, number -> number % 2 == 0);

        assertThat(sum).isEqualTo(12);
    }

    @Test
    void sumAllOverThree() throws Exception {
        int sum = Lambda.sumByCondition(numbers, number -> number > 3);

        assertThat(sum).isEqualTo(15);
    }
}
