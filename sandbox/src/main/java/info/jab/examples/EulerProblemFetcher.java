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
 * Fetches and extracts Euler problem numbers from Project Euler archives page.
 */
public class EulerProblemFetcher {

    private static final String ARCHIVES_URL = "https://projecteuler.net/archives";
    private static final int MAX_PROBLEMS = 10;

    public static void main(String[] args) {
        try {
            List<Integer> problemNumbers = fetchProblemNumbers();
            String json = formatAsJson(problemNumbers);
            System.out.println("<result>" + json + "</result>");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Fetches the archives page and extracts problem numbers.
     */
    private static List<Integer> fetchProblemNumbers() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ARCHIVES_URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Failed to fetch page: HTTP " + response.statusCode());
        }

        return parseProblemNumbers(response.body());
    }

    /**
     * Parses the HTML content to extract problem numbers.
     * Looks for links like /problem=1, /problem=2, etc.
     */
    private static List<Integer> parseProblemNumbers(String html) {
        List<Integer> numbers = new ArrayList<>();
        
        // Pattern to match problem links: problem=1, problem=2, etc.
        // Also matches <a href="problem=123"> or href='problem=456'
        Pattern pattern = Pattern.compile("problem=(\\d+)");
        Matcher matcher = pattern.matcher(html);

        while (matcher.find() && numbers.size() < MAX_PROBLEMS) {
            try {
                int problemNumber = Integer.parseInt(matcher.group(1));
                // Only add if not already in the list (to avoid duplicates)
                if (!numbers.contains(problemNumber)) {
                    numbers.add(problemNumber);
                }
            } catch (NumberFormatException e) {
                // Skip invalid numbers
            }
        }

        // If we didn't find enough problems, try alternative patterns
        if (numbers.size() < MAX_PROBLEMS) {
            // Try pattern for table rows or other formats
            Pattern altPattern = Pattern.compile(">\\s*(\\d+)\\s*<.*?Problem\\s+(\\d+)", Pattern.CASE_INSENSITIVE);
            Matcher altMatcher = altPattern.matcher(html);
            
            while (altMatcher.find() && numbers.size() < MAX_PROBLEMS) {
                try {
                    int problemNumber = Integer.parseInt(altMatcher.group(1));
                    if (!numbers.contains(problemNumber)) {
                        numbers.add(problemNumber);
                    }
                } catch (NumberFormatException e) {
                    // Skip invalid numbers
                }
            }
        }

        // Sort and take first 10 unique problems
        return numbers.stream()
                .distinct()
                .sorted()
                .limit(MAX_PROBLEMS)
                .toList();
    }

    /**
     * Formats the list of problem numbers as JSON.
     */
    private static String formatAsJson(List<Integer> numbers) {
        StringBuilder json = new StringBuilder();
        json.append("{\"List_Integer\":[");
        
        for (int i = 0; i < numbers.size(); i++) {
            if (i > 0) {
                json.append(",");
            }
            json.append(numbers.get(i));
        }
        
        json.append("]}");
        return json.toString();
    }
}
