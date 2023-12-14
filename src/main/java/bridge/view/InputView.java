package bridge.view;
import bridge.util.ConvertUtil;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        String bridgeSize = Console.readLine();
        InputViewValidator.validateBirdgeSize(bridgeSize);
        return bridgeSize;
}

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moveCommand = Console.readLine();
        InputViewValidator.validateMoveCommand(moveCommand);
        return moveCommand;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = Console.readLine();
        InputViewValidator.validateGameCommand(gameCommand);
        return null;
    }
}
