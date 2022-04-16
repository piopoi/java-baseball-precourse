package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateRandom {

    /**
     * 3자리 랜덤 수 배열 생성
     */
    public int[] getRandomNumberArr() {
        List<Integer> numberList = getRandomNumberList();

        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = numberList.get(i);
        }

        return arr;
    }

    /**
     * 서로 다른 1부터 9까지의 숫자를 랜덤하게 정렬한 List 생성
     */
    private List<Integer> getRandomNumberList() {
        List<Integer> numberList = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            numberList.add(i);
        }

        Collections.shuffle(numberList);

        return numberList;
    }
}
