import java.util.ArrayList;

/**
 * Created by Al William "Rezo" Tammsaar on 2/25/2015.
 */
public class TestMain {
    // Creates a "target" the function is used on, then creates 5 threads, giving them a name and initiating them
    public static void main(String[] args) {
        Target target = new Target();
        ArrayList<FunctionThread> threads = new ArrayList<FunctionThread>();
        for (int i = 0; i < 5; i++) {
            FunctionThread thread = new FunctionThread(target,"Thread nr."+i);
            threads.add(thread);
            thread.start();
        }
    }
}
