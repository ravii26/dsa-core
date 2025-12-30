/*
========================================================
FILE: 05_ControlFlow.java
SECTION 5: CONTROL FLOW (DSA-FIRST)
========================================================

Scope:
- if / else
- switch (minimal, correct usage)
- loops: for, while, do-while
- loop invariants (DSA thinking)
- break / continue pitfalls
- choosing the right loop for DSA patterns
*/

public class ControlFlow {

    /*
    ----------------------------------------------------
    5.1 if / else (BRANCHING WITH INTENT)
    ----------------------------------------------------

    if / else controls execution based on conditions.
    Conditions must be boolean (no implicit conversions).

    DSA rule:
    - Keep conditions simple
    - Avoid side-effects inside conditions
    */

    /*
    Runnable example: basic branching
    */

    /*
    static void ifElseExample(int x) {
        if (x < 0) {
            System.out.println("negative");
        } else if (x == 0) {
            System.out.println("zero");
        } else {
            System.out.println("positive");
        }
    }
    */

    /*
    DSA pitfall:
    - Writing complex conditions that hide bugs
    - Prefer early returns when possible
    */

    /*
    ----------------------------------------------------
    5.2 switch (WHEN IT MAKES SENSE)
    ----------------------------------------------------

    switch is useful for:
    - small, fixed sets of values
    - readability over multiple else-if

    DSA rule:
    - Do NOT use switch for ranges
    - Prefer if/else for dynamic conditions
    */

    /*
    Runnable example: switch on int
    */

    /*
    static void switchExample(int day) {
        switch (day) {
            case 1:
                System.out.println("Mon");
                break;
            case 2:
                System.out.println("Tue");
                break;
            default:
                System.out.println("Other");
        }
    }
    */

    /*
    ----------------------------------------------------
    5.3 for Loop (INDEX-CONTROLLED ITERATION)
    ----------------------------------------------------

    for loop is best when:
    - Number of iterations is known
    - Index-based access is needed

    DSA usage:
    - Arrays
    - Prefix sums
    - DP tables
    */

    /*
    Runnable example: array traversal
    */

    /*
    static void forLoopExample() {
        int[] arr = {1, 2, 3, 4};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    */

    /*
    DSA pitfall:
    - Off-by-one errors
    - Using <= instead of <
    */

    /*
    ----------------------------------------------------
    5.4 while Loop (CONDITION-CONTROLLED ITERATION)
    ----------------------------------------------------

    while loop is best when:
    - Number of iterations is NOT known
    - Loop depends on a condition changing inside

    DSA usage:
    - Two pointers
    - Binary search
    - Sliding window
    */

    /*
    Runnable example: two pointers
    */

    /*
    static void whileLoopExample() {
        int l = 0, r = 5;
        while (l < r) {
            System.out.println(l + " " + r);
            l++;
            r--;
        }
    }
    */

    /*
    DSA rule:
    - while dominates pointer-based problems
    */

    /*
    ----------------------------------------------------
    5.5 do-while Loop (RARE BUT SPECIFIC)
    ----------------------------------------------------

    do-while executes AT LEAST ONCE.

    DSA usage:
    - Almost never required
    - Avoid unless logic explicitly demands it
    */

    /*
    Runnable example:
    */

    /*
    static void doWhileExample() {
        int x = 0;
        do {
            System.out.println(x);
            x++;
        } while (x < 3);
    }
    */

    /*
    ----------------------------------------------------
    5.6 break and continue (CONTROL FLOW WEAPONS)
    ----------------------------------------------------

    break:
    - Exits loop immediately

    continue:
    - Skips current iteration

    DSA usage:
    - break: early exit on condition
    - continue: skip invalid states
    */

    /*
    Runnable example:
    */

    /*
    static void breakContinueExample() {
        for (int i = 0; i < 5; i++) {
            if (i == 2) continue;
            if (i == 4) break;
            System.out.print(i + " ");
        }
        // Output: 0 1 3
    }
    */

    /*
    DSA pitfall:
    - Overusing continue makes logic hard to follow
    */

    /*
    ----------------------------------------------------
    5.7 Loop Invariants (DSA THINKING TOOL)
    ----------------------------------------------------

    Loop invariant:
    - A condition that remains true before and after each iteration

    Example: prefix sum
    */

    /*
    static void loopInvariantExample() {
        int[] arr = {1, 2, 3, 4};
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            // Invariant: sum == sum of arr[0..i-1]
            sum += arr[i];
        }

        System.out.println(sum); // 10
    }
    */

    /*
    DSA rule:
    - If you can state the invariant, your loop is correct
    - If you cannot, expect bugs
    */

    /*
    ----------------------------------------------------
    5.8 Choosing the RIGHT Control Structure
    ----------------------------------------------------

    Summary:
    - if/else     → branching logic
    - for         → fixed iteration, index-based
    - while       → condition-based, pointers
    - break       → early exit
    - continue    → skip state

    DSA rule:
    - Choose structure based on problem pattern,
      not personal habit
    */

    public static void main(String[] args) {
        // Intentionally empty
        // Uncomment examples above to test behavior
    }
}
