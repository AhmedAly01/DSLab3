package HashTable;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class HashTable {
    private int[][] h;
    private int n;
    private String[] table;
    private int u = 512;
    private int b;
    private int collisionsCounter = 0;

    public HashTable(int n) {
        this.b = 2* (int)Math.ceil(Math.log(n) / Math.log(2));;
        this.n = n;
        this.collisionsCounter = 0;
        h = new int[b][u];
        Arrays.stream(h).forEach(row -> Arrays.fill(row, 1));
        table = new String[this.n*this.n];
    }

    private int[][] generateHashMatrix(int b, int u){
        Random rand = new Random();
        collisionsCounter++;
        int[][] h = new int[b][u];
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < u; j++) {
                h[i][j] = rand.nextInt(2);
//                h[i][j] = 1;
            }
        }
        return h;
    }

    public int hash(String str) {
        int[] hx = new int[b];
        byte[] bytes = new byte[u/8];
        byte[] strBytes = str.getBytes();
        System.arraycopy(strBytes, 0, bytes, 0, strBytes.length);
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < u; j++) {
                hx[i] += h[i][j]*(bytes[j/8]>>(j%8));
            }
            hx[i] %= 2;
        }
        int index = 0;

        for (int i = 0; i < b; i++) {
            index += hx[i];
        }
        return index;
    }

    private boolean rehashing(String x){
        String[] newTable;
        int index;
        h = generateHashMatrix(b, u);
        newTable = new String[this.n*this.n];
        for (String j : table) {
            if(j == null)
                continue;
            index = hash(j);
            if (newTable[index] != null) { //////////////////change when going stringy
                return false;
            }
            newTable[index] = j;
        }
        index = hash(x);
        if(newTable[index] != null) { //////////////////change when going stringy
            return false;
        }
        newTable[index] = x;
        this.table = newTable;
        return true;
    }


    private void rebuildTable(String x){
        while(true){
            if(rehashing(x)){
                return;
            }
        }
    }

    public boolean insert(String x){
        int index = hash(x);
        System.out.println(index);
        if(table[index] == null){
            table[index] = x;
            return true;
        }else if(Objects.equals(table[index], x)){
            return false;
        }else{
            rebuildTable(x);
            return true;
        }
    }


    public static void main(String[] args) {
        HashTable uh = new HashTable(10);
        System.out.println(uh.insert("hello-----------------------------------------------------------"));
        System.out.println(Arrays.toString(uh.table));
        System.out.println(uh.insert("hello-----------"));
        System.out.println(Arrays.toString(uh.table));
        System.out.println(uh.insert("hello-----------------------------------------------------------"));
        System.out.println(uh.insert("hello-----------"));
        System.out.println(uh.collisionsCounter);
        System.out.println(Arrays.toString(uh.table));

    }

    public int[][] getHashFunction() {
        return h;
    }

    public String[] getTable() {
        return table;
    }

}
