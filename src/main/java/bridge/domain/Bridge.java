package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridge;
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    public Bridge(List<String> bridge) {
        validateBridge(bridge);
        this.bridge = bridge;
    }

    private void validateBridge(List<String> bridge) {
        if (isNotBridgeSize(bridge.size())) {
            throw new IllegalArgumentException("[ERROR] 유효하지않은 다리 크기입니다.");
        }

    }

    private static boolean isNotBridgeSize(int bridgeSize) {
        return bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE;
    }

    public int bridgeSize() {
        return bridge.size();
    }

    public String currentBridgeStatus(int moveIndex) {
        return bridge.get(moveIndex);
    }

    @Override
    public String toString() {
        return "Bridge{" +
                "bridge=" + bridge +
                '}';
    }
}
