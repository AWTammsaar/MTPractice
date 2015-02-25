import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Al William "Rezo" Tammsaar on 2/25/2015.
 */
public class Target {
    public AtomicInteger value = new AtomicInteger(2);

    // Assures function output is based on correct, current value.
    public int max(int b){
        while (true){
            int c = value.get();
            if (c>b){
                if (value.compareAndSet(c,c)){
                    return c;
                }
                else continue;
            }
            else{
                if (value.compareAndSet(c,b)){
                    return b;
                }
                else continue;
            }
        }
    }
}
