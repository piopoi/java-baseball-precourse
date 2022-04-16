package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class GenerateRandomTest {

    @Test
    void 랜덤_숫자배열_생성() {
        GenerateRandom generateRandom = new GenerateRandom();
        List<Integer> testArr = generateRandom.getRandomNumberList(3);
        assertThat(3).isEqualTo(testArr.size());
    }
}