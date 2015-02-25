import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Al William "Rezo" Tammsaar on 2/25/2015.
 */
public class Target {
    private AtomicInteger value = new AtomicInteger(2);

    public AtomicInteger getValue() {
        return value;
    }
}
