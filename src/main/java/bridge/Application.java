package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeGameController bridgeGameController = new BridgeGameController(generator);
        bridgeGameController.gameStart();
    }
}