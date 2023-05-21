package MyApp;

public class FactoryProducer {
    public static AbstractFactory GetDictionaryHashingType(String HashingType,int n){
        if(HashingType.equalsIgnoreCase("HashTable1")){
            return new DictionaryHash1(n);
        } else if (HashingType.equalsIgnoreCase("HashingTable2")) {
            return new DictionaryHash2(n);
        }
        else {
            return null;
        }
    }
}
