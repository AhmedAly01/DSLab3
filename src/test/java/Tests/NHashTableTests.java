package Tests;

import HashTable.HashTable3;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class NHashTableTests {
    @Test
    public void TestInsertN() {
        HashTable3 ht = new HashTable3(100);
        ht.insert("Ahmed");
        ht.insert("Mohamed");
        ht.insert("Ali");
        ht.insert("Hassan");
        assertTrue(ht.find("Ahmed"));
        assertTrue(ht.find("Mohamed"));
        assertTrue(ht.find("Ali"));
        assertTrue(ht.find("Hassan"));
        System.out.println("Collisions occurred = " + ht.getCollisionsCounter());
    }

    @Test
    public void TestFindN() {
        HashTable3 ht = new HashTable3(100);
        ht.insert("Ahmed");
        ht.insert("Mohamed");
        ht.insert("Ali");
        ht.insert("Hassan");
        assertTrue(ht.find("Ahmed"));
        assertFalse(ht.find("xyz"));
        assertTrue(ht.find("Ali"));
        assertFalse(ht.find("abc"));
        System.out.println("Collisions occurred = " + ht.getCollisionsCounter());
    }

    @Test
    public void TestDeleteN() {
        HashTable3 ht = new HashTable3(100);
        ht.insert("Ahmed");
        ht.insert("Mohamed");
        ht.insert("Ali");
        ht.insert("Hassan");
        assertTrue(ht.delete("Ahmed"));
        assertTrue(ht.delete("Mohamed"));
        assertTrue(ht.delete("Ali"));
        assertTrue(ht.delete("Hassan"));
        assertFalse(ht.find("Ahmed"));
        assertFalse(ht.find("Mohamed"));
        assertFalse(ht.find("Ali"));
        assertFalse(ht.find("Hassan"));
        System.out.println("Collisions occurred = " + ht.getCollisionsCounter());
    }

    @Test
    public void TestDeleteNotExistN() {
        HashTable3 ht = new HashTable3(100);
        ht.insert("Ahmed");
        ht.insert("Mohamed");
        ht.insert("Ali");
        ht.insert("Hassan");
        assertTrue(ht.delete("Ahmed"));
        assertFalse(ht.delete("xyz"));
        assertTrue(ht.delete("Ali"));
        assertFalse(ht.delete("abc"));
        assertFalse(ht.find("Ahmed"));
        assertTrue(ht.find("Mohamed"));
        assertFalse(ht.find("Ali"));
        assertTrue(ht.find("Hassan"));
        System.out.println("Collisions occurred = " + ht.getCollisionsCounter());
    }

    @Test
    public void TestInsertBigN() {
        HashTable3 ht = new HashTable3(10000);
        ArrayList<String> stringsInserted = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            String str = randStr(8);
            ht.insert(str);
            stringsInserted.add(str);
        }
        for (int i = 0; i < 10000; i++) {
            assertTrue(ht.find(stringsInserted.get(i)));
        }
        System.out.println("Collisions occurred = " + ht.getCollisionsCounter());
    }

    @Test
    public void TestFindBigN() {
        HashTable3 ht = new HashTable3(10000);
        ArrayList<String> stringsInserted = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            String str = randStr(8);
            ht.insert(str);
            stringsInserted.add(str);
        }
        for (int i = 0; i < 10000; i++) {
            if (i % 2 == 0)
                assertTrue(ht.find(stringsInserted.get(i)));
            else
                assertFalse(ht.find(randStr(16)));
        }
        System.out.println("Collisions occurred = " + ht.getCollisionsCounter());
    }

    @Test
    public void TestFDeleteBigN() {
        HashTable3 ht = new HashTable3(10000);
        ArrayList<String> stringsInserted = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            String str = randStr(8);
            ht.insert(str);
            stringsInserted.add(str);
        }
        for (int i = 0; i < 10000; i++) {
            assertTrue(ht.delete(stringsInserted.get(i)));
        }
        for (int i = 0; i < 10000; i++) {
            assertFalse(ht.find(stringsInserted.get(i)));
        }
        System.out.println("Collisions occurred = " + ht.getCollisionsCounter());
    }

    @Test
    public void TestFDeleteNotExistBigN() {
        HashTable3 ht = new HashTable3(10000);
        ArrayList<String> stringsInserted = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            String str = randStr(8);
            ht.insert(str);
            stringsInserted.add(str);
        }
        for (int i = 0; i < 10000; i++) {
            if (i % 2 == 0)
                assertTrue(ht.delete(stringsInserted.get(i)));
            else
                assertFalse(ht.delete(randStr(16)));
        }
        for (int i = 0; i < 10000; i++) {
            if (i % 2 == 0)
                assertFalse(ht.find(stringsInserted.get(i)));
            else
                assertTrue(ht.find(stringsInserted.get(i)));
        }
        System.out.println("Collisions occurred = " + ht.getCollisionsCounter());
    }

    @Test
    public void TestInsertBiggerN() {
        HashTable3 ht = new HashTable3(10000);
        ArrayList<String> stringsInserted = new ArrayList<>();
        for (int i = 0; i < 30000; i++) {
            String str = randStr(8);
            ht.insert(str);
            stringsInserted.add(str);
        }
        for (int i = 0; i < 30000; i++) {
            assertTrue(ht.find(stringsInserted.get(i)));
        }
        System.out.println("Collisions occurred = " + ht.getCollisionsCounter());
    }

    @Test
    public void TestFindBiggerN() {
        HashTable3 ht = new HashTable3(10000);
        ArrayList<String> stringsInserted = new ArrayList<>();
        for (int i = 0; i < 30000; i++) {
            String str = randStr(8);
            ht.insert(str);
            stringsInserted.add(str);
        }
        for (int i = 0; i < 30000; i++) {
            if (i % 2 == 0)
                assertTrue(ht.find(stringsInserted.get(i)));
            else
                assertFalse(ht.find(randStr(16)));
        }
        System.out.println("Collisions occurred = " + ht.getCollisionsCounter());
    }

    @Test
    public void TestFDeleteBiggerN() {
        HashTable3 ht = new HashTable3(10000);
        ArrayList<String> stringsInserted = new ArrayList<>();
        for (int i = 0; i < 30000; i++) {
            String str = randStr(8);
            ht.insert(str);
            stringsInserted.add(str);
        }
        for (int i = 0; i < 30000; i++) {
            assertTrue(ht.delete(stringsInserted.get(i)));
        }
        for (int i = 0; i < 30000; i++) {
            assertFalse(ht.find(stringsInserted.get(i)));
        }
        System.out.println("Collisions occurred = " + ht.getCollisionsCounter());
    }

    @Test
    public void TestFDeleteNotExistBiggerN() {
        HashTable3 ht = new HashTable3(10000);
        ArrayList<String> stringsInserted = new ArrayList<>();
        for (int i = 0; i < 30000; i++) {
            String str = randStr(8);
            ht.insert(str);
            stringsInserted.add(str);
        }
        for (int i = 0; i < 30000; i++) {
            if (i % 2 == 0)
                assertTrue(ht.delete(stringsInserted.get(i)));
            else
                assertFalse(ht.delete(randStr(16)));
        }
        for (int i = 0; i < 30000; i++) {
            if (i % 2 == 0)
                assertFalse(ht.find(stringsInserted.get(i)));
            else
                assertTrue(ht.find(stringsInserted.get(i)));
        }
        System.out.println("Collisions occurred = " + ht.getCollisionsCounter());
    }

    /**
     * helper function to generate a random String
     * @param l
     * size of string generated
     * @return
     * random string of size l
     */
    public static String randStr(int l) {
        String AlphaNumericStr = "abcdefghijklmnopqrstuvxyz";
        StringBuilder s = new StringBuilder(l);
        int i;
        for ( i=0; i<l; i++) {
            int ch = (int)(AlphaNumericStr.length() * Math.random());
            s.append(AlphaNumericStr.charAt(ch));
        }
        return s.toString();
    }
}
