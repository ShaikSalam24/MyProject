import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class URLShortener {
    private Map<String, String> urlMapping;

    public URLShortener() {
        this.urlMapping = new HashMap<>();
    }

    public String shortenURL(String longURL) {
        String shortURL = generateShortURL(longURL);
        urlMapping.put(shortURL, longURL);
        return shortURL;
    }

    public String expandURL(String shortURL) {
        return urlMapping.get(shortURL);
    }

    private String generateShortURL(String longURL) {
        // Basic hash function for simplicity
        int hash = longURL.hashCode();
        return "short_" + Math.abs(hash);
    }

    public static void main(String[] args) {
        URLShortener urlShortener = new URLShortener();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Shorten URL");
            System.out.println("2. Expand URL");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter long URL: ");
                    String longURL = scanner.nextLine();
                    String shortURL = urlShortener.shortenURL(longURL);
                    System.out.println("Shortened URL: " + shortURL);
                    break;

                case 2:
                    System.out.print("Enter short URL: ");
                    String inputShortURL = scanner.nextLine();
                    String expandedURL = urlShortener.expandURL(inputShortURL);
                    if (expandedURL != null) {
                        System.out.println("Expanded URL: " + expandedURL);
                    } else {
                        System.out.println("Invalid short URL.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
