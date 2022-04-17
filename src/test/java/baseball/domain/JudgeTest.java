package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JudgeTest {
    Judge judge;
    List<Integer> computerNumList;
    List<Integer> playerNumList;

    @BeforeEach
    public void beforeEach() {
        judge = new Judge();

        //테스트 데이터 : 1볼 1스트라이크
        computerNumList = new ArrayList<>();
        computerNumList.add(1);
        computerNumList.add(2);
        computerNumList.add(3);

        playerNumList = new ArrayList<>();
        playerNumList.add(1);
        playerNumList.add(4);
        playerNumList.add(2);
    }

    @Test
    void 결과판정_3스트라이크_아닌_경우() {
        boolean result = judge.judgment(computerNumList, playerNumList);

        assertThat(result).isFalse();
    }

    @Test
    void 결과판정_3스트라이크인_경우() {
        List<Integer> newPlayerNumList = new ArrayList<>();
        newPlayerNumList.add(1);
        newPlayerNumList.add(2);
        newPlayerNumList.add(3);

        boolean result = judge.judgment(computerNumList, newPlayerNumList);

        assertThat(result).isTrue();
    }

    @Test
    void 스트라이크_개수_세기() {
        try {
            //Test private method
            Method method = judge.getClass().getDeclaredMethod("countingStrike", List.class, List.class);
            method.setAccessible(true);
            int strikeCount = (int) method.invoke(judge, computerNumList, playerNumList);

            assertThat(strikeCount).isEqualTo(1);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void 볼_개수_세기() {
        try {
            //Test private method
            Method method = judge.getClass().getDeclaredMethod("countingBall", int.class, List.class, List.class);
            method.setAccessible(true);
            int ballCount = (int) method.invoke(judge, 1, computerNumList, playerNumList);

            assertThat(ballCount).isEqualTo(1);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}