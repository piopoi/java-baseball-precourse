package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 상대방(컴퓨터) 클래스
 */
public class Computer {

    private List<Integer> computerNumber; //상대방(컴퓨터)의 랜덤숫자

    public Computer() {
        computerNumber = makeRandomNumberList(); //객체 생성 시 랜덤숫자를 생성한다.
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

    /**
     * 랜덤 숫자 리스트 생성
     *
     * @return 랜덤 숫자 리스트
     */
    private List<Integer> makeRandomNumberList() {
        List<Integer> list = new ArrayList<>();

        while (list.size() < 3) { //3자리 숫자를 생성한다.
            int randomNum = Randoms.pickNumberInRange(1, 9); //1~9 사이의 숫자를 선택한다.
            addNotExistsNumber(list, randomNum);
        }

        return list;
    }

    /**
     * num이 list에 없는 숫자라면 list에 추가한다.
     *
     * @param list 랜덤 숫자 리스트
     * @param num 리스트에 추가하고자 하는 숫자
     */
    private void addNotExistsNumber(List<Integer> list, int num) {
        if (!list.contains(num)) {
            list.add(num);
        }
    }
}
