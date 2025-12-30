/*
========================================================
FILE: 18_ExceptionHandlingForDSA.java
SECTION 18: EXCEPTION HANDLING (DSA DISCIPLINE)
========================================================

Scope:
- What exceptions really are
- Checked vs unchecked (DSA perspective)
- try / catch / finally mechanics
- Why exceptions are NOT control flow
- Performance implications
- When to use and when to avoid

In DSA, exceptions should be RARE.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ExceptionHandlingForDSA {

    /*
    ----------------------------------------------------
    18.1 What an Exception Is
    ----------------------------------------------------

    Exception:
    - An abnormal event during program execution
    - Breaks normal control flow
    - Creates stack trace (EXPENSIVE)

    DSA implication:
    - Exceptions are slow
    - Do not use them for logic
    */

    /*
    ----------------------------------------------------
    18.2 Checked vs Unchecked (DSA VIEW)
    ----------------------------------------------------

    Checked exceptions:
    - Must be handled or declared
    - Example: IOException

    Unchecked exceptions:
    - RuntimeException and subclasses
    - Example: NullPointerException, IndexOutOfBoundsException

    DSA rule:
    - Avoid code that can throw exceptions
    - Do not rely on try/catch for correctness
    */

    /*
    ----------------------------------------------------
    18.3 try / catch / finally Mechanics
    ----------------------------------------------------

    try:
    - Code that may throw exception

    catch:
    - Handles exception

    finally:
    - Always executes (cleanup)
    */

    /*
    Runnable example:
    */

    /*
    static void tryCatchExample() {
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Division by zero");
        } finally {
            System.out.println("Cleanup");
        }
    }
    */

    /*
    ----------------------------------------------------
    18.4 Why NOT to Use Exceptions for Control Flow
    ----------------------------------------------------

    BAD (logic via exception):
    */

    /*
    static void badLogic(int[] arr) {
        try {
            int x = arr[100];
        } catch (Exception e) {
            // logic here
        }
    }
    */

    /*
    Why bad:
    - Exception creation is expensive
    - Stack trace allocation
    - Slows down loops dramatically
    */

    /*
    GOOD:
    */

    /*
    static void goodLogic(int[] arr) {
        if (arr.length > 100) {
            int x = arr[100];
        }
    }
    */

    /*
    ----------------------------------------------------
    18.5 Exception Cost (PERFORMANCE REALITY)
    ----------------------------------------------------

    Throwing an exception:
    - Allocates exception object
    - Captures stack trace
    - Walks call stack

    DSA rule:
    - Never depend on exceptions inside loops
    */

    /*
    ----------------------------------------------------
    18.6 throws vs try/catch (DSA STYLE)
    ----------------------------------------------------

    In competitive programming:
    - Prefer throws in main
    - Avoid cluttering code with try/catch
    */

    /*
    Runnable example:
    */

    /*
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
    }
    */

    /*
    ----------------------------------------------------
    18.7 finally Block (WHEN IT MATTERS)
    ----------------------------------------------------

    finally:
    - Used for resource cleanup
    - Rarely needed in DSA

    DSA reality:
    - Short-lived programs
    - OS cleans resources on exit
    */

    /*
    ----------------------------------------------------
    18.8 Common Runtime Exceptions in DSA
    ----------------------------------------------------

    - NullPointerException
    - ArrayIndexOutOfBoundsException
    - NumberFormatException
    - StackOverflowError

    Rule:
    - Fix root cause, don't catch blindly
    */

    /*
    ----------------------------------------------------
    18.9 DSA RULES FOR EXCEPTIONS
    ----------------------------------------------------

    - Avoid exceptions in logic
    - Never use exceptions for flow control
    - Prefer checks over try/catch
    - Use throws in main for IO
    */

    public static void main(String[] args) {
        // Intentionally empty
        // Uncomment examples above to test behavior
    }
}
