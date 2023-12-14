package bridge.domain;

import bridge.util.ConvertUtil;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<String> moveHistory = new ArrayList<>();

    private final List<String> upShapeBridgeState = new ArrayList<>();
    private final List<String> downShapeBridgeState = new ArrayList<>();
    public void successBridgeState(String moveCommand){
        if(moveCommand.equals("U")){
            upShapeBridgeState.add("O");
            downShapeBridgeState.add(" ");
            return;
        }
        downShapeBridgeState.add("O");
        upShapeBridgeState.add(" ");
    }

    public void failBridgeState(String moveCommand){
        if(moveCommand.equals("U")){
            upShapeBridgeState.add("X");
            downShapeBridgeState.add(" ");
            return;
        }
        downShapeBridgeState.add("X");
        upShapeBridgeState.add(" ");
    }

    public void initBridgeState(){
        moveHistory.clear();
        upShapeBridgeState.clear();
        downShapeBridgeState.clear();
    }

    public void addMove(String moveCommand){
        moveHistory.add(moveCommand);
    }

    public String latestMove(){
        return moveHistory.get(moveHistory.size()-1);
    }

    public int moveSize(){
        return moveHistory.size();
    }

    public List<String> totalBridgeState(){
        List<String> totalBridgeState = new ArrayList<>();
        totalBridgeState.add(ConvertUtil.convertToBridgeShape(upShapeBridgeState));
        totalBridgeState.add(ConvertUtil.convertToBridgeShape(downShapeBridgeState));
        return totalBridgeState;
    }
}
