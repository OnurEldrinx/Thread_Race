import java.util.ArrayList;

public class Classifier implements Runnable {

    Program program;
    ArrayList<Integer> list;

    public Classifier(Program program, ArrayList<Integer> list) {
        this.program = program;
        this.list = list;
    }


    @Override
    public void run() {

        for (Integer integer : this.list) {

            switch (integer % 2) {

                case 0:
                    synchronized (this.program.evenNumbers) {
                        this.program.evenNumbers.add(integer);
                        System.out.println(Thread.currentThread().getName() + " adds " + integer + " to the list of even numbers!");
                    }
                    break;
                case 1:
                    synchronized (this.program.oddNumbers) {
                        this.program.oddNumbers.add(integer);
                        System.out.println(Thread.currentThread().getName() + " adds " + integer + " to the list of odd numbers!");
                    }
                    break;

            }

        }

        System.out.println("EVEN NUMBERS SIZE   : " + program.evenNumbers.size());
        System.out.println("ODD  NUMBERS SIZE   : " + program.oddNumbers.size());

        ArrayList<Integer> e = new ArrayList<>();
        ArrayList<Integer> o = new ArrayList<>();


        for (int i=1;i<=10000;i++){

            if (i%2==0){

                e.add(i);

            }else{

                o.add(i);

            }

        }

        if (program.evenNumbers.containsAll(e)){

            System.out.println(Thread.currentThread().getName()+" - EVEN CHECK : TRUE");

        }else{

            System.out.println(Thread.currentThread().getName()+" - EVEN CHECK : FALSE");

        }

        if (program.oddNumbers.containsAll(o)){

            System.out.println(Thread.currentThread().getName()+" - ODD  CHECK : TRUE");

        }else{

            System.out.println(Thread.currentThread().getName()+" - ODD  CHECK : FALSE");

        }

    }



}
