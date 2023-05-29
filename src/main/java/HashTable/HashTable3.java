package HashTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class HashTable3 {
    private int[][] h;
    private int n;
    private HashTable[] table;
    private int u = 64;
    private int b;
    private int collisionsCounter = 0;
    private int size = 0;

    public HashTable3(int n) {
        this.b = (int)Math.ceil(Math.log(n) / Math.log(2));
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
        if(table[index] == null){
            table[index] = new HashTable(1);
            int state = table[index].insert(x,false);
            size++;
            return true;
//        }else if(Hs[table[index]] == null &&As[table[index]][0] == x){
//            return false;
        }else{
            int state = table[index].insert(x, false);
            if(state == 3){
                collisionsCounter++;
                HashTable table = new HashTable(this.table[index].getN()+1);
                for(String elem: this.table[index].getTable()){
                    if(elem == null)continue;
                    table.insert(elem,true);
                }
                table.insert(x,true);
                this.table[index] = table;
            }
            else if(state==2||state==4)
                return false;

            return true;
        }
    }


    public boolean insert(String x, int[] count){
        int index = hash(x);
        if(table[index] == null){
            table[index] = new HashTable(1);
            int state = table[index].insert(x,false);
            return true;
//        }else if(Hs[table[index]] == null &&As[table[index]][0] == x){
//            return false;
        }else{
            int state = table[index].insert(x, false);
            if(state == 3){
                collisionsCounter++;
                HashTable table = this.table[index];
                if(this.table[index].getN() < count[index]){
                    table = new HashTable(this.table[index].getN() + count[index]);
                }
                for(String elem: this.table[index].getTable()){
                    if(elem == null)continue;
                    table.insert(elem,true);
                }
                table.insert(x,true);
                this.table[index] = table;
            }
            else if(state==2||state==4)
                return false;

            return true;
        }
    }


    private int[] BatchExecution(String str,int type){
        int success = 0, fail = 0;
        String[] words = str.split(" ");
        if(type==0) {
            int[] count = new int[this.n];
            for (String s: words){
                int index = hash(s);
                count[index]++;
            }
            for (String s : words) {
                if (this.insert(s, count)) {
                    success++;
                }
                else {
                    fail++;
                }
            }
        }
        else{
            for (String s : words) {
                if (this.delete(s)) {
                    success++;
                }
                else {
                    fail++;
                }
            }
        }
        return new int[]{success, fail};
    }

    public int[] BatchInsert(String file) {
        StringBuilder builder = new StringBuilder();
        try(BufferedReader Buffer = new BufferedReader(new FileReader(file))){
            String str;
            while((str = Buffer.readLine())!= null){
                builder.append(str).append(" ");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return BatchExecution(builder.toString(),0);
    }

    public int[] BatchDelete(String file) {
        StringBuilder builder = new StringBuilder();
        try(BufferedReader Buffer = new BufferedReader(new FileReader(file))){
            String str;
            while((str = Buffer.readLine())!= null){
                builder.append(str).append(" ");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return BatchExecution(builder.toString(),1);
    }

    public Boolean find(String x){
        int index = hash(x);
        if (table[index] != null)
            return table[index].find(x);
        else return false;
    }
    public boolean delete(String x){ ////// changed to boolean true if item to be deleted existed and false if not
        int index = hash(x);
        if (table[index] != null)
            return table[index].delete(x);
        else return false;
    }

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

    public int getCollisionsCounter() { return collisionsCounter; }

    public int length() {return this.size;}

}
