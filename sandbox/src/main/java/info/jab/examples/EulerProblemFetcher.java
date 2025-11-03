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
 * Fetches Euler problem numbers from Project Euler archives page.
 */
public class EulerProblemFetcher {

    private static final String ARCHIVES_URL = "https://projecteuler.net/archives";
    private static final Pattern PROBLEM_NUMBER_PATTERN = Pattern.compile(
        "href=\"/problem=(\\d+)\"|<a href=\"/problem=(\\d+)\"|<td[^>]*>\\s*(\\d+)\\s*</td>"
    );

    public static void main(String[] args) {
        try {
            EulerProblemFetcher fetcher = new EulerProblemFetcher();
            List<Integer> problemNumbers = fetcher.fetchProblemNumbers(10);
            String json = formatAsJson(problemNumbers);
            System.out.println("<result>" + json + "</result>");
        } catch (Exception e) {
            System.err.println("Error fetching Euler problems: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Integer> fetchProblemNumbers(int limit) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ARCHIVES_URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String html = response.body();

        return parseProblemNumbers(html, limit);
    }

    private List<Integer> parseProblemNumbers(String html, int limit) {
        List<Integer> problemNumbers = new ArrayList<>();
        
        // Try multiple patterns to find problem numbers
        // Pattern 1: href="/problem=123"
        Pattern pattern1 = Pattern.compile("href=\"/problem=(\\d+)\"");
        Matcher matcher1 = pattern1.matcher(html);
        
        while (matcher1.find() && problemNumbers.size() < limit) {
            int problemNumber = Integer.parseInt(matcher1.group(1));
            if (!problemNumbers.contains(problemNumber)) {
                problemNumbers.add(problemNumber);
            }
        }

        // If we didn't find enough, try alternative patterns
        if (problemNumbers.size() < limit) {
            // Pattern 2: Look for table rows with problem numbers
            Pattern pattern2 = Pattern.compile("<tr[^>]*>\\s*<td[^>]*>\\s*(\\d+)\\s*</td>");
            Matcher matcher2 = pattern2.matcher(html);
            
            while (matcher2.find() && problemNumbers.size() < limit) {
                int problemNumber = Integer.parseInt(matcher2.group(1));
                if (!problemNumbers.contains(problemNumber)) {
                    problemNumbers.add(problemNumber);
                }
            }
        }

        // Sort and limit to first N
        problemNumbers.sort(Integer::compareTo);
        return problemNumbers.stream()
                .limit(limit)
                .toList();
    }

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
