package MyApp;

import HashTable.HashTable;

public class DictionaryHash1 extends AbstractFactory{
    HashTable Hash;

    DictionaryHash1(int n){
        Hash = new HashTable(n);
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
