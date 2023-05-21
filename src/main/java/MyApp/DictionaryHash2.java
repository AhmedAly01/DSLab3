package MyApp;

import HashTable.HashTable3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryHash2 extends AbstractFactory {
    HashTable3 Hash;
    DictionaryHash2(int n){
        Hash = new HashTable3(n);
    }

    @Override
    boolean insert(String str) {
        return Hash.insert(str);
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
                if (Hash.insert(s)) {
                    success++;
                }
                else {
                    fail++;
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
        return new String[0];
    }

    @Override
    public int length() {return Hash.length();}
}
