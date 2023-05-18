package HashTable;

import java.util.Arrays;
import java.util.Random;

public class HashTable3 {
    private int[][] h;
    private int n;
    private HashTable[] table;
    private int u;
    private int b;
    private int collisionsCounter = 0;
    public HashTable3(int u, int b) {
        this.u = u;
        this.b = b;
        this.n = 1 << b;
        this.collisionsCounter = 0;
        h = generateHashMatrix(b, u);
        table = new HashTable[this.n];
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

    public boolean insert(String x){
        int index = hash(x)%50;
        if(table[index] == null){
            table[index] = new HashTable(10,10);// TODO: change this parameters
            table[index].insert(x);
            return true;
//        }else if(Hs[table[index]] == null &&As[table[index]][0] == x){ // TODO: use hash search function in this condition
//            return false;
        }else{
            collisionsCounter++;
            HashTable table = new HashTable(10,10);// TODO: change this parameters
            for(String elem: this.table[index].getTable()){
                if(elem == null)continue;
                System.out.println("found elem is" + elem);
                table.insert(elem);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        HashTable3 uh = new HashTable3(32, 5);
        System.out.println(uh.insert("hello ---- world"));
        System.out.println(uh.insert("hello ---- world"));
        System.out.println(uh.hash("hello ---- world"));
        System.out.println(Arrays.toString(uh.table));
    }
}
