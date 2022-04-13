package vertx.java.threads;

public class Main {

    static int a = 0;
    static int b = 0;



    public static void main(String[] args) {
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Operation 1");
                a = 1;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                System.out.println("Operation 2: a=" + a);
            }
        };

        Thread t1 = new Thread(run1);

        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Operation 3");
                b = a;
                a = 2;
                System.out.println("Operation 4: a=" + a + " b=" + b);
            }
        };

        Thread t2 = new Thread(run2);

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
        }
        t2.start();


        // Asynchron
        leseDateiAus(
                (String dateiInhalt) -> holeDatenVonDatenbank(
                        dateiInhalt,
                        (String[] daten) -> schickeNetzwerkAntwort(daten)
                )
        );

        leseDateiAus()
                .flatMap(dateiInhalt -> holeDatenVonDatenbank(dateiInhalt))
                .flatMap(daten -> schickeNetzwerkAntwort(daten))
                .subscribe();
    }
}
