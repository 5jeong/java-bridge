package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputHandler.InputTemplate;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.GameStatus;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private GameStatus gameStatus;
    private int totalAttemps = 1;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.startMessageOutput();
        int bridgeSize = generateBridgeSize();
        Bridge bridge = generateBridgeStep(bridgeSize);
        Player player = generatePlayer();
        playGameStep(bridge,player);
    }


    private void playGameStep(Bridge bridge, Player player) {
        System.out.println(bridge.getBridgeShapes());
        gameStatus = GameStatus.PLAYING;
        BridgeGame bridgeGame = new BridgeGame(bridge, player);
        while (gameStatus.equals(GameStatus.PLAYING)) {
            String moveCommand = generateMoveCommand();
            player.addMove(moveCommand);
            gameStatus = bridgeGame.move(moveCommand);
            outputView.printMap(player.totalBridgeState());
        }
        judgeGameStatus(gameStatus, bridgeGame);

    }

    private void judgeGameStatus(GameStatus gameStatus, BridgeGame bridgeGame) {
        if (gameStatus.equals(GameStatus.FAIL)) {
            failStatus(bridgeGame);
        }
        if (gameStatus.equals(GameStatus.SUCCESS)|| gameStatus.equals(GameStatus.END)) {
            gameResultStep(bridgeGame);
        }
        if(gameStatus.equals(GameStatus.RESTART)){
            playGameStep(bridgeGame.getBridge(), bridgeGame.getPlayer());
        }
    }

    private void failStatus( BridgeGame bridgeGame) {
        totalAttemps++;
        String gameCommand = inputView.readGameCommand();
        gameStatus = bridgeGame.retry(gameCommand);
        judgeGameStatus(gameStatus,bridgeGame);
    }

    private void gameResultStep(BridgeGame bridgeGame){
        outputView.printResult(bridgeGame.gameResult());
        outputView.gameResultState(bridgeGame.successResult(gameStatus),totalAttemps);
    }
    private String generateMoveCommand() {
        return InputTemplate.execute(() -> {
            return inputView.readMoving();
        });
    }

    private Player generatePlayer() {
        return new Player();
    }

    private Bridge generateBridgeStep(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    private int generateBridgeSize() {
        return InputTemplate.execute(() -> {
            return inputView.readBridgeSize();
        });
    }
}
