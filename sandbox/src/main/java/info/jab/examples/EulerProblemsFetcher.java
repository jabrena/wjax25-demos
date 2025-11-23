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
 * Fetches Project Euler problem numbers from the archives page.
 */
public class EulerProblemsFetcher {

    private static final String ARCHIVES_URL = "https://projecteuler.net/archives";
    private static final int MAX_PROBLEMS = 3;

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
     * Fetches the Project Euler archives page and extracts problem numbers.
     *
     * @return List of problem numbers (limited to first 3)
     * @throws IOException if there's an error fetching the page
     * @throws InterruptedException if the request is interrupted
     */
    public static List<Integer> fetchProblemNumbers() throws IOException, InterruptedException {
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
     * Parses problem numbers from the HTML content.
     * Looks for links to problems in the format /problem=XXX
     *
     * @param html the HTML content
     * @return List of problem numbers (limited to first 3)
     */
    private static List<Integer> parseProblemNumbers(String html) {
        List<Integer> problemNumbers = new ArrayList<>();
        
        // Pattern to match problem links like /problem=1, /problem=2, etc.
        Pattern pattern = Pattern.compile("/problem=(\\d+)");
        Matcher matcher = pattern.matcher(html);

        while (matcher.find() && problemNumbers.size() < MAX_PROBLEMS) {
            int problemNumber = Integer.parseInt(matcher.group(1));
            if (!problemNumbers.contains(problemNumber)) {
                problemNumbers.add(problemNumber);
            }
        }

        // If we didn't find enough problems, try alternative patterns
        if (problemNumbers.size() < MAX_PROBLEMS) {
            // Try pattern for problem IDs in table cells
            pattern = Pattern.compile(">#?(\\d+)<");
            matcher = pattern.matcher(html);
            
            while (matcher.find() && problemNumbers.size() < MAX_PROBLEMS) {
                try {
                    int problemNumber = Integer.parseInt(matcher.group(1));
                    if (problemNumber > 0 && problemNumber <= 1000 && !problemNumbers.contains(problemNumber)) {
                        problemNumbers.add(problemNumber);
                    }
                } catch (NumberFormatException e) {
                    // Skip invalid numbers
                }
            }
        }

        // Sort and limit to first 3
        problemNumbers.sort(Integer::compareTo);
        return problemNumbers.subList(0, Math.min(MAX_PROBLEMS, problemNumbers.size()));
    }

    /**
     * Formats the list of problem numbers as JSON.
     *
     * @param problemNumbers the list of problem numbers
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
