/*
========================================================
FILE: 04_PassByValue.java
SECTION 4: JAVA IS PASS-BY-VALUE (THE MOST MISUNDERSTOOD RULE)
========================================================

Scope:
- What pass-by-value ACTUALLY means in Java
- Why Java looks like pass-by-reference
- Why swaps fail
- Why array/object mutation works
- Wrapper class surprises

This section removes one of the most common interview traps.
*/

public class PassByValue {

    /*
    ----------------------------------------------------
    4.1 The Core Rule (NO EXCEPTIONS)
    ----------------------------------------------------

    Java ALWAYS passes arguments by VALUE.

    - For primitives → value is the actual data
    - For objects   → value is the reference (address)

    Java NEVER passes variables themselves.
    */

    /*
    ----------------------------------------------------
    4.2 Primitive Pass-by-Value (SIMPLE CASE)
    ----------------------------------------------------
    */

    /*
    static void modifyPrimitive(int x) {
        x = 100;
    }

    static void primitiveExample() {
        int a = 10;
        modifyPrimitive(a);
        System.out.println(a); // 10
    }

    Explanation:
    - x gets a COPY of a
    - Modifying x does not affect a
    */

    /*
    ----------------------------------------------------
    4.3 Object Pass-by-Value (CONFUSING CASE)
    ----------------------------------------------------
    */

    /*
    static void modifyArray(int[] arr) {
        arr[0] = 100;
    }

    static void objectMutationExample() {
        int[] a = {1, 2, 3};
        modifyArray(a);
        System.out.println(a[0]); // 100
    }

    Explanation:
    - Reference value is copied
    - Both references point to same heap object
    - Mutation affects original
    */

    /*
    ----------------------------------------------------
    4.4 Reassignment DOES NOT WORK
    ----------------------------------------------------
    */

    /*
    static void reassignArray(int[] arr) {
        arr = new int[]{9, 9, 9};
    }

    static void reassignmentExample() {
        int[] a = {1, 2, 3};
        reassignArray(a);
        System.out.println(a[0]); // 1
    }

    Explanation:
    - arr receives COPY of reference
    - Reassigning arr does not change original reference
    */

    /*
    ----------------------------------------------------
    4.5 Why Swapping Fails (INTERVIEW FAVORITE)
    ----------------------------------------------------
    */

    /*
    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    static void swapFailureExample() {
        int x = 5;
        int y = 10;
        swap(x, y);

        System.out.println(x); // 5
        System.out.println(y); // 10
    }

    Explanation:
    - a and b are COPIES
    - Swapping copies does nothing
    */

    /*
    Correct DSA-style swap:
    */

    /*
    static void swapInArray(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void correctSwapExample() {
        int[] arr = {5, 10};
        swapInArray(arr, 0, 1);

        System.out.println(arr[0]); // 10
        System.out.println(arr[1]); // 5
    }
    */

    /*
    ----------------------------------------------------
    4.6 Wrapper Classes Trap (Integer, Long, etc.)
    ----------------------------------------------------
    */

    /*
    static void modifyInteger(Integer x) {
        x = 100;
    }

    static void wrapperExample() {
        Integer a = 10;
        modifyInteger(a);
        System.out.println(a); // 10
    }

    Explanation:
    - Integer is immutable
    - Reference is passed by value
    - Reassignment does not affect caller
    */

    /*
    ----------------------------------------------------
    4.7 Why This Matters in DSA
    ----------------------------------------------------

    Real DSA bugs caused by misunderstanding:
    - Backtracking state corruption
    - Helper methods not updating expected data
    - Wrong assumptions about swaps
    - Broken recursion logic

    DSA RULE:
    - Mutation works
    - Reassignment does NOT
    - Deep copy when isolation is required
    */

    public static void main(String[] args) {
        // Intentionally empty
        // Uncomment examples above to test behavior
    }
}
