/*
========================================================
FILE: 11_EqualityAndHashing.java
SECTION 11: OBJECT EQUALITY & HASHING (HASHMAP CORE)
========================================================

Scope:
- == vs equals()
- hashCode() contract
- Why HashMap / HashSet depend on BOTH
- Mutable key disasters
- Why String works as a key
- Real DSA failure cases

This section explains bugs that do NOT throw errors,
but produce WRONG answers.
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualityAndHashing {

    /*
    ----------------------------------------------------
    11.1 == vs equals() (ABSOLUTELY DIFFERENT)
    ----------------------------------------------------

    == :
    - Compares references (memory addresses)

    equals():
    - Compares logical equality (content)
    - Can be overridden

    Runnable example:
    */

    /*
    static void equalityExample() {
        String a = new String("abc");
        String b = new String("abc");

        System.out.println(a == b);      // false
        System.out.println(a.equals(b)); // true
    }
    */

    /*
    DSA rule:
    - NEVER use == for logical comparison
    - Always use equals() for objects
    */

    /*
    ----------------------------------------------------
    11.2 hashCode() (WHAT IT IS)
    ----------------------------------------------------

    hashCode():
    - Returns an int hash value
    - Used to decide bucket in HashMap / HashSet

    Key idea:
    - Objects with SAME equals() MUST have SAME hashCode()
    */

    /*
    ----------------------------------------------------
    11.3 equals() & hashCode() CONTRACT (MEMORIZE)
    ----------------------------------------------------

    Contract:
    1. If a.equals(b) == true
       → a.hashCode() == b.hashCode()

    2. If a.hashCode() != b.hashCode()
       → a.equals(b) == false

    Breaking this contract BREAKS HashMap behavior.
    */

    /*
    ----------------------------------------------------
    11.4 Custom Object WITHOUT hashCode() (BUG)
    ----------------------------------------------------
    */

    /*
    static class BadKey {
        int x;

        BadKey(int x) {
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof BadKey)) return false;
            BadKey other = (BadKey) o;
            return this.x == other.x;
        }
        // hashCode() NOT overridden
    }

    static void badKeyExample() {
        Set<BadKey> set = new HashSet<>();
        set.add(new BadKey(1));

        System.out.println(set.contains(new BadKey(1))); // false (BUG)
    }
    */

    /*
    Explanation:
    - equals() says objects are equal
    - hashCode() differs → different bucket
    - HashSet fails to find object
    */

    /*
    ----------------------------------------------------
    11.5 Correct equals() + hashCode() (REQUIRED)
    ----------------------------------------------------
    */

    /*
    static class GoodKey {
        int x;

        GoodKey(int x) {
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof GoodKey)) return false;
            GoodKey other = (GoodKey) o;
            return this.x == other.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x);
        }
    }

    static void goodKeyExample() {
        Set<GoodKey> set = new HashSet<>();
        set.add(new GoodKey(1));

        System.out.println(set.contains(new GoodKey(1))); // true
    }
    */

    /*
    ----------------------------------------------------
    11.6 Mutable Key Disaster (DSA KILLER BUG)
    ----------------------------------------------------

    If a key changes AFTER insertion:
    - hashCode changes
    - Object becomes unreachable

    Runnable example:
    */

    /*
    static class MutableKey {
        int x;

        MutableKey(int x) {
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MutableKey)) return false;
            MutableKey other = (MutableKey) o;
            return this.x == other.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x);
        }
    }

    static void mutableKeyBug() {
        HashMap<MutableKey, String> map = new HashMap<>();
        MutableKey key = new MutableKey(1);

        map.put(key, "value");
        key.x = 2; // mutation AFTER insertion

        System.out.println(map.get(key)); // null (BUG)
    }
    */

    /*
    DSA rule:
    - Keys in HashMap / HashSet MUST be immutable
    */

    /*
    ----------------------------------------------------
    11.7 Why String Is a Perfect Key
    ----------------------------------------------------

    String:
    - Immutable
    - Correct equals() & hashCode()
    - Cached hashCode()

    This is why String is heavily used in DSA maps.
    */

    /*
    ----------------------------------------------------
    11.8 HashMap Lookup Flow (INTERNAL MODEL)
    ----------------------------------------------------

    map.get(key):
    1. Compute key.hashCode()
    2. Find bucket
    3. Use equals() to find exact key

    If either step fails → lookup fails
    */

    /*
    ----------------------------------------------------
    11.9 DSA RULES FOR EQUALITY & HASHING
    ----------------------------------------------------

    - equals() and hashCode() go together
    - Never mutate map keys
    - Prefer immutable keys
    - Use String / Integer safely
    - Custom keys require BOTH overrides
    */

    public static void main(String[] args) {
        // Intentionally empty
        // Uncomment examples above to test behavior
    }
}
