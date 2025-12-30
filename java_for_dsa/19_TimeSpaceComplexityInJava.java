/*
========================================================
FILE: 19_TimeSpaceComplexityInJava.java
SECTION 19: TIME & SPACE COMPLEXITY (JAVA-REALISTIC)
========================================================

Scope:
- Big-O basics (applied, not academic)
- Java-specific constant factors
- Time vs space trade-offs
- Amortized analysis (ArrayList, HashMap)
- Recursion stack cost
- Practical DSA complexity evaluation

If you can’t estimate this, you can’t debug TLE/ML.
*/

import java.util.*;

public class TimeSpaceComplexityInJava {

    /*
    ----------------------------------------------------
    19.1 What Big-O Actually Means
    ----------------------------------------------------

    Big-O:
    - Describes growth rate as input size increases
    - Ignores constants, but constants STILL matter in Java

    DSA reality:
    - O(n) with heavy objects can be slower than O(n log n) with primitives
    */

    /*
    ----------------------------------------------------
    19.2 Common Time Complexities (WITH EXAMPLES)
    ----------------------------------------------------
    */

    /*
    O(1): Constant time
    */

    /*
    static int getFirst(int[] arr) {
        return arr[0];
    }
    */

    /*
    O(n): Linear time
    */

    /*
    static int sum(int[] arr) {
        int s = 0;
        for (int x : arr) s += x;
        return s;
    }
    */

    /*
    O(n^2): Quadratic time
    */

    /*
    static int pairCount(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                count++;
            }
        }
        return count;
    }
    */

    /*
    ----------------------------------------------------
    19.3 Java-Specific Time Costs (IMPORTANT)
    ----------------------------------------------------

    Hidden costs in Java:
    - Autoboxing (Integer, Long)
    - Method calls inside loops
    - HashMap hashing & equality
    - Garbage Collection pressure

    DSA rule:
    - Prefer primitives
    - Minimize object creation inside loops
    */

    /*
    ----------------------------------------------------
    19.4 Amortized Analysis (ARRAYLIST)
    ----------------------------------------------------

    ArrayList.add():
    - Usually O(1)
    - Occasionally O(n) during resize
    - Amortized O(1)

    Runnable example:
    */

    /*
    static void amortizedExample() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
    }
    */

    /*
    ----------------------------------------------------
    19.5 HashMap Time Complexity (REALITY)
    ----------------------------------------------------

    Average:
    - put / get → O(1)

    Worst case:
    - O(n) if all keys collide
    - Java converts bucket to tree after threshold

    DSA rule:
    - Good hashCode matters
    */

    /*
    ----------------------------------------------------
    19.6 Space Complexity (STACK + HEAP)
    ----------------------------------------------------

    Space includes:
    - Input storage
    - Auxiliary data structures
    - Recursion stack

    Example: recursion stack
    */

    /*
    static int recursionDepth(int n) {
        if (n == 0) return 0;
        return 1 + recursionDepth(n - 1);
    }

    Space complexity:
    - O(n) stack space
    */

    /*
    ----------------------------------------------------
    19.7 In-Place vs Extra Space
    ----------------------------------------------------

    In-place:
    - Modifies input
    - O(1) extra space

    Extra space:
    - Safer
    - Uses additional memory

    DSA trade-off:
    - Choose based on constraints
    */

    /*
    ----------------------------------------------------
    19.8 Time vs Space Trade-off (CLASSIC)
    ----------------------------------------------------

    Example: frequency counting

    Time-optimized:
    - HashMap → O(n) time, O(n) space

    Space-optimized:
    - Sorting → O(n log n) time, O(1) space
    */

    /*
    ----------------------------------------------------
    19.9 Estimating Feasibility (INTERVIEW SKILL)
    ----------------------------------------------------

    Rough limits:
    - 10^5 → O(n log n) OK
    - 10^6 → O(n) preferred
    - 10^7+ → tight loops only

    Java note:
    - Slower than C++
    - Fast IO and primitives are mandatory
    */

    /*
    ----------------------------------------------------
    19.10 DSA RULES FOR COMPLEXITY
    ----------------------------------------------------

    - Count operations, not lines
    - Consider Java-specific overhead
    - Include recursion stack
    - Avoid object churn
    - Always justify complexity
    */

    public static void main(String[] args) {
        // Intentionally empty
        // Uncomment examples above to test behavior
    }
}

