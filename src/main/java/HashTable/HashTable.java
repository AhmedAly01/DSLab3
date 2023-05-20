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
        this.b = 2* (int)Math.ceil(Math.log(n) / Math.log(2));
        this.n = n;
        h = generateHashMatrix(b, u);
        this.collisionsCounter = 0;
        table = new String[this.n*this.n];
    }

    private int[][] generateHashMatrix(int b, int u){
        Random rand = new Random();
        collisionsCounter++;
        int[][] h = new int[b][u];
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < u; j++) {
                h[i][j] = rand.nextInt(2);
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
            index += hx[i] << i;
        }
        return index%(this.n*this.n);
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

    public int insert(String x, boolean resolveCollision){ // true resolves    false doesn't
        if(x.length() > u/8){
            System.out.println("string is too big");
            return 4; //// string is too big
        }
        int index = hash(x);
        System.out.println(x.length());
        if(table[index] == null){
            table[index] = x;
            return 1; //// successfully inserted
        }else if(Objects.equals(table[index], x)){
            return 2; ////already exists
        }else{
            if(resolveCollision){
                rebuildTable(x);
            }
            return 3; ////collision
        }
    }
    public Boolean find(String x){
        int index = hash(x);
        return table[index] != null;
    }
    public boolean delete(String x){
        int index = hash(x);
        if(table[index] == null ){
            return false;
        }
        table[index] = null;
        return true;
    }


    public static void main(String[] args) {
        HashTable uh = new HashTable(10);
        System.out.println(uh.insert("hello------------------------------------------------------------", true));
        System.out.println(Arrays.toString(uh.table));
        System.out.println(uh.insert("hello-----------", true));
        System.out.println(Arrays.toString(uh.table));
        System.out.println(uh.insert("hello-----------------------------------------------------------", true));
        System.out.println(uh.insert("hello-----------", true));
        System.out.println(uh.collisionsCounter);
        System.out.println(Arrays.toString(uh.table));

    }

    public int[][] getHashFunction() {
        return h;
    }

    public String[] getTable() {
        return table;
    }
    public int getN(){
        return n;
    }

}
