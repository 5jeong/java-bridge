package bridge.util;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertUtil {

    public static Integer convertStringToInt(String str) {
        return Integer.parseInt(str);
    }
    public static String convertToBridgeShape(List<String> bridgeShapes) {
        String bridgeShape = bridgeShapes.stream()
                .collect(Collectors.joining(" | ", "[ ", " ]"));

        return bridgeShape;
    }


}
