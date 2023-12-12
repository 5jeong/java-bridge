package bridge.domain;

import bridge.BridgeNumberGenerator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int DOWN_DIGIT = 0;
    private static final String DOWN_COMMAND = "D";
    private static final String UP_COMMAND = "U";
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        return IntStream.range(DOWN_DIGIT, size)
                .mapToObj(i -> {
                    int randomBridgeNumber = bridgeNumberGenerator.generate();
                    return changeBridgeShape(randomBridgeNumber);
                })
                .collect(Collectors.toList());
    }

    private String changeBridgeShape(int randomBridgeNumber) {
        if (randomBridgeNumber == DOWN_DIGIT) {
            return DOWN_COMMAND;
        }
        return UP_COMMAND;
    }
}
