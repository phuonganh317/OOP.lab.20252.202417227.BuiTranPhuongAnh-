package hust.soict.dsai.aims.test.cart;


public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DVD dvd2 = new DVD("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DVD dvd3 = new DVD("Aladin", "Animation", "", 0, 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        cart.print();

        System.out.println("\n--- Search by ID ---");
        cart.searchById(2); 
        cart.searchById(99); 

        System.out.println("\n--- Search by Title ---");
        cart.searchByTitle("Star Wars");
        cart.searchByTitle("Cinderella");
    }
}