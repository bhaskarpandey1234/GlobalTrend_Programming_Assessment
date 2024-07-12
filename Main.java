package trie;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Choose an operation: insert, search, startsWith, or exit");
            String operation = scanner.nextLine();
            
            if (operation.equals("exit")) {
                break;
            }
            
            System.out.println("Enter the word or prefix:");
            String input = scanner.nextLine();
            
            switch (operation) {
                case "insert":
                    trie.insert(input);
                    System.out.println("Word inserted.");
                    break;
                case "search":
                    boolean found = trie.search(input);
                    System.out.println("Word " + (found ? "found." : "not found."));
                    break;
                case "startsWith":
                    boolean starts = trie.startsWith(input);
                    System.out.println("Prefix " + (starts ? "exists." : "does not exist."));
                    break;
                default:
                    System.out.println("Invalid operation.");
                    break;
            }
        }
        
        scanner.close();
    }
}

