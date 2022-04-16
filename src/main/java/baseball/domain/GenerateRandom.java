package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 랜덤 숫자 생성 클래스
 */
public class GenerateRandom {

    /**
     * 랜덤 숫자 리스트 생성
     *
     * @param listSize 생성할 리스트 크기
     * @return
     */
    public List<Integer> getRandomNumberList(int listSize) {
        List<Integer> list = new ArrayList<>();

        while (list.size() < listSize) {
            int num = Randoms.pickNumberInRange(1, 9);
            addNotExistsNumber(list, num);
        }
        
        return list;
    }

    /**
     * 리스트에 없는 숫자만 추가
     *
     * @param list
     */
    private void addNotExistsNumber(List<Integer> list, int num) {
        if (!list.contains(num)) {
            list.add(num);
        }
    }
}
