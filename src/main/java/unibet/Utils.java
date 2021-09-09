package unibet;

import lombok.SneakyThrows;

import java.time.Duration;

public class Utils {
    @SneakyThrows
    public static void pause(Duration duration) {
        Thread.sleep(duration.toMillis());
    }
}
