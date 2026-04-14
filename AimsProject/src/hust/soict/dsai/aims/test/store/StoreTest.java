package hust.soict.dsai.aims.test.store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DVD dvd2 = new DVD("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DVD dvd3 = new DVD("Aladin", "Animation", "", 0, 18.99f);

        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        store.removeDVD(dvd2);
        
        store.removeDVD(dvd2);
    }
}