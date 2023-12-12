package bridge.view;

import java.util.regex.Pattern;

public class InputViewValidator {
    private static final String BRIDGE_SIZE_REGEX = "[0-9]+";
    private static final String MOVE_COMMAND_REGEX = "[UD]";
    private static final String RETRY_COMMAND_REGEX = "[RQ]";

    public void validateBrideSize(String bridgeSize) {
        if (!Pattern.matches(BRIDGE_SIZE_REGEX, bridgeSize)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야합니다.");
        }
    }

    public void validateMoveCommand(String moveCommand) {
        if (!Pattern.matches(MOVE_COMMAND_REGEX, moveCommand)) {
            throw new IllegalArgumentException("[ERROR] U 또는 D를 입력해야합니다.");
        }
    }

    public void validateRetryCommand(String retryCommand) {
        if (!Pattern.matches(RETRY_COMMAND_REGEX, retryCommand)) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q를 입력해야합니다.");
        }
    }
}
