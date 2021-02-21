/**
 * The singelton class to sort through the library
 * @author Michael Sana
 */
import java.util.HashMap;
public class Library{
    HashMap<String,Integer> books = new HashMap<>();
    Library library;

    /** This makes it so there can only be one instance of Library */
    private Library(){}

    public Library getInstance(){
        if(library == null){
            System.out.println("Creating our library. Time to begin reading.");
            library = new Library();
        }
        return library;
    }
    public boolean checkoutBook(String bookName){
        if(books.containsKey(bookName) && books.get(bookName) >= 1 ){
            books.replace(bookName, books.get(bookName) -1);
            System.out.println(bookName + " was succesfully check out");
            return true;
        }
        else{
            System.out.println("Sorry " + bookName + " is not in stock");
            return false;
        }
    }
    public void checkinBook(String bookName, int numToAdd){

        if(books.containsKey(bookName)){
            books.replace(bookName, books.get(bookName) + numToAdd);
            System.out.println("A new copy of " + bookName + " was added to the library");
        }
        else{
            books.put(bookName, numToAdd);
            System.out.println(bookName + " was added to the library");
        }
    }
    public void displayBooks(){
        System.out.println("\nInventory:");
        for(String value : books.keySet()){
            System.out.println("\t " + value + ", copies " + books.get(value));
        }
    }
}