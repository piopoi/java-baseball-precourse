package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Judge;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

/**
 * 야구 게임 컨트롤러
 */
public class BaseballController {

    /**
     * 야구게임 플레이
     *
     * @return 게임 재시작 여부
     */
    public boolean play() {
        Computer computer = new Computer();
        Player player = new Player();
        List<Integer> computerNumList = computer.getComputerNumber(); //컴퓨터 랜덤 숫자 리스트 생성
        boolean threeStrike = false; //3스트라이크 여부
        while (!threeStrike) { //3스트라이크가 나올 때까지 반복
            List<Integer> playerNumList = player.input(); //플레이어의 숫자 입력
            Judge judge = new Judge(computerNumList, playerNumList); //심판 객체 초기화
            threeStrike = judge.judgment(); //3스트라이크 여부가 반환된다.
        }
        return restart(); //게임 재시작 여부 반환
    }

    /**
     * 게임 재시작 여부를 콘솔로 입력받아 반환한다.
     *
     * @return 재시작 여부
     */
    private boolean restart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String str = Console.readLine(); //Console 입력

        if (!chkAnswer(str)) {
            throw new IllegalArgumentException();
        }

        return "1".equals(str); //true = 재시작, false = 종료
    }

    /**
     * 플레이어 재시작여부 입력값 체크
     *
     * @param str 입력값
     * @return 정상이면 true, 아니면 false
     */
    private boolean chkAnswer(String str) {
        return str.equals("1") || str.equals("2"); //1 = 재시작, 2 = 종료
    }
}
