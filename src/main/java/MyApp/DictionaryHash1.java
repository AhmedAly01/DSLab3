package MyApp;

import HashTable.HashTableN2;

public class DictionaryHash1 extends AbstractFactory{
    HashTableN2 Hash;

    DictionaryHash1(int n){
        Hash = new HashTableN2(n);
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

//    private int[] BatchExecution(String str,int type){
//        int success = 0, fail = 0;
//        String[] words = str.split(" ");
//        if(type==0) {
//            for (String s : words) {
//                int x = Hash.insert(s,true);
//                if (x==4||x==2) {
//                    fail++;
//                }
//                else {
//                    success++;
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
