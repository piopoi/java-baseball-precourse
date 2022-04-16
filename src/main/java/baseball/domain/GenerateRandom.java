package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateRandom {

    /**
     * 3자리 랜덤 수 리스트 생성
     */
    public List<Integer> getRandomNumberList() {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        return list.subList(0, 3);
    }
}
