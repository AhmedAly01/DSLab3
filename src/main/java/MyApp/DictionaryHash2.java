package MyApp;

import HashTable.HashTableN;

public class DictionaryHash2 extends AbstractFactory {
    HashTableN Hash;
    DictionaryHash2(int n){
        Hash = new HashTableN(n);
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

//    private int[] BatchExecution(String str,int type){
//        int success = 0, fail = 0;
//        String[] words = str.split(" ");
//        if(type==0) {
//            for (String s : words) {
//                if (Hash.insert(s)) {
//                    success++;
//                }
//                else {
//                    fail++;
//                }
//            }
//        }
//        else{
//            for (String s : words) {
//                if (Hash.delete(s)) {
//                    success++;
//                }
//                else {
//                    fail++;
//                }
//            }
//        }
//        return new int[]{success, fail};
//    }
    @Override
    int[] BatchInsert(String file) {
        return Hash.BatchInsert(file);
    }

    @Override
    int[] BatchDelete(String file) {
        return Hash.BatchDelete(file);
    }


    @Override
    public int length() {return Hash.length();}
}
