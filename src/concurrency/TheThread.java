package concurrency;

class OneOfThem extends Thread {

    public int oneOfThemCounting;

    public static boolean killThemAll;

    @Override
    public void run() {

        while (!killThemAll) {
            oneOfThemCounting++;
            //why app doesn't ends well when that line is commented???
            //System.out.print("");
        }
        System.out.println();
        System.out.println("One thread's name: " + super.getName() + " done!");
    }
}

public class TheThread {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("The thread's name: main");
        OneOfThem one0 = new OneOfThem();
        OneOfThem one1 = new OneOfThem();
        OneOfThem one2 = new OneOfThem();
        one0.start();
        one1.start();
        one2.start();
        Thread.sleep(500);
        OneOfThem.killThemAll = true;
        one0.join();
        one1.join();
        one2.join();
        System.out.println("Thread " + one0.getName() + " counted " + one0.oneOfThemCounting + " times!");
        System.out.println("Thread " + one1.getName() + " counted " + one1.oneOfThemCounting + " times!");
        System.out.println("Thread " + one2.getName() + " counted " + one2.oneOfThemCounting + " times!");
    }
}


