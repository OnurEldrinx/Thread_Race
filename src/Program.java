import java.util.ArrayList;

public class Program {

    ArrayList<Integer> evenNumbers;
    ArrayList<Integer> oddNumbers;

    public static void main(String[] args) {

        Program program = new Program();
        program.oddNumbers = new ArrayList<>();
        program.evenNumbers = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list4 = new ArrayList<>();

        for (int i=1;i<=10000;i++){

            if (i<=2500){

                list1.add(i);

            }else if (i<=5000){

                list2.add(i);

            }else if(i<=7500){

                list3.add(i);

            }else{

                list4.add(i);

            }

        }

        Classifier c1 = new Classifier(program,list1);
        Classifier c2 = new Classifier(program,list2);
        Classifier c3 = new Classifier(program,list3);
        Classifier c4 = new Classifier(program,list4);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);
        Thread t4 = new Thread(c4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();






    }
}
