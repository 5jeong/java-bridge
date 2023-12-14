package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
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
}
