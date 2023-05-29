package Tests;

import HashTable.HashTableN2;
import HashTable.HashTableN;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class TimeTests {
    @Test
    public void TestInsert1kN2() {
        HashTableN2 ht = new HashTableN2(1000);
        ArrayList<String> insertedStrings = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            String str = randStr(8);
            ht.insert(str, true);
            insertedStrings.add(str);
        }
        double start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            ht.find(insertedStrings.get((int)(Math.random()*1000)));
        }
        double end = System.nanoTime() - start;
        System.out.println("Time taken = " + end + " ns");
    }

    @Test
    public void TestInsert5kN2() {
        HashTableN2 ht = new HashTableN2(5000);
        ArrayList<String> insertedStrings = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            String str = randStr(8);
            ht.insert(str, true);
            insertedStrings.add(str);
        }
        double start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            ht.find(insertedStrings.get((int)(Math.random()*5000)));
        }
        double end = System.nanoTime() - start;
        System.out.println("Time taken = " + end + " ns");
    }

    @Test
    public void TestInsert10kN2() {
        HashTableN2 ht = new HashTableN2(10000);
        ArrayList<String> insertedStrings = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            String str = randStr(8);
            ht.insert(str, true);
            insertedStrings.add(str);
        }
        double start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            ht.find(insertedStrings.get((int)(Math.random()*10000)));
        }
        double end = System.nanoTime() - start;
        System.out.println("Time taken = " + end + " ns");
    }

    @Test
    public void TestInsert20kN2() {
        HashTableN2 ht = new HashTableN2(20000);
        ArrayList<String> insertedStrings = new ArrayList<>();
        for (int i = 0; i < 20000; i++) {
            String str = randStr(8);
            ht.insert(str, true);
            insertedStrings.add(str);
        }
        double start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            ht.find(insertedStrings.get((int)(Math.random()*20000)));
        }
        double end = System.nanoTime() - start;
        System.out.println("Time taken = " + end + " ns");
    }

    @Test
    public void TestInsert30kN2() {
        HashTableN2 ht = new HashTableN2(30000);
        ArrayList<String> insertedStrings = new ArrayList<>();
        for (int i = 0; i < 30000; i++) {
            String str = randStr(8);
            ht.insert(str, true);
            insertedStrings.add(str);
        }
        double start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            ht.find(insertedStrings.get((int)(Math.random()*30000)));
        }
        double end = System.nanoTime() - start;
        System.out.println("Time taken = " + end + " ns");
    }

    @Test
    public void TestInsert1kN() {
        HashTableN ht = new HashTableN(1000);
        ArrayList<String> insertedStrings = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            String str = randStr(8);
            ht.insert(str);
            insertedStrings.add(str);
        }
        double start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            ht.find(insertedStrings.get((int)(Math.random()*1000)));
        }
        double end = System.nanoTime() - start;
        System.out.println("Time taken = " + end + " ns");
    }

    @Test
    public void TestInsert5kN() {
        HashTableN ht = new HashTableN(5000);
        ArrayList<String> insertedStrings = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            String str = randStr(8);
            ht.insert(str);
            insertedStrings.add(str);
        }
        double start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            ht.find(insertedStrings.get((int)(Math.random()*5000)));
        }
        double end = System.nanoTime() - start;
        System.out.println("Time taken = " + end + " ns");
    }

    @Test
    public void TestInsert10kN() {
        HashTableN ht = new HashTableN(10000);
        ArrayList<String> insertedStrings = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            String str = randStr(8);
            ht.insert(str);
            insertedStrings.add(str);
        }
        double start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            ht.find(insertedStrings.get((int)(Math.random()*10000)));
        }
        double end = System.nanoTime() - start;
        System.out.println("Time taken = " + end + " ns");
    }

    @Test
    public void TestInsert20kN() {
        HashTableN ht = new HashTableN(20000);
        ArrayList<String> insertedStrings = new ArrayList<>();
        for (int i = 0; i < 20000; i++) {
            String str = randStr(8);
            ht.insert(str);
            insertedStrings.add(str);
        }
        double start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            ht.find(insertedStrings.get((int)(Math.random()*20000)));
        }
        double end = System.nanoTime() - start;
        System.out.println("Time taken = " + end + " ns");
    }

    @Test
    public void TestInsert30kN() {
        HashTableN ht = new HashTableN(30000);
        ArrayList<String> insertedStrings = new ArrayList<>();
        for (int i = 0; i < 30000; i++) {
            String str = randStr(8);
            ht.insert(str);
            insertedStrings.add(str);
        }
        double start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            ht.find(insertedStrings.get((int)(Math.random()*30000)));
        }
        double end = System.nanoTime() - start;
        System.out.println("Time taken = " + end + " ns");
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
