
import java.util.ArrayList;
import java.util.List;

public class Except{
    
    
    public static void outof(){
        int[] array = new int[]{1,2,3};
        // can't acces index 3 bc array on lenght 3
        System.out.println(array[3]);
    }
    
    public static void concurr(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i : list){
            if(i == 1){
                list.remove(i);
            }
        }
    }
    
    public static void nullpointer(){
        int[] array = null;
        int a = array.length;
    }
    
    
    
}