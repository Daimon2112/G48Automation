import java.util.ArrayList;
import java.util.List;

public class ArrayTrainer {

    public int[] intArray = new int [] {1,2,3,4,8};
    public int[] ints = new int[5];
    public int[][] intDoubleArray = new int[][]{{1,2,3}, {1,65,7}};

    public List<Integer> intList = new ArrayList<>();

    public void move(){
        for (int i = 0; i<= intArray.length; i++){
            intList.add(intArray[i]);
            intArray[i] = 0;
        }



//        int i = 4;
//        while(i < 5){
//            System.out.println("Some text");
//            i++;
//        }

//        int i = 4;
//        do{
//            System.out.println();
//            i++;
//        }while (i < 5);

    }
}
