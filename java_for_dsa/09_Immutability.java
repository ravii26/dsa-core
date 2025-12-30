/*
========================================================
FILE: 09_Immutability.java
SECTION 9: IMMUTABILITY vs MUTABILITY (STATE SAFETY)
========================================================

Scope:
- What immutability actually means
- Mutable vs immutable data
- Why immutability exists
- Performance trade-offs
- DSA bugs caused by shared mutable state
- When to deep copy vs reuse

This section prevents invisible logic corruption.
*/

import java.util.ArrayList;
import java.util.List;

public class ImmutabilityDSA {

    /*
    ----------------------------------------------------
    9.1 What Immutability Means (PRECISE DEFINITION)
    ----------------------------------------------------

    An immutable object:
    - Cannot change its internal state after creation
    - Any "modification" returns a NEW object

    Examples:
    - String
    - Integer
    - Long

    Mutable objects:
    - Arrays
    - ArrayList
    - Custom objects with setters/fields
    */

    /*
    ----------------------------------------------------
    9.2 Why Immutability Exists
    ----------------------------------------------------

    Reasons:
    - Thread safety
    - Predictable behavior
    - Safe sharing of objects
    - No accidental side effects

    DSA relevance:
    - Prevents bugs when same value is reused
    - But costs performance if overused
    */

    /*
    ----------------------------------------------------
    9.3 Immutable Example (String)
    ----------------------------------------------------
    */

    /*
    static void immutableExample() {
        String s = "abc";
        s.concat("d");

        System.out.println(s); // abc
    }

    Explanation:
    - concat() creates a new String
    - original string remains unchanged
    */

    /*
    ----------------------------------------------------
    9.4 Mutable Example (Array)
    ----------------------------------------------------
    */

    /*
    static void mutableArrayExample() {
        int[] arr = {1, 2, 3};
        arr[0] = 99;

        System.out.println(arr[0]); // 99
    }

    Explanation:
    - Same object modified
    - No new array created
    */

    /*
    ----------------------------------------------------
    9.5 Shared Mutable State (DSA BUG FACTORY)
    ----------------------------------------------------

    This is one of the MOST common backtracking bugs.
    */

    /*
    static List<Integer> path = new ArrayList<>();

    static void badBacktracking(int n) {
        if (n == 0) {
            System.out.println(path);
            return;
        }

        path.add(n);
        badBacktracking(n - 1);
        // BUG: missing cleanup
    }

    Calling badBacktracking(2) prints wrong paths
    because path is shared and never cleaned.
    */

    /*
    ----------------------------------------------------
    9.6 Correct Backtracking (CONTROLLED MUTATION)
    ----------------------------------------------------
    */

    /*
    static void goodBacktracking(int n, List<Integer> path) {
        if (n == 0) {
            System.out.println(path);
            return;
        }

        path.add(n);
        goodBacktracking(n - 1, path);
        path.remove(path.size() - 1); // cleanup
    }

    Explanation:
    - Same list reused
    - State restored after recursive call
    */

    /*
    ----------------------------------------------------
    9.7 Deep Copy vs Reuse (WHEN TO CHOOSE WHAT)
    ----------------------------------------------------

    Deep copy:
    - Safe
    - Slower
    - More memory

    Reuse with cleanup:
    - Faster
    - Error-prone if cleanup forgotten
    */

    /*
    Runnable example: deep copy
    */

    /*
    static void deepCopyExample() {
        List<Integer> a = new ArrayList<>();
        a.add(1);

        List<Integer> b = new ArrayList<>(a); // deep copy
        b.add(2);

        System.out.println(a); // [1]
        System.out.println(b); // [1, 2]
    }
    */

    /*
    DSA rule:
    - Prefer reuse + cleanup in backtracking
    - Prefer deep copy when passing state across branches
    */

    /*
    ----------------------------------------------------
    9.8 Performance Reality
    ----------------------------------------------------

    - Immutability is safer but slower
    - DSA prefers controlled mutability
    - Avoid creating objects inside tight loops
    */

    /*
    ----------------------------------------------------
    9.9 DSA RULES FOR IMMUTABILITY
    ----------------------------------------------------

    - Know which types are immutable
    - Avoid shared mutable state
    - Clean up after mutation in recursion
    - Deep copy only when isolation is required
    */

    public static void main(String[] args) {
        // Intentionally empty
        // Uncomment examples above to test behavior
    }
}
