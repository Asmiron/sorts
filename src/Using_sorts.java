import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Using_sorts {
    public static void main(String[] arg){
        Arr_Sorts array = new Arr_Sorts(10);
        FileRW file = new FileRW("data.txt");
        file.ReadToArray(array);
        array.quicksort();
        file.WriteFromArray(array);
    }
}
