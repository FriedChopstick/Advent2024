import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AdventDay1 {
    public static void main(String[] args) {
        // Part 1
        ArrayList<String> puzzleInput = getFileData("src/AdventDay1Input.txt");
        ArrayList<String> firstHalf = new ArrayList<>();
        ArrayList<String> secondHalf = new ArrayList<>();
        int totalDistance = 0;
        for (int i = 0; i < puzzleInput.size(); i++) {
            int indexOfSpace = puzzleInput.get(i).indexOf(" ");
            firstHalf.add(puzzleInput.get(i).substring(0, indexOfSpace));
            secondHalf.add(puzzleInput.get(i).substring(8));
        }
        Collections.sort(firstHalf);
        Collections.sort(secondHalf);
        for (int i = 0; i < puzzleInput.size(); i++) {
            totalDistance += Math.abs(Integer.parseInt(firstHalf.get(i)) - Integer.parseInt(secondHalf.get(i)));
        }
        System.out.println("Total distance: " + totalDistance);

        // Part 2
        int similarityScore = 0;
        for (int i = 0; i < firstHalf.size(); i++) {
            int numberOfAppearances = 0;
            for (int j = 0; j < firstHalf.size(); j++) {
                if (firstHalf.get(i).equals(secondHalf.get(j))) {
                    numberOfAppearances++;
                }

            }
            similarityScore += (Integer.parseInt(firstHalf.get(i))) * numberOfAppearances;
        }
        System.out.println("Similarity score: " + similarityScore);
    }
    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }


}
