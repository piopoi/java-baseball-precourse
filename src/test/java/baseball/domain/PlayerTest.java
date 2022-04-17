package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void 플레이어_입력값_체크() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            try {
                Player player = new Player();
                Method method = player.getClass().getDeclaredMethod("validationCheck", String.class);
                method.setAccessible(true);
                method.invoke(player, "1234"); //validationCheck이 private 메서드이기 때문에 reflect 필요.
            } catch (InvocationTargetException e) {
                //invoke로 호출한 메서드에서 IllegalArgumentException 발생 시 InvocationTargetException이 wrapping 하기 때문에,
                //실제 발생한 IllegalArgumentException을 throw하려면 getTargetException()을 호출해야 한다.
                throw e.getTargetException();
            }
        });
    }
}