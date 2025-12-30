/*
========================================================
FILE: 06_MethodsAndRecursion.java
SECTION 6: METHODS & RECURSION (DSA CORE)
========================================================

Scope:
- Method calls & stack frames
- Parameter passing behavior
- Return values
- Recursion mechanics
- Stack overflow in Java
- When recursion is dangerous
- When to convert recursion to iteration

This section prevents StackOverflowError and logic bugs.
*/

public class MethodsAndRecursion {

    /*
    ----------------------------------------------------
    6.1 What a Method Call Really Does
    ----------------------------------------------------

    When a method is called:
    - A new stack frame is created
    - Parameters + local variables live in that frame
    - Control returns after method finishes
    */

    /*
    Runnable example: method call stack
    */

    /*
    static void methodA() {
        int x = 10;
        methodB();
        // x is still valid here
    }

    static void methodB() {
        int y = 20;
    }

    Execution:
    - methodA stack frame created
    - methodB stack frame created on top
    - methodB frame destroyed
    - methodA continues
    */

    /*
    ----------------------------------------------------
    6.2 Parameter Passing (RECAP, BUT IMPORTANT)
    ----------------------------------------------------

    Parameters are COPIED into the stack frame.
    - Primitives → value copied
    - Objects    → reference value copied
    */

    /*
    Runnable example:
    */

    /*
    static int square(int x) {
        x = x * x;
        return x;
    }

    static void parameterExample() {
        int a = 5;
        int result = square(a);

        System.out.println(a);      // 5
        System.out.println(result); // 25
    }
    */

    /*
    ----------------------------------------------------
    6.3 Return Values (DATA FLOW TOOL)
    ----------------------------------------------------

    Return values are the SAFE way to move data upward
    without side effects.

    DSA rule:
    - Prefer returning values over mutating shared state
    */

    /*
    Runnable example: returning result
    */

    /*
    static int max(int a, int b) {
        return a > b ? a : b;
    }
    */

    /*
    ----------------------------------------------------
    6.4 Recursion Mechanics (HOW IT REALLY WORKS)
    ----------------------------------------------------

    Recursion:
    - Method calling itself
    - Each call gets a NEW stack frame
    - Base case stops recursion

    Components:
    1. Base case
    2. Recursive call
    */

    /*
    Runnable example: factorial
    */

    /*
    static int factorial(int n) {
        if (n == 0) return 1;     // base case
        return n * factorial(n - 1);
    }
    */

    /*
    Execution for factorial(3):
    - factorial(3)
    - factorial(2)
    - factorial(1)
    - factorial(0)
    - unwind stack
    */

    /*
    ----------------------------------------------------
    6.5 Stack Overflow (JAVA LIMIT)
    ----------------------------------------------------

    Each recursive call consumes stack memory.
    Stack size is LIMITED per thread.

    Runnable example (DO NOT RUN):
    */

    /*
    static void infiniteRecursion() {
        infiniteRecursion();
    }
    */

    /*
    Result:
    - StackOverflowError
    - Not catchable for recovery
    - Program crashes

    DSA implication:
    - Deep recursion on skewed trees breaks Java
    */

    /*
    ----------------------------------------------------
    6.6 Java Does NOT Optimize Tail Recursion
    ----------------------------------------------------

    Tail recursion:
    - Recursive call is last operation

    Java does NOT optimize it into iteration.

    Runnable example:
    */

    /*
    static int tailFact(int n, int acc) {
        if (n == 0) return acc;
        return tailFact(n - 1, acc * n);
    }
    */

    /*
    Even this consumes stack per call.
    No tail-call optimization in Java.
    */

    /*
    ----------------------------------------------------
    6.7 When Recursion is BAD in Java
    ----------------------------------------------------

    Avoid recursion when:
    - Depth can reach 10^5 or more
    - Tree is skewed
    - Graph DFS with long chains

    Prefer:
    - Iterative DFS using stack
    - BFS using queue
    */

    /*
    Runnable example: recursion depth risk
    */

    /*
    static void dfs(int node) {
        // dfs(child) calls can go very deep
    }
    */

    /*
    ----------------------------------------------------
    6.8 Converting Recursion to Iteration (DSA SKILL)
    ----------------------------------------------------

    Example: factorial

    Recursive:
        factorial(n)

    Iterative:
    */

    /*
    static int factorialIterative(int n) {
        int result = 1;
        while (n > 0) {
            result *= n;
            n--;
        }
        return result;
    }
    */

    /*
    DSA rule:
    - If recursion depth is unknown or large → iterate
    - Java stack is smaller than C++ stack
    */

    /*
    ----------------------------------------------------
    6.9 Recursion + Shared State (BUG FACTORY)
    ----------------------------------------------------

    Bug example:
    */

    /*
    static int sum = 0;

    static void badRecursion(int n) {
        if (n == 0) return;
        sum += n;
        badRecursion(n - 1);
    }

    Problem:
    - sum persists across calls
    - breaks multiple test cases
    */

    /*
    Correct approach:
    */

    /*
    static int goodRecursion(int n) {
        if (n == 0) return 0;
        return n + goodRecursion(n - 1);
    }
    */

    /*
    ----------------------------------------------------
    6.10 DSA RULES FOR METHODS & RECURSION
    ----------------------------------------------------

    - Each call = stack frame
    - Stack is limited
    - Java has no tail-call optimization
    - Avoid static shared state
    - Prefer return values
    - Convert deep recursion to iteration
    */

    public static void main(String[] args) {
        // Intentionally empty
        // Uncomment examples above to test behavior
    }
}
