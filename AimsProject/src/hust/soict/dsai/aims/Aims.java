package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DVD;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    private static Scanner scanner = new Scanner(System.in);
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        createSampleData();

        int choice;

        do {
            showMenu();
            choice = readInt();

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exit AIMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void viewStore() {
        int choice;

        do {
            store.printStore();
            storeMenu();
            choice = readInt();

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaFromStoreToCart();
                    break;
                case 3:
                    playMediaFromStore();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Back to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public static void seeMediaDetails() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);

        if (media == null) {
            System.out.println("Media not found.");
            return;
        }

        System.out.println(media.toString());

        int choice;

        do {
            mediaDetailsMenu();
            choice = readInt();

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    System.out.println("Back to store menu.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public static void addMediaFromStoreToCart() {
        System.out.print("Enter media title to add to cart: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);

        if (media != null) {
            cart.addMedia(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMediaFromStore() {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);

        if (media == null) {
            System.out.println("Media not found.");
            return;
        }

        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    public static void updateStore() {
        System.out.println("Update Store:");
        System.out.println("--------------------------------");
        System.out.println("1. Add DVD");
        System.out.println("2. Add Book");
        System.out.println("3. Add CD");
        System.out.println("4. Remove media");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose: ");

        int choice = readInt();

        switch (choice) {
            case 1:
                addDVDToStore();
                break;
            case 2:
                addBookToStore();
                break;
            case 3:
                addCDToStore();
                break;
            case 4:
                removeMediaFromStore();
                break;
            case 0:
                System.out.println("Back to main menu.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void addDVDToStore() {
        System.out.print("Enter DVD title: ");
        String title = scanner.nextLine();

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter director: ");
        String director = scanner.nextLine();

        System.out.print("Enter length: ");
        int length = readInt();

        System.out.print("Enter cost: ");
        float cost = readFloat();

        DVD dvd = new DVD(title, category, director, length, cost);
        store.addMedia(dvd);
    }

    public static void addBookToStore() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter cost: ");
        float cost = readFloat();

        Book book = new Book(title, category, cost);

        System.out.print("Enter number of authors: ");
        int numberOfAuthors = readInt();

        for (int i = 0; i < numberOfAuthors; i++) {
            System.out.print("Enter author " + (i + 1) + ": ");
            String author = scanner.nextLine();
            book.addAuthor(author);
        }

        store.addMedia(book);
    }

    public static void addCDToStore() {
        System.out.print("Enter CD title: ");
        String title = scanner.nextLine();

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter director: ");
        String director = scanner.nextLine();

        System.out.print("Enter artist: ");
        String artist = scanner.nextLine();

        System.out.print("Enter cost: ");
        float cost = readFloat();

        CompactDisc cd = new CompactDisc(title, category, director, artist, cost);

        System.out.print("Enter number of tracks: ");
        int numberOfTracks = readInt();

        for (int i = 0; i < numberOfTracks; i++) {
            System.out.print("Enter track " + (i + 1) + " title: ");
            String trackTitle = scanner.nextLine();

            System.out.print("Enter track " + (i + 1) + " length: ");
            int trackLength = readInt();

            Track track = new Track(trackTitle, trackLength);
            cd.addTrack(track);
        }

        store.addMedia(cd);
    }

    public static void removeMediaFromStore() {
        System.out.print("Enter media title to remove from store: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);

        if (media != null) {
            store.removeMedia(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void seeCurrentCart() {
        int choice;

        do {
            cart.print();
            cartMenu();
            choice = readInt();

            switch (choice) {
                case 1:
                    filterMediaInCart();
                    break;
                case 2:
                    sortMediaInCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaFromCart();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    System.out.println("Back to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public static void filterMediaInCart() {
        System.out.println("Filter medias in cart:");
        System.out.println("1. By ID");
        System.out.println("2. By title");
        System.out.print("Please choose: ");

        int choice = readInt();

        switch (choice) {
            case 1:
                System.out.print("Enter ID: ");
                int id = readInt();
                cart.searchById(id);
                break;
            case 2:
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                cart.searchByTitle(title);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void sortMediaInCart() {
        System.out.println("Sort medias in cart:");
        System.out.println("1. By title");
        System.out.println("2. By cost");
        System.out.print("Please choose: ");

        int choice = readInt();

        switch (choice) {
            case 1:
                cart.sortByTitleCost();
                System.out.println("Cart sorted by title.");
                cart.print();
                break;
            case 2:
                cart.sortByCostTitle();
                System.out.println("Cart sorted by cost.");
                cart.print();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void removeMediaFromCart() {
        System.out.print("Enter media title to remove from cart: ");
        String title = scanner.nextLine();

        Media media = findMediaInCartByTitle(title);

        if (media != null) {
            cart.removeMedia(media);
        } else {
            System.out.println("Media not found in cart.");
        }
    }

    public static void playMediaFromCart() {
        System.out.print("Enter media title to play from cart: ");
        String title = scanner.nextLine();

        Media media = findMediaInCartByTitle(title);

        if (media == null) {
            System.out.println("Media not found in cart.");
            return;
        }

        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    public static void placeOrder() {
        System.out.println("An order has been created.");
        cart.getItemsOrdered().clear();
        System.out.println("The current cart is now empty.");
    }

    public static Media findMediaInCartByTitle(String title) {
        for (Media media : cart.getItemsOrdered()) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }

        return null;
    }

    public static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.nextLine();
        }

        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    public static float readFloat() {
        while (!scanner.hasNextFloat()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }

        float value = scanner.nextFloat();
        scanner.nextLine();
        return value;
    }

    public static void createSampleData() {
        DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DVD dvd2 = new DVD("Aladdin", "Animation", "Guy Ritchie", 128, 24.95f);

        Book book1 = new Book("Java Programming", "Education", 12.5f);
        book1.addAuthor("John Smith");

        CompactDisc cd1 = new CompactDisc("Greatest Hits", "Music", "Director A", "Artist A", 15.5f);
        Track track1 = new Track("Song 1", 3);
        Track track2 = new Track("Song 2", 5);
        cd1.addTrack(track1);
        cd1.addTrack(track2);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(cd1);
    }
}