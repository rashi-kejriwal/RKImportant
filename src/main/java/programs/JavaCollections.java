package programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JavaCollections {

    class Book {
        int id;
        String name,author,publisher;
        int quantity;
        public Book(int id, String name, String author, String publisher, int quantity) {
            this.id = id;
            this.name = name;
            this.author = author;
            this.publisher = publisher;
            this.quantity = quantity;
        }
    }

    public static void main(String args[]) {
        ArrayList names = new ArrayList();
        names.add("Chaitanya");
        names.add("Steve");
        names.add("Jack");

        Iterator it = names.iterator();

        while (it.hasNext()) {
            String obj = (String) it.next();
            System.out.println(obj);
        }

        //Creating map of Books
        Map<Integer, Book> map = new HashMap<Integer, Book>();
        //Creating Books
        Book b1;
        Book b2;
        Book b3;
        //Adding Books to map
   //   map.put(1,b1);
//    map.put(2,b2);
//    map.put(3,b3);

        //Traversing map
        for (Map.Entry<Integer, Book> entry : map.entrySet()) {
            int key = entry.getKey();
            Book b = entry.getValue();
            System.out.println(key + " Details:");
            System.out.println(b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity);
        }
    }
}
