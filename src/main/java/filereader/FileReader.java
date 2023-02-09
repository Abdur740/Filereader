package filereader;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.logging.Logger;

public class FileReader{
    private static final Logger LOGGER =  Logger.getLogger("InfoLogging");

    static StringBuilder print = new StringBuilder("");
    static void read(File f) throws IOException{
        Scanner sc = new Scanner(f);
        
        while (sc.hasNextLine()) {
            print.append(sc.nextLine());
        }
    }
    public static void main(String[] args) throws IOException{
        String path = "C:\\Vscode projects\\Java\\DSA\\filereader\\src\\main\\java\\filereader\\test.txt";
        File f = new File(path);
        read(f);
        String str = ""+print;
        String[] words = str.split(" ");

        Map<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            Integer integer = hashMap.get(word);
 
            if (integer == null)
                hashMap.put(word, 1);
 
            else {
                hashMap.put(word, integer + 1);
            }
        }

        ArrayList<Entry<String, Integer>> nlist  = new ArrayList<>(hashMap.entrySet());
        nlist.sort(Entry.comparingByValue(Comparator.reverseOrder()));
        String s = ""+nlist;
        LOGGER.info(s);
    }
}