package bridge.InputHandler;

public class InputTemplate {
    public static <T> T execute(InputCallback<T> callback) {
        while (true) {
            try {
                return callback.run();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
