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
    private static final Pattern PROBLEM_PATTERN = Pattern.compile(
        "<td class=\"id_column\">(\\d+)</td>",
        Pattern.CASE_INSENSITIVE
    );

    public static void main(String[] args) {
        try {
            List<Integer> problemNumbers = fetchEulerProblems();
            
            // Get only the first 3 problems
            List<Integer> firstThree = problemNumbers.stream()
                .limit(3)
                .toList();
            
            // Format as JSON
            String json = formatAsJson(firstThree);
            
            // Output in XML format
            System.out.println("<result>" + json + "</result>");
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static List<Integer> fetchEulerProblems() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(ARCHIVES_URL))
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() != 200) {
            throw new IOException("Failed to fetch page: HTTP " + response.statusCode());
        }

        String html = response.body();
        List<Integer> problems = new ArrayList<>();
        
        Matcher matcher = PROBLEM_PATTERN.matcher(html);
        while (matcher.find()) {
            int problemNumber = Integer.parseInt(matcher.group(1));
            problems.add(problemNumber);
        }
        
        // Sort to ensure order (though they should already be in order)
        problems.sort(Integer::compareTo);
        
        return problems;
    }

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
