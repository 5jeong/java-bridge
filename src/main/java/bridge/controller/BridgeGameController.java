package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.InputHandler.InputTemplate;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.GameStatus;
import bridge.domain.Player;
import bridge.util.ConverterUtil;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private int tryCount = 1;
    private GameStatus gameStatus;


    public BridgeGameController(BridgeNumberGenerator generator) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(generator);
    }

    public void gameStart() {
        initializeGame();
        Bridge bridge = generateBridge();
        System.out.println(bridge.toString());
        playGameStep(bridge);
    }

    private void initializeGame() {
        gameStatus = GameStatus.PLAYING;
        outputView.gameStartMessage();
    }

    private Bridge generateBridge() {
        return InputTemplate.execute(() -> {
            int bridgeSize = inputView.readBridgeSize();
            return new Bridge(bridgeMaker.makeBridge(bridgeSize));
        });
    }

    private void playGameStep(Bridge bridge) {
        Player player = new Player();
        BridgeGame bridgeGame = new BridgeGame(bridge, player);
        while (gameStatus.equals(GameStatus.PLAYING)) {
            String moveCommand = generateMoveCommand();
            player.addMoving(moveCommand);
            gameStatus = bridgeGame.move();
            outputView.printMap(bridgeGame.generateBrideShapes());
        }
        judgeGameStatus(gameStatus, bridgeGame);
    }

    private String generateMoveCommand() {
        return InputTemplate.execute(() -> {
            String moveCommand = inputView.readMoving();
            return moveCommand;
        });
    }


    private void judgeGameStatus(GameStatus gameStatus, BridgeGame bridgeGame) {
        if (gameStatus.equals(GameStatus.FAILURE)) {
            retryGameStep(bridgeGame);
        }
        if (gameStatus.equals(GameStatus.END) || gameStatus.equals(GameStatus.SUCCESS)) {
            handleEndOrSuccessStatus(bridgeGame);
        }
        if (gameStatus.equals(GameStatus.PLAYING)) {
            playGameStep(bridgeGame.getBridge());
        }
    }

    private void handleEndOrSuccessStatus(BridgeGame bridgeGame) {
        outputView.printResult(
                bridgeGame.generateBrideShapes(),
                bridgeGame.judgeSuccessStatus(),
                ConverterUtil.convertIntergerToString(tryCount)
        );
    }

    private void retryGameStep(BridgeGame bridgeGame) {
        String gameCommand = generategameCommand();
        judgeTryCount(gameCommand);
        gameStatus = bridgeGame.retry(gameCommand);
        judgeGameStatus(gameStatus, bridgeGame);
    }

    private String generategameCommand() {
        return InputTemplate.execute(() -> {
            String gameCommand = inputView.readGameCommand();
            return gameCommand;
        });
    }

    private void judgeTryCount(String gameCommand) {
        if (gameCommand.equals("R")) {
            tryCount++;
        }
    }

}
