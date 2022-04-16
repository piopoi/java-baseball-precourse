package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GenerateRandomTest {

    @Test
    void 랜덤_숫자배열_생성() {
        GenerateRandom generateRandom = new GenerateRandom();
        int[] testArr = generateRandom.getRandomNumberArr();
        assertThat(3).isEqualTo(testArr.length);
    }
}