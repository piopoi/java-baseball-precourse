package baseball.domain;

import baseball.util.Utils;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

/**
 * 플레이어 클래스
 */
public class Player {

    /**
     * Console 입력으로 숫자를 입력받아 List<Integer> 형태로 반환한다.
     *
     * @return 랜덤 숫자 리스트
     */
    public List<Integer> input() {
        System.out.print("숫자를 입력해주세요 : ");

        String inputStr = Console.readLine(); //제약사항에서 가이드한 Console 입력 API 사용

        if (!validationCheck(inputStr)) { //정상적인 값을 입력했는지 체크한다.
            throw new IllegalArgumentException(); //비정상적인 값 입력시 IllegalArgumentException 발생시킨다.
        }

        return Utils.StringArrayToIntegerList(inputStr.split("")); //문자열을 List<Integer> 형태로 변환하여 반환
    }

    /**
     * 입력값 체크
     *
     * @param str 체크할 문자열
     * @return 정상(true), 비정상(false)
     */
    private boolean validationCheck(String str) {
        return Utils.chkStrLength(str, 3) //1. 문자열 길이 체크
                && Utils.isNumber(str);          //2. 숫자 체크
    }

}
