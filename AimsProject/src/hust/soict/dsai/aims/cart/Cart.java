package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media media) {
        if (media == null) {
            System.out.println("Cannot add null media.");
            return;
        }

        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full.");
            return;
        }

        if (itemsOrdered.contains(media)) {
            System.out.println("The media is already in the cart.");
            return;
        }

        itemsOrdered.add(media);
        System.out.println("The media has been added.");
    }

    public void removeMedia(Media media) {
        if (media == null) {
            System.out.println("Cannot remove null media.");
            return;
        }

        if (itemsOrdered.remove(media)) {
            System.out.println("The media has been removed.");
        } else {
            System.out.println("The media is not in the cart.");
        }
    }

    public float totalCost() {
        float total = 0.0f;

        for (Media media : itemsOrdered) {
            total += media.getCost();
        }

        return total;
    }
}