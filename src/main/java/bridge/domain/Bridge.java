package bridge.domain;

import java.util.List;

public class Bridge {

    public List<String> getBridgeShapes() {
        return bridgeShapes;
    }

    private final List<String> bridgeShapes;

    public Bridge(List<String> bridgeShapes) {
        this.bridgeShapes = bridgeShapes;
    }

    public int bridgeSize() {
        return bridgeShapes.size();
    }

    public String currentBridgeShpae(int index) {
        return bridgeShapes.get(index);
    }


}
