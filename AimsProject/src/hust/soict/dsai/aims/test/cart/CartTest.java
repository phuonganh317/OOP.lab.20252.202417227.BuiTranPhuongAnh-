package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DVD;
import hust.soict.dsai.aims.media.Track;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DVD dvd = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        Book book = new Book("Java Programming", "Education", 12.5f);
        book.addAuthor("John Smith");

        CompactDisc cd = new CompactDisc("Greatest Hits", "Music", "Director A", "Artist A", 15.5f);
        Track track1 = new Track("Song 1", 3);
        Track track2 = new Track("Song 2", 5);

        cd.addTrack(track1);
        cd.addTrack(track2);

        cart.addMedia(dvd);
        cart.addMedia(book);
        cart.addMedia(cd);

        cart.print();

        cart.searchByTitle("Java");
        cart.searchById(dvd.getId());

        cart.removeMedia(book);

        cart.print();
    }
}