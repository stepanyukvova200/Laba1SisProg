import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("words.txt");
        ArrayList<String> arrayList = new ArrayList<>();
        Main.readfile(file, arrayList);
        System.out.println(arrayList);

        String[] wordArray = {};
        wordArray = arrayList.toArray(new String[arrayList.size()]);
        int lengthArray = 0;
        int repit = 0;
        int maxrepit = 0;
        int countAns = 0;
        String[] ansArray = new String[wordArray.length];
        while(lengthArray != wordArray.length)
        {
            for(int i = lengthArray; i < wordArray.length; ++i)
            {
                if(wordArray[i].equals(wordArray[lengthArray]))
                {
                    repit++;
                }
            }
            if(repit > maxrepit)
            {
                maxrepit = repit;
                Arrays.fill(ansArray, null);
                countAns = 0;
                ansArray[countAns] = wordArray[lengthArray];
                repit = 0;
            }
            else if(repit == maxrepit)
            {
                countAns++;
                ansArray[countAns] = wordArray[lengthArray];
                repit = 0;
            }
            else
            {
                repit = 0;
            }
            lengthArray ++;
        }
        for(int i = 0; i <= countAns; ++i)
        {
            System.out.println(ansArray[i]);
        }
    }
    public static void readfile(File file, ArrayList<String> strings){
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] words = scanner.nextLine().split("[\\W\\d]");
                for (String word: words) {
                    if(!word.equals("")){
                        strings.add(word.substring(0, Math.min(word.length(), 30)));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}

