/*
========================================================
FILE: 08_Strings.java
SECTION 8: STRINGS & IMMUTABILITY (DSA FILTER)
========================================================

Scope:
- What String really is
- String pool
- Immutability
- == vs equals()
- Concatenation cost
- StringBuilder usage
- Common DSA string pitfalls

Strings are objects. Misusing them causes TLEs and bugs.
*/

public class StringsDSA {

    /*
    ----------------------------------------------------
    8.1 What a String Is
    ----------------------------------------------------

    String is:
    - An OBJECT
    - Immutable
    - Backed internally by a character array
    - Heavily optimized by JVM (String Pool)

    Once created, its content CANNOT change.
    */

    /*
    ----------------------------------------------------
    8.2 String Pool (WHY == SOMETIMES WORKS)
    ----------------------------------------------------

    String literals are stored in the String Pool.
    Identical literals share the same object.

    Runnable example:
    */

    /*
    static void stringPoolExample() {
        String a = "abc";
        String b = "abc";

        System.out.println(a == b);      // true (same pooled object)
        System.out.println(a.equals(b)); // true
    }
    */

    /*
    But using new creates a new object.
    */

    /*
    static void newStringExample() {
        String a = new String("abc");
        String b = new String("abc");

        System.out.println(a == b);      // false
        System.out.println(a.equals(b)); // true
    }
    */

    /*
    DSA rule:
    - NEVER use == to compare strings
    - Always use equals()
    */

    /*
    ----------------------------------------------------
    8.3 Immutability (WHY STRING DOES NOT CHANGE)
    ----------------------------------------------------

    Immutability means:
    - Operations create NEW String objects
    - Original String remains unchanged

    Runnable example:
    */

    /*
    static void immutabilityExample() {
        String s = "hello";
        s.concat("world");

        System.out.println(s); // hello
    }
    */

    /*
    Correct usage:
    */

    /*
    static void correctConcatExample() {
        String s = "hello";
        s = s.concat("world");

        System.out.println(s); // helloworld
    }
    */

    /*
    DSA implication:
    - Repeated concatenation in loops is EXPENSIVE
    */

    /*
    ----------------------------------------------------
    8.4 String Concatenation Cost (PERFORMANCE TRAP)
    ----------------------------------------------------

    Using + inside loops creates many temporary objects.

    BAD:
    */

    /*
    static void badConcat() {
        String s = "";
        for (int i = 0; i < 1000; i++) {
            s = s + i;
        }
    }
    */

    /*
    GOOD:
    */

    /*
    static void goodConcat() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append(i);
        }
        String s = sb.toString();
    }
    */

    /*
    DSA rule:
    - Use StringBuilder for loops
    */

    /*
    ----------------------------------------------------
    8.5 StringBuilder (MUTABLE STRING)
    ----------------------------------------------------

    StringBuilder:
    - Mutable
    - No synchronization (faster than StringBuffer)
    - Designed for frequent modifications
    */

    /*
    Runnable example:
    */

    /*
    static void stringBuilderExample() {
        StringBuilder sb = new StringBuilder();
        sb.append("ab");
        sb.append("cd");
        sb.insert(2, "X");

        System.out.println(sb.toString()); // abXcd
    }
    */

    /*
    ----------------------------------------------------
    8.6 Common String Operations (DSA USE)
    ----------------------------------------------------
    */

    /*
    static void commonOps() {
        String s = "abcd";

        s.length();           // 4
        s.charAt(1);          // b
        s.substring(1, 3);    // bc
        s.indexOf('c');       // 2
        s.contains("bc");     // true
        s.startsWith("a");    // true
        s.endsWith("d");      // true
    }
    */

    /*
    ----------------------------------------------------
    8.7 char[] vs String (IMPORTANT CHOICE)
    ----------------------------------------------------

    char[]:
    - Mutable
    - Faster for character manipulation

    String:
    - Immutable
    - Safer, but slower for modifications

    DSA rule:
    - Convert String → char[] when heavy modification needed
    */

    /*
    Runnable example:
    */

    /*
    static void charArrayExample() {
        char[] arr = "abc".toCharArray();
        arr[0] = 'z';
        System.out.println(arr); // zbc
    }
    */

    /*
    ----------------------------------------------------
    8.8 Palindrome Example (DSA CLASSIC)
    ----------------------------------------------------
    */

    /*
    static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    */

    /*
    ----------------------------------------------------
    8.9 DSA RULES FOR STRINGS
    ----------------------------------------------------

    - Strings are immutable
    - Use equals(), never ==
    - Avoid + in loops
    - Use StringBuilder for construction
    - Convert to char[] for heavy modification
    */

    public static void main(String[] args) {
        // Intentionally empty
        // Uncomment examples above to test behavior
    }
}
