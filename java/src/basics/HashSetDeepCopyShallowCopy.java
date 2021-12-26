package basics;

import java.util.HashSet;

public class HashSetDeepCopyShallowCopy {
    public static void main(String args[])
    {
        // Creating an empty HashSet
        HashSet<String> set = new HashSet<String>();

        // Use add() method to add elements into the Set
        set.add("Welcome");
        set.add("To");
        set.add("Geeks");
        set.add("4");
        set.add("Geeks");

        // Displaying the HashSet
        System.out.println("HashSet: " + set);

        // Creating a new cloned set
        HashSet cloned_set = new HashSet();

        // Cloning the set using clone() method
        cloned_set = (HashSet)set.clone();

        // Displaying the new Set after Cloning;
        System.out.println("The new set: " + cloned_set);
        set.add("Hi");
        System.out.println("The new set: " + cloned_set);
    }
}
