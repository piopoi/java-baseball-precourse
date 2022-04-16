package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * 플레이어의 입력 기능 클래스
 */
public class PlayerInput {
    public List<Integer> inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputStr = Console.readLine();

        if (!validationCheck(inputStr, 3)) {
            throw new IllegalArgumentException();
        }

        return StringArrayToNumberList(inputStr.split(""));
    }

    /**
     * 문자 배열을 숫자 리스트로 변환
     *
     * @param strArr
     * @return
     */
    private List<Integer> StringArrayToNumberList(String[] strArr) {
        List<Integer> rtnList = new ArrayList<>();

        for (String str : strArr) {
            int num = Integer.parseInt(str);
            rtnList.add(num);
        }

        return rtnList;
    }

    /**
     * 플레이어의 입력값 체크
     *
     * @param str
     * @param strLength 문자열 길이
     * @return
     */
    private boolean validationCheck(String str, int strLength) {
        //3글자인지 체크
        if (str.length() != strLength) {
            return false;
        }

        //숫자인지 체크
        if (!str.matches("[+-]?\\d*(\\.\\d+)?")) {
            return false;
        }

        return true;
    }
}
