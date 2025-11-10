package info.jab.examples;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Fetches Project Euler problem numbers from the archives page.
 */
public class EulerProblemsFetcher {

    private static final String ARCHIVES_URL = "https://projecteuler.net/archives";
    private static final int MAX_PROBLEMS = 3;

    public static void main(String[] args) {
        try {
            List<Integer> problemNumbers = fetchEulerProblemNumbers();
            String json = formatAsJson(problemNumbers);
            System.out.println("<result>" + json + "</result>");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Fetches the Project Euler archives page and extracts problem numbers.
     *
     * @return List of problem numbers (limited to first 3)
     */
    public static List<Integer> fetchEulerProblemNumbers() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ARCHIVES_URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed to fetch page. Status code: " + response.statusCode());
        }

        String html = response.body();
        return extractProblemNumbers(html);
    }

    /**
     * Extracts problem numbers from the HTML content.
     * The archives page typically has links like "problem=1", "problem=2", etc.
     *
     * @param html The HTML content of the archives page
     * @return List of problem numbers (limited to first 3)
     */
    private static List<Integer> extractProblemNumbers(String html) {
        List<Integer> problemNumbers = new ArrayList<>();
        
        // Pattern to match problem links: problem=1, problem=2, etc.
        // Also matches various formats like "Problem 1", "problem 1", etc.
        Pattern pattern = Pattern.compile("problem[=:]\\s*(\\d+)", Pattern.CASE_INSENSITIVE);
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
        
        // If we didn't find enough problems with the first pattern, try alternative patterns
        if (problemNumbers.size() < MAX_PROBLEMS) {
            // Try pattern for table rows or list items with problem numbers
            Pattern altPattern = Pattern.compile(">\\s*(\\d+)\\s*<", Pattern.CASE_INSENSITIVE);
            Matcher altMatcher = altPattern.matcher(html);
            
            while (altMatcher.find() && problemNumbers.size() < MAX_PROBLEMS) {
                try {
                    int num = Integer.parseInt(altMatcher.group(1));
                    // Only add if it's a reasonable problem number (1-1000) and not already added
                    if (num > 0 && num <= 1000 && !problemNumbers.contains(num)) {
                        problemNumbers.add(num);
                    }
                } catch (NumberFormatException e) {
                    // Skip invalid numbers
                }
            }
        }
        
        // Sort and limit to first 3
        problemNumbers.sort(Integer::compareTo);
        return problemNumbers.stream().limit(MAX_PROBLEMS).toList();
    }

    /**
     * Formats the list of problem numbers as JSON.
     *
     * @param problemNumbers List of problem numbers
     * @return JSON string with key "List_Integer"
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
