package bridge.view;
import bridge.domain.GameStatus;
import bridge.util.ConvertUtil;
import camp.nextstep.edu.missionutils.Console;
import net.bytebuddy.pool.TypePool.Resolution.NoSuchTypeException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요.");
        String bridgeSize = Console.readLine();
        InputViewValidator.validateBirdgeSize(bridgeSize);
        return ConvertUtil.convertStringToInt(bridgeSize);
}

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println();
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moveCommand = Console.readLine();
        InputViewValidator.validateMoveCommand(moveCommand);
        return moveCommand;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println();
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = Console.readLine();
        InputViewValidator.validateGameCommand(gameCommand);
        return gameCommand;
    }
}
