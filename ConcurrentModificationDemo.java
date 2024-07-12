import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationDemo {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");

        try {
            // This will cause ConcurrentModificationException
            for (String item : myList) {
                if ("B".equals(item)) {
                    myList.remove(item); // Modifying the list while iterating
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Caught ConcurrentModificationException: " + e.getMessage());
        }

        // Proper way to remove elements while iterating
        Iterator<String> iterator = myList.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("C".equals(item)) {
                iterator.remove(); // Safe removal
            }
        }

        System.out.println("Modified list: " + myList);
    }
}
