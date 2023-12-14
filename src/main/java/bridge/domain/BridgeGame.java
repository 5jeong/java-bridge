package bridge.domain;

import java.util.List;
import javax.swing.plaf.PanelUI;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;

    private final Player player;

    public BridgeGame(Bridge bridge, Player player) {
        this.bridge = bridge;
        this.player = player;
        player.initBridgeState();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameStatus move(String moveCommand) {
        if(movingState()){
            player.successBridgeState(moveCommand);
            return checkSuccessGame();
        }
        player.failBridgeState(moveCommand);
        return GameStatus.FAIL;
    }

    private boolean movingState(){
        int currentIndex = player.moveSize()-1;
        return player.latestMove().equals(bridge.currentBridgeShpae(currentIndex));
    }

    private GameStatus checkSuccessGame(){
        if(bridge.bridgeSize() == player.moveSize()){
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
            return GameStatus.RESTART;
        }
        return GameStatus.END;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public Player getPlayer() {
        return player;
    }

    public List<String> gameResult(){
        return player.totalBridgeState();
    }

    public String successResult(GameStatus gameStatus){
        if(gameStatus.equals(GameStatus.SUCCESS)){
            return "성공";
        }
        return "실패";
    }
}
