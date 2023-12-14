package bridge.view;

import bridge.util.ConvertUtil;
import java.util.regex.Pattern;

public class InputViewValidator {
    private static final String MENU_AND_COUNT_REGEX = "";
    private static final String NUMBER_REGEX = "[0-9]+";
    private static final String MOVE_COMMAND_REGEX = "[U|D]";
    private static final String GAME_COMMAND_REGEX = "[R|Q]";


    public static void validateBirdgeSize(String bridgeSize) {
        if (isNotDigit(bridgeSize)) {
            throw new IllegalArgumentException(("[ERROR] 숫자를 입력해야 합니다."));
        }
        if (isNotBirdgeSize(bridgeSize)) {
            throw new IllegalArgumentException(("[ERROR] 3이상 20이하의 숫자를 입력해야합니다."));
        }
    }

    private static boolean isNotBirdgeSize(String bridgeSize) {
        int size = ConvertUtil.convertStringToInt(bridgeSize);
        return size < 3 || size > 20;
    }

    private static boolean isNotDigit(String bridgeSize) {
        return !Pattern.compile(NUMBER_REGEX).matcher(bridgeSize).matches();
    }

    public static void validateMoveCommand(String moveCommand) {
        if (isNotMoveCommand(moveCommand)) {
            throw new IllegalArgumentException(("[ERROR] U 또는 D를 입력해야합니다."));
        }
    }

    private static boolean isNotMoveCommand(String moveCommand) {
        return !Pattern.compile(MOVE_COMMAND_REGEX).matcher(moveCommand).matches();
    }

    public static void validateGameCommand(String gameCommand) {
        if (isNotGameCommand(gameCommand)) {
            throw new IllegalArgumentException(("[ERROR] R 또는 Q를 입력해야합니다."));
        }
    }

    private static boolean isNotGameCommand(String gameCommand) {
        return !Pattern.compile(GAME_COMMAND_REGEX).matcher(gameCommand).matches();
    }
}
