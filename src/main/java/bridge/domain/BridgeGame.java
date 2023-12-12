package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String SUCCESS_STATUS = "성공";
    private static final String FAIL_STATUS = "실패";

    private final Bridge bridge;

    private final Player player;

    public BridgeGame(Bridge bridge, Player player) {
        this.bridge = bridge;
        this.player = player;
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameStatus move() {
        String latestMove = player.latestMove();
        if(canMove()){
            player.successMoving(latestMove);
            return checkStatus();
        }
        if(!canMove()){
            player.failMoving(latestMove);
            return GameStatus.FAILURE;
        }
        return GameStatus.PLAYING;
    }


    private GameStatus checkStatus(){
        if(player.playerMovingSize()==bridge.bridgeSize()){
            return GameStatus.SUCCESS;
        }
        return GameStatus.PLAYING;

    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameStatus retry(String gameCommand) {
        if(gameCommand.equals("R")){
            return GameStatus.PLAYING;
        }
        return GameStatus.END;
    }

    public List<String> generateBrideShapes(){
        List<String> bridgeShapes = new ArrayList<>();
        bridgeShapes.add(player.printUpBridgeShape());
        bridgeShapes.add(player.printDownBridgeShape());
        return bridgeShapes;
    }

    public String judgeSuccessStatus(){
        if(checkStatus().equals(GameStatus.SUCCESS)){
            return SUCCESS_STATUS;
        }
        return FAIL_STATUS;
    }

    private boolean canMove() {
        int moveIndex = player.playerMovingSize() - 1;
        return player.currentMoving(moveIndex).equals(bridge.currentBridgeStatus(moveIndex));
    }

    public Bridge getBridge() {
        return bridge;
    }
}
