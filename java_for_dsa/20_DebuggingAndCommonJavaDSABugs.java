/*
========================================================
FILE: 20_DebuggingAndCommonJavaDSABugs.java
SECTION 20: DEBUGGING & COMMON JAVA DSA BUGS
========================================================

Scope:
- Silent wrong-answer bugs
- Java-specific traps
- Debugging strategy for DSA
- How to think when code "looks right"

If your logic is correct but output is wrong — it’s here.
*/

import java.util.*;

public class DebuggingAndCommonJavaDSABugs {

    /*
    ----------------------------------------------------
    20.1 Off-by-One Errors (MOST COMMON)
    ----------------------------------------------------

    Usually caused by:
    - Using <= instead of <
    - Wrong start/end indices

    Runnable example (BUG):
    */

    /*
    static void offByOneBug() {
        int[] arr = {1, 2, 3};
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i]); // crash at i = 3
        }
    }
    */

    /*
    Correct:
    */

    /*
    for (int i = 0; i < arr.length; i++)
    */

    /*
    ----------------------------------------------------
    20.2 Integer Overflow (SILENT WRONG ANSWER)
    ----------------------------------------------------

    Java does NOT throw exception on overflow.

    Runnable example:
    */

    /*
    static void overflowBug() {
        int a = 1_000_000_000;
        int b = 1_000_000_000;

        int sum = a + b;
        System.out.println(sum); // WRONG (overflow)
    }
    */

    /*
    Correct:
    */

    /*
    long sum = (long) a + b;
    */

    /*
    DSA rule:
    - Use long for sums, products, counters
    */

    /*
    ----------------------------------------------------
    20.3 Forgetting to Reset State Between Test Cases
    ----------------------------------------------------

    Very common with static/global variables.
    */

    /*
    static int count = 0;

    static void solve() {
        count++;
        System.out.println(count);
    }

    Multiple test cases:
    - Outputs keep increasing (BUG)
    */

    /*
    Fix:
    - Reset state inside solve()
    - Avoid static mutable fields
    */

    /*
    ----------------------------------------------------
    20.4 Using == Instead of equals()
    ----------------------------------------------------
    */

    /*
    static void stringComparisonBug() {
        String a = new String("abc");
        String b = new String("abc");

        System.out.println(a == b); // false (BUG)
    }
    */

    /*
    Always:
        a.equals(b)
    */

    /*
    ----------------------------------------------------
    20.5 Mutating Keys in HashMap / HashSet
    ----------------------------------------------------

    This breaks lookup silently.
    */

    /*
    static class Key {
        int x;

        Key(int x) {
            this.x = x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x);
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Key)) return false;
            return this.x == ((Key) o).x;
        }
    }

    static void mutableKeyBug() {
        Map<Key, Integer> map = new HashMap<>();
        Key k = new Key(1);

        map.put(k, 10);
        k.x = 2;

        System.out.println(map.get(k)); // null (BUG)
    }
    */

    /*
    ----------------------------------------------------
    20.6 Forgetting Deep Copy in Backtracking
    ----------------------------------------------------

    Common mistake:
    */

    /*
    static void badBacktracking(List<Integer> path, int n) {
        if (n == 0) {
            System.out.println(path);
            return;
        }

        path.add(n);
        badBacktracking(path, n - 1);
        // missing cleanup
    }
    */

    /*
    Correct:
        path.remove(path.size() - 1);
    */

    /*
    ----------------------------------------------------
    20.7 Modifying Collection During Iteration
    ----------------------------------------------------

    Causes ConcurrentModificationException.
    */

    /*
    for (Integer x : list) {
        list.remove(x); // crash
    }
    */

    /*
    Fix:
    - Use iterator
    - Or reverse index loop
    */

    /*
    ----------------------------------------------------
    20.8 Using Recursion Where Iteration Is Required
    ----------------------------------------------------

    Java stack is small.
    */

    /*
    static void deepRecursion(int n) {
        if (n == 0) return;
        deepRecursion(n - 1);
    }

    n = 10^5 → StackOverflowError
    */

    /*
    Fix:
    - Convert to iterative solution
    */

    /*
    ----------------------------------------------------
    20.9 Debugging Strategy (DSA-STYLE)
    ----------------------------------------------------

    When stuck:
    1. Print small input cases
    2. Trace variable values manually
    3. Check boundaries and conditions
    4. Verify data structure invariants
    5. Re-check Java-specific behavior

    Never assume Java behaves like C++.
    */

    /*
    ----------------------------------------------------
    20.10 FINAL DSA DEBUGGING RULES
    ----------------------------------------------------

    - Trust invariants, not intuition
    - Assume overflow until proven otherwise
    - Reset state every test case
    - Prefer simple control flow
    - Java punishes sloppiness
    */

    public static void main(String[] args) {
        // Intentionally empty
        // Uncomment examples above to test behavior
    }
}
