package baseball.domain;

import java.util.List;

/**
 * 심판 클래스
 */
public class Judge {

    /**
     * 상대방(컴퓨터)의 숫자와 플레이어가 입력한 숫자를 비교하여 결과를 판단한다.
     *
     * @param computerNumList 컴퓨터 숫자 리스트
     * @param playerNumList   플레이어 숫자 리스트
     * @return 3 스트라이크 여부를 반환.
     */
    public boolean judgment(List<Integer> computerNumList, List<Integer> playerNumList) {
        int strikeCount = countingStrike(computerNumList, playerNumList); //스트라이크 개수 세기
        int ballCount = countingBall(strikeCount, computerNumList, playerNumList); //볼 개수 세기

        hint(strikeCount, ballCount); //힌트 출력

        return strikeCount == 3; //3 스트라이크인 경우 true, 아니면 false.
    }

    /**
     * 스트라이크 개수 세기
     *
     * @param computerNumList 컴퓨터 숫자 리스트
     * @param playerNumList   플레이어 숫자 리스트
     * @return 스트라이크 개수 반환
     */
    private int countingStrike(List<Integer> computerNumList, List<Integer> playerNumList) {
        int strikeCount = 0;

        for (int i = 0; i < computerNumList.size(); i++) {
            //두 리스트의 같은 index의 value가 같다면 1을 반환하여 count가 올라간다.
            strikeCount += equalNumber(computerNumList.get(i), playerNumList.get(i));
        }

        return strikeCount;
    }

    /**
     * 볼 개수 세기
     *
     * @param strikeCount     스트라이크 개수
     * @param computerNumList 컴퓨터 숫자 리스트
     * @param playerNumList   플레이어 숫자 리스트
     * @return 볼 개수 반환
     */
    private int countingBall(int strikeCount, List<Integer> computerNumList, List<Integer> playerNumList) {
        int containCount = 0; //computerNumList에 포함된 playerNumList 값 개수

        for (int num : playerNumList) {
            containCount += containList(computerNumList, num); //computerNumList에 num이 있으면 1을 반환하고 없으면 0을 반환한다.
        }

        return containCount - strikeCount; //위치 상관없이 맞춘 숫자 개수에서 스트라이크를 제외하면 볼 개수가 된다.
    }

    /**
     * 힌트 출력
     *
     * @param strikeCount 스트라이크 개수
     * @param ballCount   볼 개수
     */
    private void hint(int strikeCount, int ballCount) {
        if (ballCount == 0 && strikeCount == 0) { //0볼 0 스트라이크 => 낫싱
            System.out.print("낫싱");
        }
        if (ballCount > 0) {
            System.out.print(ballCount + "볼 ");
        }
        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크");
        }
        System.out.println(); //줄바꿈 처리
    }

    /**
     * 두 숫자가 같은지 비교
     *
     * @param a 숫자
     * @param b 숫자
     * @return 두 숫자가 같다면 1, 다르면 0
     */
    private int equalNumber(int a, int b) {
        if (a == b) {
            return 1;
        }
        return 0;
    }

    /**
     * num이 List에 포함되어 있는지 체크
     *
     * @param list 체크 대상 List
     * @param num  체크할 숫자
     * @return 포함되었으면 1, 아니면 2
     */
    private int containList(List<Integer> list, int num) {
        if (list.contains(num)) {
            return 1;
        }
        return 0;
    }
}
