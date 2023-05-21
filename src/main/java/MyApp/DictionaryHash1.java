package MyApp;

import HashTable.HashTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryHash1 extends AbstractFactory{
    HashTable Hash;

    DictionaryHash1(int n){
        Hash = new HashTable(n);
    }
    @Override
    boolean insert(String str) {
        int x = Hash.insert(str,true);
        if(x==4||x==2){
         return false;
        }
        return true;
    }

    @Override
    boolean delete(String str) {
        return Hash.delete(str);
    }

    @Override
    boolean search(String str) {
        return Hash.find(str);
    }

    private int[] BatchExecution(String str,int type){
        int success = 0, fail = 0;
        String[] words = str.split(" ");
        if(type==0) {
            for (String s : words) {
                int x = Hash.insert(s,true);
                if (x==4||x==2) {
                    fail++;
                }
                else {
                    success++;
                }
            }
        }
        else{
            for (String s : words) {
                if (Hash.delete(s)) {
                    success++;
                }
                else {
                    fail++;
                }
            }
        }
        return new int[]{success, fail};
    }

    @Override
    int[] BatchInsert(String file) {
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

    @Override
    int[] BatchDelete(String file) {
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

    @Override
    String[] GetTable() {
        return Hash.getTable();
    }
    @Override
    public int length() {return Hash.length();}

}
