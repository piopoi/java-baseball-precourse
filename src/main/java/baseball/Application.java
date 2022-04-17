package baseball;

import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballController baseballController = new BaseballController(); //게임 관리 객체 생성

        boolean restart = true; //재시작 여부
        while (restart) { //재시작 여부에 따라 게임을 반복한다.
            restart = baseballController.play(); //게임 종료 후 재시작여부를 반환한다.
        }
    }
}
