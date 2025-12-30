/*
========================================================
FILE: 13_IterationPatterns.java
SECTION 13: ITERATION PATTERNS (BUG PREVENTION)
========================================================

Scope:
- Index-based loops vs enhanced for
- Iterator usage
- Modifying collections while iterating
- ConcurrentModificationException
- Safe iteration patterns for DSA

Most Java DSA runtime errors come from THIS section.
*/

import java.util.*;

public class IterationPatterns {

    /*
    ----------------------------------------------------
    13.1 Index-Based Loop (MOST CONTROL)
    ----------------------------------------------------

    Use when:
    - You need index
    - You need to modify elements
    - You need backward traversal
    */

    /*
    Runnable example:
    */

    /*
    static void indexLoopExample() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) * 2);
        }

        System.out.println(list); // [2, 4, 6, 8]
    }
    */

    /*
    DSA rule:
    - Safest loop when modification is required
    */

    /*
    ----------------------------------------------------
    13.2 Enhanced for Loop (READ-ONLY INTENT)
    ----------------------------------------------------

    Enhanced for:
    - Simple
    - Cleaner syntax
    - NOT safe for structural modification
    */

    /*
    Runnable example (LOGIC BUG):
    */

    /*
    static void enhancedForBug() {
        int[] arr = {1, 2, 3};
        for (int x : arr) {
            x = x * 2; // modifies copy
        }
        System.out.println(Arrays.toString(arr)); // [1, 2, 3]
    }
    */

    /*
    DSA rule:
    - Use enhanced for for reading only
    */

    /*
    ----------------------------------------------------
    13.3 Modifying Collection While Iterating (CRASH)
    ----------------------------------------------------

    Structural modification during iteration
    causes ConcurrentModificationException.
    */

    /*
    Runnable example (RUNTIME EXCEPTION):
    */

    /*
    static void concurrentModificationBug() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));

        for (Integer x : list) {
            if (x == 2) {
                list.remove(x); // throws exception
            }
        }
    }
    */

    /*
    ----------------------------------------------------
    13.4 Correct Way: Using Iterator
    ----------------------------------------------------
    */

    /*
    static void iteratorRemoval() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == 2) {
                it.remove(); // SAFE
            }
        }

        System.out.println(list); // [1, 3]
    }
    */

    /*
    DSA usage:
    - Rare, but essential when removal during traversal is needed
    */

    /*
    ----------------------------------------------------
    13.5 Reverse Iteration (SAFE REMOVAL)
    ----------------------------------------------------

    Removing from end avoids shifting issues.
    */

    /*
    static void reverseRemoval() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }

        System.out.println(list); // [1, 3]
    }
    */

    /*
    DSA rule:
    - Reverse loop is often simpler than iterator
    */

    /*
    ----------------------------------------------------
    13.6 Iteration Over Maps
    ----------------------------------------------------
    */

    /*
    static void mapIteration() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
    */

    /*
    DSA rule:
    - Prefer entrySet() over keySet() for performance
    */

    /*
    ----------------------------------------------------
    13.7 DSA RULES FOR ITERATION
    ----------------------------------------------------

    - Modify via index or iterator, not enhanced for
    - Expect ConcurrentModificationException otherwise
    - Reverse iteration simplifies removals
    - entrySet() for maps is fastest
    */

    public static void main(String[] args) {
        // Intentionally empty
        // Uncomment examples above to test behavior
    }
}
