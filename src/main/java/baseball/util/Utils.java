package baseball.util;

import java.util.List;

public class Utils {

    /**
     * 문자열 길이 체크
     *
     * @param str    체크할 문자열
     * @param length 문자열 크기
     * @return 문자열 크기가 length와 같으면 true, 아니면 false
     */
    public static boolean chkStrLength(String str, int length) {
        return str.length() == length;
    }

    /**
     * 숫자 여부 체크
     *
     * @param str 체크할 문자열
     * @return 숫자면 true, 아니면 false
     */
    public static boolean isNumber(String str) {
        return str.matches("[+-]?\\d*(\\.\\d+)?");
    }

    /**
     * 두 숫자가 같은지 비교
     *
     * @param a 숫자
     * @param b 숫자
     * @return 두 숫자가 같다면 1, 다르면 0
     */
    public static int equalNumber(int a, int b) {
        if (a == b) {
            return 1;
        }
        return 0;
    }

    /**
     * num이 List에 포함되어 있는지 체크
     *
     * @param list 체크 대상 List
     * @param num 체크할 숫자
     * @return 포함되었으면 1, 아니면 2
     */
    public static int containList(List<Integer> list, int num) {
        if (list.contains(num)) {
            return 1;
        }
        return 0;
    }
}
