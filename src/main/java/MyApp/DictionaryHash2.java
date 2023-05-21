package MyApp;

import HashTable.HashTable3;

public class DictionaryHash2 extends AbstractFactory {
    HashTable3 Hash;
    DictionaryHash2(int n){
        Hash = new HashTable3(n);
    }

    @Override
    boolean insert(String str) {
        return false;
    }

    @Override
    boolean delete(String str) {
        return false;
    }

    @Override
    boolean search(String str) {
        return false;
    }

    @Override
    int[] BatchInsert(String file) {
        return new int[0];
    }

    @Override
    int[] BatchDelete(String file) {
        return new int[0];
    }
}
