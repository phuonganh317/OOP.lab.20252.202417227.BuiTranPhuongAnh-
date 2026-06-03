package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore;

    public Store() {
        itemsInStore = new ArrayList<Media>();
    }

    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("The media \"" + media.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("The media \"" + media.getTitle() + "\" already exists in the store.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media \"" + media.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("The media was not found in the store.");
        }
    }

    public void printStore() {
        System.out.println("***********************STORE***********************");
        System.out.println("Items in store:");

        for (int i = 0; i < itemsInStore.size(); i++) {
            Media media = itemsInStore.get(i);
            System.out.println((i + 1) + ". " + media.toString());
        }

        System.out.println("***************************************************");
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }

        return null;
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}