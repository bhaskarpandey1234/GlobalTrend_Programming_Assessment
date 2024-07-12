import java.util.Scanner;
import java.util.Stack;

public class BracketValidator {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        BracketValidator validator = new BracketValidator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string containing just the characters '(', ')', '{', '}', '[', and ']':");
        String input = scanner.nextLine();

        if (validator.isValid(input)) {
            System.out.println("The input string is valid.");
        } else {
            System.out.println("The input string is invalid.");
        }

        scanner.close();
    }
}

