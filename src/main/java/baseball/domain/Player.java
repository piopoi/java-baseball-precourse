package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
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

        validationCheck(inputStr); //정상적인 값이 입력되었는지 체크

        return stringArrayToIntegerList(inputStr.split("")); //문자열을 List<Integer> 형태로 변환하여 반환
    }

    /**
     * 입력값 체크
     *
     * @param str 체크할 문자열
     */
    private void validationCheck(String str) {
        //3자리 숫자 체크
        if (!str.matches("\\d{3}")) {
            //비정상적인 값 입력시 IllegalArgumentException 발생시킨다.
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }
    }

    /**
     * 문자 배열을 숫자 리스트로 변환
     *
     * @param strArr 변환할 문자열
     * @return 숫자 리스트 형태로 반환
     */
    private List<Integer> stringArrayToIntegerList(String[] strArr) {
        List<Integer> rtnList = new ArrayList<>();

        for (String str : strArr) {
            int num = Integer.parseInt(str); //문자를 숫자로 변환한다.
            rtnList.add(num);
        }

        return rtnList;
    }
}
