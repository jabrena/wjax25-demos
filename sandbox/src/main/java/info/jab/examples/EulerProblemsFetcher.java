package info.jab.examples;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EulerProblemsFetcher {
    
    public static void main(String[] args) {
        try {
            // Fetch the Project Euler archives page
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://projecteuler.net/archives"))
                    .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String html = response.body();
            
            // Extract problem numbers from the HTML
            // The problems are typically in links like <a href="problem=1">Problem 1</a>
            List<Integer> problemNumbers = extractProblemNumbers(html);
            
            // Get only the first 3 problems
            List<Integer> firstThree = problemNumbers.stream()
                    .limit(3)
                    .toList();
            
            // Format as JSON
            String json = formatAsJson(firstThree);
            
            // Output in required XML format
            System.out.println("<result>" + json + "</result>");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static List<Integer> extractProblemNumbers(String html) {
        List<Integer> numbers = new ArrayList<>();
        
        // Pattern to match problem links: href="problem=123" or similar patterns
        // Also match patterns like "Problem 1", "Problem 2", etc. in table cells
        Pattern pattern = Pattern.compile("problem=(\\d+)|Problem\\s+(\\d+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(html);
        
        while (matcher.find()) {
            String numStr = matcher.group(1) != null ? matcher.group(1) : matcher.group(2);
            if (numStr != null) {
                try {
                    int num = Integer.parseInt(numStr);
                    if (!numbers.contains(num)) {
                        numbers.add(num);
                    }
                } catch (NumberFormatException e) {
                    // Skip invalid numbers
                }
            }
        }
        
        // Sort to ensure order
        numbers.sort(Integer::compareTo);
        
        return numbers;
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
