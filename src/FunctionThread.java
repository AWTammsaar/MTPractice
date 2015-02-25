/**
 * Created by Al William "Rezo" Tammsaar on 2/25/2015.
 */
// Simple thread, that uses the function target.max() 5 times with increasing value of i.
public class FunctionThread extends Thread {
    Target target;
    String name;

    public FunctionThread(Target target, String name) {
        this.target = target;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " asking to compare target to "+i);
            System.out.println(name + " got back value of " + target.max(i));
        }
    }

}