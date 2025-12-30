/*
========================================================
SECTION 1: JAVA LANGUAGE SKELETON (NO CONFUSION ALLOWED)
========================================================

Every Java program that runs must follow this structure.
Understanding WHY each keyword exists prevents silent bugs
in DSA and online judge environments.
*/

public class JavaBasics {

    /*
    ----------------------------------------------------
    1.1 class (WHY EVERYTHING LIVES INSIDE A CLASS)
    ----------------------------------------------------

    Java is a class-based language.
    All executable code MUST belong to a class.

    - A class is a blueprint, not execution itself
    - JVM loads classes, not files
    - File name MUST match public class name

    DSA relevance:
    - Online judges load ONE public class
    - Multiple public classes = compilation error
    */

    /*
    ----------------------------------------------------
    1.2 public (ACCESSIBILITY TO JVM)
    ----------------------------------------------------

    public:
    - Allows JVM to access this class
    - JVM must see the entry point class

    If class is not public:
    - JVM cannot load it as entry point

    DSA relevance:
    - main class must be public
    */

    /*
    ----------------------------------------------------
    1.3 static (WHY MAIN DOES NOT NEED AN OBJECT)
    ----------------------------------------------------

    static means:
    - Belongs to class, not to objects
    - Can be called without creating an instance

    Why main() is static:
    - JVM starts execution WITHOUT creating objects
    - JVM calls main() directly using class name

    Example (runnable logic):

    static void staticExample() {
        System.out.println("Static method called");
    }

    static void caller() {
        staticExample(); // works
    }

    Non-static methods require objects.
    */

    /*
    ----------------------------------------------------
    1.4 void (WHY MAIN RETURNS NOTHING)
    ----------------------------------------------------

    void means:
    - Method does not return any value

    main() returns void because:
    - JVM does not expect any return value
    - Program termination is controlled by JVM

    Returning a value from main is meaningless.
    */

    /*
    ----------------------------------------------------
    1.5 String[] args (COMMAND LINE INPUT)
    ----------------------------------------------------

    args:
    - An array of String
    - Stores command-line arguments

    Example:

    Run:
        java JavaBasics one two three

    args content:
        args[0] = "one"
        args[1] = "two"
        args[2] = "three"

    Runnable example:

    static void argsExample(String[] args) {
        for (String s : args) {
            System.out.println(s);
        }
    }

    DSA relevance:
    - Rarely used in contests
    - Still required by JVM signature
    */

    /*
    ----------------------------------------------------
    1.6 Static Context Rules (DSA PITFALL)
    ----------------------------------------------------

    Rule:
    - static methods CANNOT directly access non-static members

    Runnable example (compile-time error):

    int x = 10;

    static void invalidAccess() {
        System.out.println(x); // ERROR
    }

    Correct way:

    static int y = 20;

    static void validAccess() {
        System.out.println(y); // OK
    }

    Or via object:

    void instanceMethod() {
        System.out.println(x);
    }

    static void callInstance() {
        JavaBasics obj = new JavaBasics();
        System.out.println(obj.x);
    }

    DSA relevance:
    - All helper methods in contests are static
    - Avoid instance state to prevent cross-testcase bugs
    */

    /*
    ----------------------------------------------------
    1.7 Why DSA Code Is Usually STATIC
    ----------------------------------------------------

    Reasons:
    - No object creation overhead
    - Cleaner structure
    - Avoids shared mutable state
    - Works safely with multiple test cases

    DSA rule:
    - Prefer static methods + local variables
    - Avoid class-level mutable fields unless necessary
    */

   /*
    ----------------
    Runnable Example: Static State Bug
    ----------------

    static int counter = 0;

    static void solveTestCase() {
        counter++;
        System.out.println(counter);
    }

    Imagine an online judge running multiple test cases:

    Test Case 1:
        solveTestCase();  // prints 1

    Test Case 2:
        solveTestCase();  // prints 2  (BUG!)

    Why this is a bug:
    - static variables persist across method calls
    - Online judges often reuse the same class instance
    - Static state is NOT reset automatically

    Correct approach:
    - Reset static variables manually
    - OR avoid static mutable fields entirely

    Fixed version:

    static void solveTestCaseFixed() {
        int counter = 0;  // local to test case
        counter++;
        System.out.println(counter); // always prints 1
    }

    DSA rule:
    - Never store per-test-case data in static fields
    - Use local variables inside solve() methods
    */


    public static void main(String[] args) {
        // Entry point for execution
        // DSA solutions start from here
    }
}
