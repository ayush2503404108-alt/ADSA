import  java.util.*;
public class Hash_func {
    public int hash(int key, int tableSize){
        return key % tableSize;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hash_func hf = new Hash_func();
        System.err.print("enter the key");
        int key = sc.nextInt();
        System.err.print("enter the table size");
        int tableSize = sc.nextInt();
        int hashValue = hf.hash(key, tableSize);
        System.err.println("hash value:" + hashValue);
    }   
}