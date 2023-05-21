package Tests;

import HashTable.HashTable;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class N2HashTableTests {
    @Test //test insert in small table
    public void TestInsertN2() {
        HashTable ht = new HashTable(10);
        ht.insert("Ahmed", true);
        ht.insert("Mohamed", true);
        ht.insert("Ali", true);
        ht.insert("Hassan", true);
        assertTrue(ht.find("Ahmed"));
        assertTrue(ht.find("Mohamed"));
        assertTrue(ht.find("Ali"));
        assertTrue(ht.find("Hassan"));
        System.out.println("Collisions occurred = " + ht.getCollisionsCounter());
    }

    @Test //test find in small table
    public void TestFindN2() {
        HashTable ht = new HashTable(10);
        ht.insert("Ahmed", true);
        ht.insert("Mohamed", true);
        ht.insert("Ali", true);
        ht.insert("Hassan", true);
        assertTrue(ht.find("Ahmed"));
        assertFalse(ht.find("xyz"));
        assertTrue(ht.find("Ali"));
        assertFalse(ht.find("abc"));
        System.out.println("Collisions occurred = " + ht.getCollisionsCounter());
    }

    @Test //test delete in small table
    public void TestDeleteN2() {
        HashTable ht = new HashTable(10);
        ht.insert("Ahmed", true);
        ht.insert("Mohamed", true);
        ht.insert("Ali", true);
        ht.insert("Hassan", true);
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

    @Test //test deletion of elements that don't exist in small table
    public void TestDeleteNotExistN2() {
        HashTable ht = new HashTable(10);
        ht.insert("Ahmed", true);
        ht.insert("Mohamed", true);
        ht.insert("Ali", true);
        ht.insert("Hassan", true);
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

    @Test //test insert in big table
    public void TestInsertBigN2() {
        HashTable ht = new HashTable(10000);
        ArrayList<String> stringsInserted = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            String str = randStr(8);
            ht.insert(str, true);
            stringsInserted.add(str);
        }
        for (int i = 0; i < 10000; i++) {
            assertTrue(ht.find(stringsInserted.get(i)));
        }
        System.out.println("Collisions occurred = " + ht.getCollisionsCounter());
    }

    @Test //test find in big table
    public void TestFindBigN2() {
        HashTable ht = new HashTable(10000);
        ArrayList<String> stringsInserted = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            String str = randStr(8);
            ht.insert(str, true);
            stringsInserted.add(str);
        }
        for (int i = 0; i < 10000; i++) {
            if (i % 2 == 0)
                assertTrue(ht.find(stringsInserted.get(i)));
            else
                assertFalse(ht.find(randStr(8)));
        }
        System.out.println("Collisions occurred = " + ht.getCollisionsCounter());
    }

    @Test //test delete in big table
    public void TestFDeleteBigN2() {
        HashTable ht = new HashTable(10000);
        ArrayList<String> stringsInserted = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            String str = randStr(8);
            ht.insert(str, true);
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

    @Test //test deletion of elements that don't exist in big table
    public void TestFDeleteNotExistBigN2() {
        HashTable ht = new HashTable(10000);
        ArrayList<String> stringsInserted = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            String str = randStr(8);
            ht.insert(str, true);
            stringsInserted.add(str);
        }
        for (int i = 0; i < 10000; i++) {
            if (i % 2 == 0)
                assertTrue(ht.delete(stringsInserted.get(i)));
            else
                assertFalse(ht.delete(randStr(8)));
        }
        for (int i = 0; i < 10000; i++) {
            if (i % 2 == 0)
                assertFalse(ht.find(stringsInserted.get(i)));
            else
                assertTrue(ht.find(stringsInserted.get(i)));
        }
        System.out.println("Collisions occurred = " + ht.getCollisionsCounter());
    }

    @Test //test insert bigger number of elements in big table
    public void TestInsertBiggerN2() {
        HashTable ht = new HashTable(10000);
        ArrayList<String> stringsInserted = new ArrayList<>();
        for (int i = 0; i < 30000; i++) {
            String str = randStr(8);
            ht.insert(str, true);
            stringsInserted.add(str);
        }
        for (int i = 0; i < 30000; i++) {
            assertTrue(ht.find(stringsInserted.get(i)));
        }
        System.out.println("Collisions occurred = " + ht.getCollisionsCounter());
    }

    @Test //test find bigger number of elements in big table
    public void TestFindBiggerN2() {
        HashTable ht = new HashTable(10000);
        ArrayList<String> stringsInserted = new ArrayList<>();
        for (int i = 0; i < 30000; i++) {
            String str = randStr(8);
            ht.insert(str, true);
            stringsInserted.add(str);
        }
        for (int i = 0; i < 30000; i++) {
            if (i % 2 == 0)
                assertTrue(ht.find(stringsInserted.get(i)));
            else
                assertFalse(ht.find(randStr(8)));
        }
        System.out.println("Collisions occurred = " + ht.getCollisionsCounter());
    }

    @Test //test delete bigger number of elements in big table
    public void TestFDeleteBiggerN2() {
        HashTable ht = new HashTable(10000);
        ArrayList<String> stringsInserted = new ArrayList<>();
        for (int i = 0; i < 30000; i++) {
            String str = randStr(8);
            ht.insert(str, true);
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

    @Test //test deletion of bigger number of elements that don't exist in big table
    public void TestFDeleteNotExistBiggerN2() {
        HashTable ht = new HashTable(10000);
        ArrayList<String> stringsInserted = new ArrayList<>();
        for (int i = 0; i < 30000; i++) {
            String str = randStr(8);
            ht.insert(str, true);
            stringsInserted.add(str);
        }
        for (int i = 0; i < 30000; i++) {
            if (i % 2 == 0)
                assertTrue(ht.delete(stringsInserted.get(i)));
            else
                assertFalse(ht.delete(randStr(8)));
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
