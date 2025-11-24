package info.jab.examples;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Fetches the list of Euler problems from Project Euler archives page
 * and returns the first 3 problem numbers in JSON format.
 */
public class EulerProblemsFetcher {

    private static final String ARCHIVES_URL = "https://projecteuler.net/archives";
    private static final int MAX_PROBLEMS = 3;

    public static void main(String[] args) {
        try {
            List<Integer> problemNumbers = fetchEulerProblems();
            String json = formatAsJson(problemNumbers);
            System.out.println("<result>" + json + "</result>");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Fetches the Euler problems page and extracts problem numbers.
     */
    private static List<Integer> fetchEulerProblems() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ARCHIVES_URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String html = response.body();

        return parseProblemNumbers(html);
    }

    /**
     * Parses the HTML to extract problem numbers.
     * Looks for links like /problem=1, /problem=2, etc.
     */
    private static List<Integer> parseProblemNumbers(String html) {
        List<Integer> problemNumbers = new ArrayList<>();
        
        // Pattern to match problem links: /problem=123 or problem=123
        Pattern pattern = Pattern.compile("(?:/|\\s)problem=(\\d+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(html);
        
        while (matcher.find() && problemNumbers.size() < MAX_PROBLEMS) {
            try {
                int problemNumber = Integer.parseInt(matcher.group(1));
                if (!problemNumbers.contains(problemNumber)) {
                    problemNumbers.add(problemNumber);
                }
            } catch (NumberFormatException e) {
                // Skip invalid numbers
            }
        }
        
        // If we didn't find enough problems, try alternative patterns
        if (problemNumbers.size() < MAX_PROBLEMS) {
            // Try pattern for table rows with problem numbers
            Pattern altPattern = Pattern.compile("<td[^>]*>\\s*(\\d+)\\s*</td>", Pattern.CASE_INSENSITIVE);
            Matcher altMatcher = altPattern.matcher(html);
            
            while (altMatcher.find() && problemNumbers.size() < MAX_PROBLEMS) {
                try {
                    int problemNumber = Integer.parseInt(altMatcher.group(1));
                    if (problemNumber > 0 && problemNumber <= 1000 && !problemNumbers.contains(problemNumber)) {
                        problemNumbers.add(problemNumber);
                    }
                } catch (NumberFormatException e) {
                    // Skip invalid numbers
                }
            }
        }
        
        // Sort and take first MAX_PROBLEMS
        problemNumbers.sort(Integer::compareTo);
        return problemNumbers.subList(0, Math.min(MAX_PROBLEMS, problemNumbers.size()));
    }

    /**
     * Formats the list of problem numbers as JSON.
     */
    private static String formatAsJson(List<Integer> problemNumbers) {
        StringBuilder json = new StringBuilder();
        json.append("{\"List_Integer\":[");
        
        for (int i = 0; i < problemNumbers.size(); i++) {
            if (i > 0) {
                json.append(",");
            }
            json.append(problemNumbers.get(i));
        }
        
        json.append("]}");
        return json.toString();
    }
}
