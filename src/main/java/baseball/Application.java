package baseball;

import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballController baseballController = new BaseballController(); //게임 관리 객체 생성

        do {
            baseballController.play(); //게임 플레이
        } while (baseballController.restart()); //재시작 여부에 따라 게임을 반복한다.
    }
}
