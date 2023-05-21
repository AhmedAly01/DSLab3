package MyApp;

public abstract class AbstractFactory {
    abstract boolean insert(String str);
    abstract boolean delete(String str);
    abstract boolean search(String str);
    abstract int[] BatchInsert(String file);
    abstract int[] BatchDelete(String file);
    abstract public int length();
}
