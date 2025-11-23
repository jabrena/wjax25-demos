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
            String jsonResult = fetchEulerProblems();
            System.out.println("<result>" + jsonResult + "</result>");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static String fetchEulerProblems() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://projecteuler.net/archives"))
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String html = response.body();
        
        // Extract problem numbers from the HTML
        // The archives page typically has links like "Problem 1", "Problem 2", etc.
        // or table rows with problem numbers
        List<Integer> problemNumbers = extractProblemNumbers(html);
        
        // Take only the first 3
        List<Integer> firstThree = problemNumbers.stream()
                .limit(3)
                .toList();
        
        // Format as JSON
        StringBuilder json = new StringBuilder();
        json.append("{\"List_Integer\":[");
        for (int i = 0; i < firstThree.size(); i++) {
            if (i > 0) {
                json.append(",");
            }
            json.append(firstThree.get(i));
        }
        json.append("]}");
        
        return json.toString();
    }
    
    private static List<Integer> extractProblemNumbers(String html) {
        List<Integer> numbers = new ArrayList<>();
        
        // Pattern to match problem numbers in various formats:
        // - Problem 1, Problem 2, etc.
        // - Links with problem numbers
        // - Table cells with numbers
        
        // Try multiple patterns
        Pattern[] patterns = {
            // Match "Problem 1", "Problem 2", etc.
            Pattern.compile("Problem\\s+(\\d+)", Pattern.CASE_INSENSITIVE),
            // Match links like href="problem=1"
            Pattern.compile("problem[=:]\\s*(\\d+)", Pattern.CASE_INSENSITIVE),
            // Match table rows with problem numbers
            Pattern.compile("<td[^>]*>\\s*(\\d+)\\s*</td>", Pattern.CASE_INSENSITIVE)
        };
        
        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(html);
            while (matcher.find()) {
                try {
                    int num = Integer.parseInt(matcher.group(1));
                    if (num > 0 && !numbers.contains(num)) {
                        numbers.add(num);
                    }
                } catch (NumberFormatException e) {
                    // Skip invalid numbers
                }
            }
            if (!numbers.isEmpty()) {
                break; // Use the first pattern that finds results
            }
        }
        
        // If no numbers found, try a more general approach
        if (numbers.isEmpty()) {
            // Look for any sequence of digits that could be a problem number
            Pattern generalPattern = Pattern.compile("\\b(\\d{1,4})\\b");
            Matcher matcher = generalPattern.matcher(html);
            while (matcher.find()) {
                try {
                    int num = Integer.parseInt(matcher.group(1));
                    if (num > 0 && num <= 1000 && !numbers.contains(num)) {
                        numbers.add(num);
                    }
                } catch (NumberFormatException e) {
                    // Skip invalid numbers
                }
            }
        }
        
        // Sort and return
        numbers.sort(Integer::compareTo);
        return numbers;
    }
}
