/*
========================================================
FILE: 12_CollectionsFramework.java
SECTION 12: COLLECTIONS FRAMEWORK (DSA TOOLBOX)
========================================================

Scope:
- What the Collections Framework is
- List / Set / Map hierarchy (DSA view)
- ArrayList vs LinkedList
- HashSet vs TreeSet
- HashMap vs TreeMap
- Time complexity + internal behavior
- DSA-appropriate choices

This section teaches WHEN and WHY to use each structure.
*/

import java.util.*;

public class CollectionsFrameworkDSA {

    /*
    ----------------------------------------------------
    12.1 What the Collections Framework Is
    ----------------------------------------------------

    Collections Framework:
    - A set of interfaces + implementations
    - Designed to store and manipulate groups of objects

    Core interfaces used in DSA:
    - List
    - Set
    - Map

    DSA rule:
    - Choose structure based on access pattern,
      not convenience.
    */

    /*
    ----------------------------------------------------
    12.2 List Interface (ORDERED, DUPLICATES ALLOWED)
    ----------------------------------------------------

    List properties:
    - Maintains insertion order
    - Allows duplicates
    - Index-based access
    */

    /*
    ----------------------------------------------------
    12.3 ArrayList (MOST USED LIST)
    ----------------------------------------------------

    Internal structure:
    - Backed by a dynamic array

    Characteristics:
    - get(i)        → O(1)
    - add(end)      → amortized O(1)
    - add(index)    → O(n)
    - remove(index) → O(n)

    Runnable example:
    */

    /*
    static void arrayListExample() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(0); // shifts elements

        System.out.println(list); // [2, 3]
    }
    */

    /*
    DSA rule:
    - Avoid remove(0) in ArrayList
    - Use ArrayList for random access
    */

    /*
    ----------------------------------------------------
    12.4 LinkedList (RARELY OPTIMAL)
    ----------------------------------------------------

    Internal structure:
    - Doubly linked list

    Characteristics:
    - get(i)        → O(n)
    - add/remove    → O(1) IF node known

    Runnable example:
    */

    /*
    static void linkedListExample() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(0); // still O(1) here, but traversal costs exist
        System.out.println(list);
    }
    */

    /*
    DSA reality:
    - LinkedList almost never beats ArrayList
    - Pointer overhead kills cache performance
    */

    /*
    ----------------------------------------------------
    12.5 Set Interface (UNIQUE ELEMENTS)
    ----------------------------------------------------

    Set properties:
    - No duplicates
    - No index-based access
    */

    /*
    ----------------------------------------------------
    12.6 HashSet (FAST UNIQUE STORAGE)
    ----------------------------------------------------

    Internal structure:
    - Backed by HashMap

    Characteristics:
    - add / remove / contains → O(1) average
    - Order NOT guaranteed

    Runnable example:
    */

    /*
    static void hashSetExample() {
        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(1);
        set.add(2);
        set.add(1); // duplicate ignored

        System.out.println(set.contains(2)); // true
        System.out.println(set);
    }
    */

    /*
    DSA rule:
    - Use HashSet for visited, uniqueness checks
    */

    /*
    ----------------------------------------------------
    12.7 TreeSet (SORTED UNIQUE ELEMENTS)
    ----------------------------------------------------

    Internal structure:
    - Red-Black Tree

    Characteristics:
    - add / remove / contains → O(log n)
    - Elements are always sorted

    Runnable example:
    */

    /*
    static void treeSetExample() {
        Set<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(1);
        set.add(2);

        System.out.println(set); // [1, 2, 3]
    }
    */

    /*
    DSA rule:
    - Use TreeSet ONLY when sorted order is required
    */

    /*
    ----------------------------------------------------
    12.8 Map Interface (KEY → VALUE, DSA GOLD)
    ----------------------------------------------------

    Map properties:
    - Key-value pairs
    - Keys must be unique
    */

    /*
    ----------------------------------------------------
    12.9 HashMap (MOST IMPORTANT MAP)
    ----------------------------------------------------

    Internal structure:
    - Array of buckets
    - Buckets contain linked list / tree

    Characteristics:
    - get / put / remove → O(1) average
    - Order NOT guaranteed

    Runnable example:
    */

    /*
    static void hashMapExample() {
        Map<Integer, Integer> freq = new HashMap<>();

        int[] arr = {1, 2, 1, 3, 2, 1};
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        System.out.println(freq); // frequency map
    }
    */

    /*
    DSA rule:
    - HashMap is default choice for counting & mapping
    */

    /*
    ----------------------------------------------------
    12.10 TreeMap (SORTED KEYS)
    ----------------------------------------------------

    Internal structure:
    - Red-Black Tree

    Characteristics:
    - Operations → O(log n)
    - Keys always sorted

    Runnable example:
    */

    /*
    static void treeMapExample() {
        Map<Integer, String> map = new TreeMap<>();
        map.put(3, "c");
        map.put(1, "a");
        map.put(2, "b");

        System.out.println(map); // keys sorted
    }
    */

    /*
    DSA rule:
    - Use TreeMap only if sorted traversal is required
    */

    /*
    ----------------------------------------------------
    12.11 Choosing the RIGHT Collection (DSA SUMMARY)
    ----------------------------------------------------

    - Need fast random access → ArrayList
    - Need uniqueness          → HashSet
    - Need frequency mapping   → HashMap
    - Need sorted keys         → TreeMap / TreeSet
    - Need dynamic resizing    → Collections
    - Need max performance     → Arrays

    Wrong choice = TLE or WA.
    */

    public static void main(String[] args) {
        // Intentionally empty
        // Uncomment examples above to test behavior
    }
}
