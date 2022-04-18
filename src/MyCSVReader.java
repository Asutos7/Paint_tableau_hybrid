import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import au.com.bytecode.opencsv.CSVReader;

public class MyCSVReader
{

    public CSVReader reader = new CSVReader(new FileReader("\\Users\\Asutos\\IdeaProjects\\Paint\\src\\texte\\test.csv"));
    public String [] nextLine;
    public ArrayList<Integer> list = new ArrayList<>();


    public MyCSVReader() throws IOException {
        int i=0;
        while ((nextLine = reader.readNext()) != null)
        {
            for(String valeur:nextLine) {
                if((i%2)==0){
                    list.add(Integer.parseInt(valeur));
                }
                i++;
            }
        }
    }

    public ArrayList<Integer> getList() {
        return list;
    }

}