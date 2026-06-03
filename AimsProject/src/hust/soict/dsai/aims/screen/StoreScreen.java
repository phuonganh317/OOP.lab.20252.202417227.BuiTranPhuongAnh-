package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DVD;
import hust.soict.dsai.aims.store.Store;

public class StoreScreenTest {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        DVD dvd1 = new DVD(
                "The Lion King",
                "Animation",
                "Roger Allers",
                87,
                19.95f
        );

        DVD dvd2 = new DVD(
                "Star Wars",
                "Science Fiction",
                "George Lucas",
                124,
                24.95f
        );

        DVD dvd3 = new DVD(
                "Aladdin",
                "Animation",
                "John Musker",
                90,
                18.99f
        );

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        new StoreScreen(store, cart);
    }
}