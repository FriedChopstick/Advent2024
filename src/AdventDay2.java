import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AdventDay2 {
    public static void main(String[] args) {
        // Part 1
        int safe = 0;
        int unsafe = 0;

        ArrayList<List<String>> puzzleInput = getFileData("src/AdventDay2Input.txt");
        System.out.println(puzzleInput);
        for (int i = 0; i < puzzleInput.size(); i++) {
            List<String> puzzleAtIndex = puzzleInput.get(i);
            if (Safe(puzzleAtIndex)) {
                safe++;
            }
            else {
                unsafe++;
            }
        }
        System.out.println("Safe: " + safe);
        System.out.println("Unsafe: " + unsafe);

        // part 2
        // IM LOSING MY FUCKING MIND
        // Statistics show curses make you a better programmer
        safe = 0;
        unsafe = 0;
        System.out.println(puzzleInput);
        for (int i = 0; i < puzzleInput.size(); i++) {
            List<String> puzzleAtIndex = puzzleInput.get(i);
            if (Safe(puzzleAtIndex)) {
                safe++;
            }
            else {
                for (int j = 0; j < puzzleAtIndex.size(); j++) {
                    List<String> puzzleAtIndexRemoveOne = new ArrayList<>(puzzleInput.get(i));
                    puzzleAtIndexRemoveOne.remove(j);
                    if (Safe(puzzleAtIndexRemoveOne)) {
                        safe++;
                        break; // I really only need this to check if it's safe in one combination
                        // Thus we break if we get a possible combination
                        // Even if we have two possible combinations that work
                        // After removing an element.
                        // We don't want one safe to represent multiple after all.
                    }
                }
                unsafe++;
            }
        }
        System.out.println("Safe: " + safe);
        System.out.println("Unsafe: " + unsafe);
    }
    public static boolean Safe(List<String> puzzle) {
        boolean increasing = false;
        boolean decreasing = false;

        for (int i = 0; i < puzzle.size() - 1; i++) {
            int difference = Integer.parseInt(puzzle.get(i + 1)) - Integer.parseInt(puzzle.get(i));
            if (Math.abs(difference) < 1 || Math.abs(difference) > 3) {
                return false;
            }
            // if difference positive then increasing
            if (difference >= 1 && difference <= 3) {
                increasing = true;
            }
            // if difference negative then decreasing
            if (difference <= -1 && difference >= -3) {
                decreasing = true;
            }
        }
        if (increasing != decreasing) {
            return true;
        }
        return false;
    }
    public static ArrayList<List<String>> getFileData(String fileName) {
        ArrayList<List<String>> fileData = new ArrayList<>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] lineSplit = line.split(" ");
                List<String> splitArray = Arrays.asList(lineSplit);
                if (!line.equals(""))
                    fileData.add(splitArray);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }


}
