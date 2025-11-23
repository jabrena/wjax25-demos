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
    private static final Pattern PROBLEM_PATTERN = Pattern.compile("problem=(\\d+)");

    /**
     * Fetches the Project Euler archives page and extracts problem numbers.
     *
     * @return List of problem numbers (first 3 only)
     */
    public List<Integer> fetchProblemNumbers() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(ARCHIVES_URL))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new IOException("Failed to fetch page: HTTP " + response.statusCode());
            }

            return extractProblemNumbers(response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error fetching Euler problems", e);
        }
    }

    /**
     * Extracts problem numbers from HTML content.
     *
     * @param html the HTML content
     * @return List of problem numbers (first 3 only)
     */
    private List<Integer> extractProblemNumbers(String html) {
        List<Integer> problems = new ArrayList<>();
        Matcher matcher = PROBLEM_PATTERN.matcher(html);

        while (matcher.find() && problems.size() < 3) {
            int problemNumber = Integer.parseInt(matcher.group(1));
            if (!problems.contains(problemNumber)) {
                problems.add(problemNumber);
            }
        }

        return problems;
    }

    /**
     * Formats the problem numbers as JSON.
     *
     * @param problems the list of problem numbers
     * @return JSON string with "List_Integer" key
     */
    public String formatAsJson(List<Integer> problems) {
        StringBuilder json = new StringBuilder("{\"List_Integer\":[");
        for (int i = 0; i < problems.size(); i++) {
            if (i > 0) {
                json.append(",");
            }
            json.append(problems.get(i));
        }
        json.append("]}");
        return json.toString();
    }

    /**
     * Main method to execute the fetcher and output the result.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        EulerProblemsFetcher fetcher = new EulerProblemsFetcher();
        List<Integer> problems = fetcher.fetchProblemNumbers();
        String json = fetcher.formatAsJson(problems);
        System.out.println("<result>" + json + "</result>");
    }
}
