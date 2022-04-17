package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void 컴퓨터_랜덤숫자리스트_생성() {
        Computer computer = new Computer();

        List<Integer> list = computer.getComputerNumber();

        assertThat(list)
                .hasSize(3) //처음 자리 수 체크
                .filteredOn(num -> num > 0 && num < 10) //1~9 사이의 숫자만 필터링
                .hasSize(3); //필터링 후 자리 수 체크
    }
}