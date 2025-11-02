package info.jab.examples;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Fetches and extracts Euler problem numbers from Project Euler archives page.
 */
public class EulerProblemFetcher {

    private static final String ARCHIVES_URL = "https://projecteuler.net/archives";
    private static final int MAX_PROBLEMS = 2;

    /**
     * Fetches the archives page and extracts problem numbers.
     *
     * @return List of problem numbers as integers
     * @throws IOException if the page cannot be fetched
     */
    public List<Integer> fetchProblemNumbers() throws IOException {
        Document doc = Jsoup.connect(ARCHIVES_URL)
                .userAgent("Mozilla/5.0")
                .timeout(10000)
                .get();

        List<Integer> problemNumbers = new ArrayList<>();

        // Project Euler archives page typically has links to problems
        // They are usually in format like "problem=1", "problem=2", etc.
        Elements links = doc.select("a[href*='problem=']");
        
        // Extract problem numbers from href attributes
        Pattern problemPattern = Pattern.compile("problem=(\\d+)");
        
        for (Element link : links) {
            String href = link.attr("href");
            Matcher matcher = problemPattern.matcher(href);
            if (matcher.find()) {
                try {
                    int problemNumber = Integer.parseInt(matcher.group(1));
                    if (!problemNumbers.contains(problemNumber)) {
                        problemNumbers.add(problemNumber);
                    }
                } catch (NumberFormatException e) {
                    // Skip invalid numbers
                }
            }
            
            // Stop after collecting the required number of problems
            if (problemNumbers.size() >= MAX_PROBLEMS) {
                break;
            }
        }
        
        // Sort to ensure we get the first problems in order
        problemNumbers.sort(Integer::compareTo);
        
        // Limit to first MAX_PROBLEMS
        if (problemNumbers.size() > MAX_PROBLEMS) {
            return problemNumbers.subList(0, MAX_PROBLEMS);
        }
        
        return problemNumbers;
    }

    /**
     * Generates JSON format with List_Integer key.
     *
     * @param problemNumbers List of problem numbers
     * @return JSON string
     */
    public String generateJson(List<Integer> problemNumbers) {
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

    /**
     * Main method to execute the fetcher and output the result.
     */
    public static void main(String[] args) {
        EulerProblemFetcher fetcher = new EulerProblemFetcher();
        try {
            List<Integer> problemNumbers = fetcher.fetchProblemNumbers();
            String json = fetcher.generateJson(problemNumbers);
            System.out.println("<result>" + json + "</result>");
        } catch (IOException e) {
            System.err.println("Error fetching Euler problems: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
