import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRW {
    private String file;
    public FileRW(String s){
        file = s;
    }

    public void ReadToArray(Arr_Sorts array){
        try(FileReader reader = new FileReader(file)){
            int c = reader.read();
            int s = 0;
            int temp;
            while (true) {
                c = c - 48;
                if ((c >= 0) && (c <= 9)) {
                    s = s * 10 + c;
                } else {
                    array.insert(s);
                    s = 0;
                }
                if ((temp = reader.read()) == -1 && c == -16) break;
                else if (temp == -1) {
                    array.insert(s);
                    break;
                }
                c = temp;
            }
        }
        catch(IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void WriteFromArray(Arr_Sorts array){
        try(FileWriter writer = new FileWriter(file, false)){
            for (int i = 0; i < array.getSize(); i++){
                writer.write(array.getone(i)+" ");
            }

        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
