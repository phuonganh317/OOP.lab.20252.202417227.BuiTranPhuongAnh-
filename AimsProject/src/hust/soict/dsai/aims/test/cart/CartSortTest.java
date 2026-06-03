package hust.soict.dsai.aims.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DVD;

public class CartSortTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DVD dvd2 = new DVD("Aladdin", "Animation", "Guy Ritchie", 128, 24.95f);
        DVD dvd3 = new DVD("Avatar", "Science Fiction", "James Cameron", 162, 29.95f);

        Book book1 = new Book("Clean Code", "Programming", 30.0f);
        Book book2 = new Book("Algorithms", "Education", 30.0f);
        Book book3 = new Book("Data Structures", "Education", 15.0f);

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        cart.addMedia(book1);
        cart.addMedia(book2);
        cart.addMedia(book3);

        System.out.println("Before sorting:");
        cart.print();

        System.out.println("After sorting by title then cost:");
        cart.sortByTitleCost();
        cart.print();

        System.out.println("After sorting by cost then title:");
        cart.sortByCostTitle();
        cart.print();
    }
}