import info.jab.cis194.homework3.Exercise3;
import java.util.Arrays;
import java.util.List;

public class DebugHistogram {
    public static void main(String[] args) {
        Exercise3 exercise3 = new Exercise3();
        List<Integer> input = Arrays.asList(2, 2, 2, 2);
        String result = exercise3.histogram(input);
        System.out.println("Result:");
        System.out.println(result);
        System.out.println("Length: " + result.length());
        
        // Debug each line
        String[] lines = result.split("\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println("Line " + i + ": '" + lines[i] + "' (length: " + lines[i].length() + ")");
        }
    }
}