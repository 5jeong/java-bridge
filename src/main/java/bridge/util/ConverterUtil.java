package bridge.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConverterUtil {

    public static String convertBridgeShape(List<String> shapeBridge) {
        return IntStream.range(0, shapeBridge.size())
                .mapToObj(i -> shapeBridge.get(i) + getSeparator(i, shapeBridge.size()))
                .collect(Collectors.joining("", "[ ", " ]"));
    }

    private static String getSeparator(int index, int size) {
        if (index < size - 1) {
            return " | ";
        }
        return "";
    }

    public static String convertIntergerToString(int number) {
        return String.valueOf(number);
    }
}