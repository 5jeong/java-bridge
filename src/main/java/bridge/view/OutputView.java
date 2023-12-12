package bridge.view;

import bridge.domain.GameStatus;
import bridge.domain.Player;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String FINAL_RESULT_MESSAGE = "최종 게임 결과";
    private static final String SUCCESS_STATUS_MESSAGE = "게임 성공 여부: %s";
    private static final String TRY_COUNT_MESSAGE = "총 시도한 횟수: %s";

    public void gameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridgeShapes) {
        bridgeShapes.forEach(shape -> System.out.println(shape));
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridgeShapes, String successStatus, String tryCount) {
        System.out.println(FINAL_RESULT_MESSAGE);
        printMap(bridgeShapes);
        System.out.println(String.format(SUCCESS_STATUS_MESSAGE, successStatus));
        System.out.println(String.format(TRY_COUNT_MESSAGE, tryCount));
    }
}
