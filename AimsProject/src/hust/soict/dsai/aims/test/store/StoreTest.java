package hust.soict.dsai.aims.test.store;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DVD;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DVD dvd = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        Book book = new Book("Java Programming", "Education", 12.5f);
        book.addAuthor("John Smith");

        CompactDisc cd = new CompactDisc("Greatest Hits", "Music", "Director A", "Artist A", 15.5f);
        Track track1 = new Track("Song 1", 3);
        Track track2 = new Track("Song 2", 5);

        cd.addTrack(track1);
        cd.addTrack(track2);

        store.addMedia(dvd);
        store.addMedia(book);
        store.addMedia(cd);

        store.printStore();

        Media foundMedia = store.searchByTitle("The Lion King");

        if (foundMedia != null) {
            System.out.println("Found media: " + foundMedia.toString());
        } else {
            System.out.println("Media not found.");
        }

        store.removeMedia(book);

        store.printStore();
    }
}