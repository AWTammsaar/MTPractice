/**
 * Created by Al William "Rezo" Tammsaar on 2/25/2015.
 */
// Simple thread, that uses the function target.max() 100 times with increasing value of i.
public class FunctionThread extends Thread {
    private Target target;
    private String name;

    public FunctionThread(Target target, String name) {
        this.target = target;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + " asking to compare target to "+i);
            System.out.println(name + " got back value of " + max(i+3,target));
        }
}

    // Assures function output is based on correct, current value.
    public int max(int b, Target target) {
        while (true){
            int c = target.getValue().get();
            try { // without this sleep the chance of compareAndSet returning false is abysmal
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (c>b){
                if (target.getValue().compareAndSet(c, c)){
                    return c;
                }
                else {
                    System.out.println("Object value changed mid-calculation (c>b)");
                    continue;
                }
            }
            else{
                if (target.getValue().compareAndSet(c, b)){
                    return b;
                }
                else {
                    System.out.println("Object value changed mid-calculation (c<b)");
                    continue;
                }
            }
        }
    }
}