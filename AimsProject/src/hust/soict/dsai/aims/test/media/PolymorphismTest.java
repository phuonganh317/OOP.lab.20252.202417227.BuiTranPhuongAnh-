package hust.soict.dsai.aims.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DVD;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

public class PolymorphismTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        DVD dvd = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        Book book = new Book("Java Programming", "Education", 12.5f);
        book.addAuthor("John Smith");
        book.addAuthor("Mary Jane");

        CompactDisc cd = new CompactDisc("Greatest Hits", "Music", "Director A", "Artist A", 15.5f);
        Track track1 = new Track("Song 1", 3);
        Track track2 = new Track("Song 2", 5);
        cd.addTrack(track1);
        cd.addTrack(track2);

        mediae.add(dvd);
        mediae.add(book);
        mediae.add(cd);

        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}