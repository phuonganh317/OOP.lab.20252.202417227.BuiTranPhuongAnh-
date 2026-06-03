package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DVD;

public class CartScreenTest {
    public static void main(String[] args) {
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

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);

        new CartScreen(cart);
    }
}