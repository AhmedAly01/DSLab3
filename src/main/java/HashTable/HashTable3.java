package HashTable;

import java.util.Arrays;
import java.util.Random;

public class HashTable3 {
    private int[][] h;
    private int n;
    private HashTable[] table;
    private int u = 512;
    private int b;
    private int collisionsCounter = 0;
    public HashTable3(int n) {
        this.b = 2* (int)Math.ceil(Math.log(n) / Math.log(2));
        this.n = n;
        h = generateHashMatrix(b, u);
        table = new HashTable[this.n];
        this.collisionsCounter = 0;
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
        return index%this.n;
    }

    public boolean insert(String x){
        int index = hash(x);
        System.out.println("index  " + index);
        if(table[index] == null){
            table[index] = new HashTable(1);// TODO: change this parameters
            int state = table[index].insert(x,false);
            return true;
//        }else if(Hs[table[index]] == null &&As[table[index]][0] == x){ // TODO: use hash search function in this condition
//            return false;
        }else{
            int state = table[index].insert(x, false);
            if(state == 3){
                collisionsCounter++;
                HashTable table = new HashTable(this.table[index].getN()+1);
                for(String elem: this.table[index].getTable()){
                    if(elem == null)continue;
                    System.out.println("found elem is" + elem);
                    table.insert(elem,true);
                }
                table.insert(x,true);
                this.table[index] = table;
            }

            // TODO: change this parameters
            return true;
        }
    }
    /*
    public Boolean find(String x){
        int index = hash(x);
        return table[index].find(x);
    }
    public void delete(String x){
        int index = hash(x);
        return table[index].delete(x);
    }

*/
    public static void main(String[] args) {
        HashTable3 uh = new HashTable3(4);
        System.out.println(uh.insert("h1"));
        System.out.println(uh.insert("h2"));
        System.out.println(uh.insert("h3"));
        System.out.println(uh.insert("h4"));
        System.out.println(uh.insert("h5"));
        System.out.println(uh.insert("h6"));
        System.out.println(uh.insert("h6"));
        System.out.println(uh.insert("h7"));
//        System.out.println(uh.hash("hiiiiiiiiii"));
        System.out.println(Arrays.toString(uh.table));
    }
}
