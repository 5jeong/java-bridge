package bridge.domain;

import bridge.util.ConverterUtil;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final String UP_MOVING = "U";
    private static final String SUCCESS = "O";
    private static final String FAIL = "X";
    private static final String BLANK = " ";

    private final List<String> playerMoving = new ArrayList<>();

    private final List<String> upShapeBridge = new ArrayList<>();
    private final List<String> downShapeBridge = new ArrayList<>();

    public void successMoving(String move) {
        if (move.equals(UP_MOVING)) {
            upShapeBridge.add(SUCCESS);
            downShapeBridge.add(BLANK);
            return;
        }
        downShapeBridge.add(SUCCESS);
        upShapeBridge.add(BLANK);
    }

    public void failMoving(String move) {
        if (move.equals(UP_MOVING)) {
            upShapeBridge.add(FAIL);
            downShapeBridge.add(BLANK);
            return;
        }
        downShapeBridge.add(FAIL);
        upShapeBridge.add(BLANK);
    }

    public void addMoving(String move) {
        playerMoving.add(move);
    }


    public int playerMovingSize() {
        return playerMoving.size();
    }

    public String printUpBridgeShape() {
        return ConverterUtil.convertBridgeShape(upShapeBridge);
    }

    public String printDownBridgeShape() {
        return ConverterUtil.convertBridgeShape(downShapeBridge);
    }

    public String currentMoving(int moveIndex){
        return playerMoving.get(moveIndex);
    }

    public String latestMove(){
        return playerMoving.get(playerMovingSize()-1);
    }
}
