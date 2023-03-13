import java.util.LinkedList;

public class Main {

    static double totalAAvoir = 100;
    static double[] piecesList = {5, 2, 1, 0.5, 0.2};
    public static boolean isValid(double valueToAdd, double total){
        boolean test  = (valueToAdd+total<=totalAAvoir);

        return test;
    }
    public static boolean findinLL(LinkedList<Double> ll, double value){

        for (double element: ll) {
            if (element == value){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int num_solutions = 0;
        int gentracker = 0;

        LinkedList<Double> sums=new LinkedList<Double>();
        LinkedList<Double> temp=new LinkedList<Double>();

        sums.add((double) 0);
        boolean stateFinished = false;
        double[] duplcates = new double[piecesList.length];



        while(!stateFinished){
            System.out.print("Generation : ");
            System.out.println(gentracker);
            gentracker++;

            for (double element: sums) {
                for (double piece: piecesList) {
                    if (isValid(element, piece)){
                        temp.add(element + piece);

                    }
                }
            }

            sums.clear();
            if (temp.size() == 0){
                stateFinished = true;
            }else{
                for (double element:temp
                ) {
                    if(element == totalAAvoir){
                        num_solutions ++;
                    }

                    else{if(!findinLL(sums, element))
                        sums.add(element);
                    else{num_solutions ++;}
                    }

                }

            }
            temp.clear();
        }
        System.out.print("Nombre de solutions : ");
        System.out.println(num_solutions);
    }
}