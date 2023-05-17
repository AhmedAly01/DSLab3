package HashTable;

import java.util.Arrays;
import java.util.Random;

public class HashTable {
    private int[][] h;
    private int n;
    private String[] table;
    private int u;
    private int b;
    private int collisionsCounter = 0;
    public HashTable(int u, int b, int n) {
        this.u = u;
        this.b = b;
        this.n = n;
        this.collisionsCounter = 0;
        h = generateHashMatrix(b, u);
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
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 0; j < 8; j++) {
                hx[i % b] += h[i % b][j] * ((bytes[i] >> j) & 1);
            }
        }
        int index = 0;
        for (int i = 0; i < b; i++) {
            index += hx[i] << i;
        }
        return index;
    }

    private boolean rehashing(){
        int[] newTable;
        int index;
        h = generateHashMatrix(b, u);
        newTable = new int[this.n*this.n];
        for (int j : table) {
            index = hash(j);
            if (newTable[index] != 0) { //////////////////change when going stringy
                return false;
            }
            newTable[index] = j;
        }
        table = newTable;
        return true;
    }


    private void rebuildTable(){
        while(true){
            if(rehashing()){
                return;
            }
        }
    }

    public boolean insert(int x){
        int index = hash(x);
        if(table[index] != 0){ //////////////////change when going stringy
            table[index] = x;
            return true; ////////////////checkkkkk iffffff exists
        }else{
            rebuildTable();
            return false;
        }
    }

    public static void main(String[] args) {
//        HashTable uh = new HashTable(32, 5);
//        System.out.println(uh.hash(123456));
        int[] table = new int[2];
        System.out.println(Arrays.toString(table));
    }
}
