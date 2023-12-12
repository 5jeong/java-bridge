package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final InputViewValidator inputViewValidator = new InputViewValidator();

    private static final String PROMPT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String PROMPT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String PROMPT_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(PROMPT_BRIDGE_SIZE);
        String bridgeSize = Console.readLine();
        inputViewValidator.validateBrideSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(PROMPT_MOVING);
        String moveCommand = Console.readLine();
        inputViewValidator.validateMoveCommand(moveCommand);
        return moveCommand;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(PROMPT_GAME_COMMAND);
        String retryCommand = Console.readLine();
        inputViewValidator.validateRetryCommand(retryCommand);
        return retryCommand;
    }
}