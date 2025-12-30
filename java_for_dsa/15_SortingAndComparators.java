/*
========================================================
FILE: 15_SortingAndComparators.java
SECTION 15: SORTING & COMPARATORS (ORDER CONTROL)
========================================================

Scope:
- Sorting arrays vs lists
- Natural ordering
- Comparable vs Comparator
- Custom sorting
- Stability and performance notes
- DSA pitfalls with comparators

Sorting correctness is as important as sorting speed.
*/

import java.util.*;

public class SortingAndComparators {

    /*
    ----------------------------------------------------
    15.1 Sorting Arrays (FASTEST)
    ----------------------------------------------------

    Arrays.sort():
    - For primitives: Dual-Pivot Quicksort (O(n log n))
    - For objects: TimSort (stable)

    DSA rule:
    - Prefer arrays for performance
    */

    /*
    Runnable example:
    */

    /*
    static void sortPrimitiveArray() {
        int[] arr = {3, 1, 2};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3]
    }
    */

    /*
    ----------------------------------------------------
    15.2 Sorting Lists
    ----------------------------------------------------

    Collections.sort():
    - Uses TimSort
    - Stable
    - O(n log n)

    Equivalent to:
        list.sort(null);
    */

    /*
    Runnable example:
    */

    /*
    static void sortListExample() {
        List<Integer> list = Arrays.asList(3, 1, 2);
        Collections.sort(list);
        System.out.println(list); // [1, 2, 3]
    }
    */

    /*
    ----------------------------------------------------
    15.3 Natural Ordering (Comparable)
    ----------------------------------------------------

    Comparable:
    - Defines natural order INSIDE the class
    - compareTo() implemented by the class itself

    DSA usage:
    - When objects have ONE obvious ordering
    */

    /*
    static class Item implements Comparable<Item> {
        int value;

        Item(int v) {
            value = v;
        }

        @Override
        public int compareTo(Item other) {
            return Integer.compare(this.value, other.value);
        }
    }

    static void comparableExample() {
        Item[] items = {
            new Item(3),
            new Item(1),
            new Item(2)
        };

        Arrays.sort(items);
        System.out.println(items[0].value); // 1
    }
    */

    /*
    ----------------------------------------------------
    15.4 Custom Ordering (Comparator)
    ----------------------------------------------------

    Comparator:
    - External ordering
    - Multiple orderings possible
    - Preferred in DSA

    DSA rule:
    - Prefer Comparator over Comparable
    */

    /*
    Runnable example: descending order
    */

    /*
    static void comparatorExample() {
        Integer[] arr = {3, 1, 2};
        Arrays.sort(arr, (a, b) -> Integer.compare(b, a));
        System.out.println(Arrays.toString(arr)); // [3, 2, 1]
    }
    */

    /*
    ----------------------------------------------------
    15.5 Comparator Overflow Bug (CRITICAL)
    ----------------------------------------------------

    BAD:
        (a, b) -> b - a

    Why bad:
    - Can overflow
    - Produces wrong order

    GOOD:
        Integer.compare(b, a)
    */

    /*
    ----------------------------------------------------
    15.6 Sorting 2D Arrays (VERY COMMON)
    ----------------------------------------------------
    */

    /*
    static void sort2DArray() {
        int[][] arr = {{1, 3}, {2, 2}, {1, 2}};

        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // Result: [[1,2], [1,3], [2,2]]
    }
    */

    /*
    ----------------------------------------------------
    15.7 Stability (WHEN IT MATTERS)
    ----------------------------------------------------

    Stable sort:
    - Maintains relative order of equal elements

    Java:
    - TimSort is stable
    - Arrays.sort on primitives is NOT stable (doesn't matter)

    DSA usage:
    - Rarely critical, but useful in multi-key sorting
    */

    /*
    ----------------------------------------------------
    15.8 Sorting vs PriorityQueue
    ----------------------------------------------------

    Sorting:
    - O(n log n)
    - Best when full order needed

    PriorityQueue:
    - O(n log k)
    - Best for Top-K problems
    */

    /*
    ----------------------------------------------------
    15.9 DSA RULES FOR SORTING
    ----------------------------------------------------

    - Use Arrays.sort for primitives
    - Use Comparator for custom order
    - Avoid subtraction in comparators
    - Choose sorting vs heap wisely
    */

    public static void main(String[] args) {
        // Intentionally empty
        // Uncomment examples above to test behavior
    }
}
