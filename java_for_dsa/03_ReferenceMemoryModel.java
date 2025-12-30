/*
========================================================
FILE: 03_ReferenceMemoryModel.java
SECTION 3: REFERENCE TYPES & MEMORY MODEL
========================================================

Scope:
- Primitive copy vs reference copy
- Heap sharing
- Method parameter behavior
- Mutation vs reassignment
- Why Java feels like pass-by-reference (but is not)

This section eliminates silent logic bugs.
*/

public class ReferenceMemoryModel {

    /*
    ----------------------------------------------------
    3.1 Primitive Copy vs Reference Copy
    ----------------------------------------------------

    Primitive variables store VALUES.
    Reference variables store ADDRESSES (references).

    Copying a primitive copies the value.
    Copying a reference copies the address, NOT the object.
    */

    /*
    Runnable example: Primitive copy
    */

    /*
    static void primitiveCopy() {
        int a = 10;
        int b = a;
        b = 20;

        System.out.println(a); // 10
        System.out.println(b); // 20
    }

    Explanation:
    - a and b are independent
    - Changing b does not affect a
    */

    /*
    Runnable example: Reference copy
    */

    /*
    static void referenceCopy() {
        int[] a = {1, 2, 3};
        int[] b = a;

        b[0] = 99;

        System.out.println(a[0]); // 99
        System.out.println(b[0]); // 99
    }

    Explanation:
    - a and b point to the SAME heap array
    - Only one object exists
    */

    /*
    ----------------------------------------------------
    3.2 Method Parameters & Heap Sharing
    ----------------------------------------------------

    Java ALWAYS passes parameters by VALUE.
    For objects, the VALUE passed is the reference.

    That is why:
    - Mutating object works
    - Reassigning object does NOT
    */

    /*
    Runnable example: Mutation works
    */

    /*
    static void mutateArray(int[] arr) {
        arr[0] = 100;
    }

    static void mutationExample() {
        int[] a = {1, 2, 3};
        mutateArray(a);
        System.out.println(a[0]); // 100
    }
    */

    /*
    Runnable example: Reassignment fails
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
    - arr receives a COPY of reference
    - Reassigning arr does not affect original reference
    */

    /*
    ----------------------------------------------------
    3.3 Arrays vs Objects (SAME BEHAVIOR)
    ----------------------------------------------------

    Arrays are objects in Java.
    Behavior is identical to custom objects.
    */

    /*
    static class Box {
        int value;
    }

    static void modify(Box b) {
        b.value = 50;
    }

    static void objectExample() {
        Box box = new Box();
        box.value = 10;

        modify(box);
        System.out.println(box.value); // 50
    }
    */

    /*
    DSA relevance:
    - Graph nodes
    - Tree nodes
    - Custom state objects
    */

    /*
    ----------------------------------------------------
    3.4 Why Swapping Fails in Java (INTERVIEW CLASSIC)
    ----------------------------------------------------

    Runnable example:
    */

    /*
    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    static void swapFailure() {
        int x = 5;
        int y = 10;
        swap(x, y);

        System.out.println(x); // 5
        System.out.println(y); // 10
    }

    Explanation:
    - a and b receive COPIES of x and y
    - Swapping copies does nothing to originals
    */

    /*
    Correct approach in DSA:
    - Swap array elements
    - Use wrapper object
    */

    /*
    static void swapInArray(int[] arr) {
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }

    static void correctSwap() {
        int[] arr = {5, 10};
        swapInArray(arr);

        System.out.println(arr[0]); // 10
        System.out.println(arr[1]); // 5
    }
    */

    /*
    ----------------------------------------------------
    3.5 Deep Copy vs Shallow Copy
    ----------------------------------------------------

    Shallow copy:
    - Copies reference
    - Shares heap object

    Deep copy:
    - Creates new object
    - Copies values manually
    */

    /*
    Runnable example: Deep copy
    */

    /*
    static void deepCopyExample() {
        int[] a = {1, 2, 3};
        int[] b = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }

        b[0] = 99;

        System.out.println(a[0]); // 1
        System.out.println(b[0]); // 99
    }
    */

    /*
    DSA relevance:
    - Backtracking
    - Snapshotting state
    - Avoiding unintended mutation
    */

    /*
    ----------------------------------------------------
    3.6 Reference Bugs in DSA (REALITY CHECK)
    ----------------------------------------------------

    Common mistakes:
    - Reusing same array in recursion
    - Storing references instead of copies
    - Forgetting deep copy in backtracking

    DSA rule:
    - If state must be isolated → deep copy
    - If mutation is intended → reuse reference
    */

    public static void main(String[] args) {
        // Intentionally empty
        // Uncomment examples to observe behavior
    }
}
