package Lab3;

import java.util.*;

public class ArrayReverse {

    public static void main(String[] args) {

        // Prompt the user to enter the array size
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Prompt the user to enter the array elements
        int[] arr = new int[size];
        System.out.print("Enter the array elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Reverse the array elements
        for (int i = 0; i < size / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[size - i - 1];
            arr[size - i - 1] = temp;
        }

        // Convert the reversed array to HashSet of doubles
        HashSet<Double> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add((double) arr[i]);
        }

        // Perform the operations on the HashSet of doubles
        set.add(10.0); // Add an element to the end of the list
        set.remove(2.0); // Remove an element from the list
        set.remove(4.0); // Remove an element that doesn't exist in the list
        set.remove(10.0); // Remove the element added earlier
        set.add(3.5); // Add an element to the list
        set.remove(5.5); // Remove an element that doesn't exist in the list
        set.remove(3.0); // Remove an element that exists in the list
        set.add(8.0); // Add an element to the list
        set.add(1.0); // Add an element to the list
        set.add(6.0); // Add an element to the list
        set.add(2.5); // Add an element to the list
        set.add(9.0); // Add an element to the list
        set.add(7.0); // Add an element to the list

        // Replace an element in the list
        if (set.contains(3.5)) {
            set.remove(3.5);
            set.add(3.0);
        }

        // Sort the list in alphabetical order
        List<Double> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList, new Comparator<Double>() {
            @Override
            public int compare(Double d1, Double d2) {
                return d1.compareTo(d2);
            }
        });

        // Print the elements of the list
        System.out.println("HashSet of doubles: " + sortedList);

        // Try to access an element outside the bounds of the array
        try {
            int index = arr[size]; // should throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}