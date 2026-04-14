package hust.soict.dsai.aims.store;

public class Store {
    private DVD[] itemsInStore = new DVD[50];
    private int qtyInStore = 0;

    public void addDVD(DVD dvd) {
        if (qtyInStore < itemsInStore.length) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("DVD '" + dvd.getTitle() + "' added to store.");
        } else {
            System.out.println("Store is full!");
        }
    }

    public void removeDVD(DVD dvd) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                found = true;
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("DVD '" + dvd.getTitle() + "' removed from store.");
                break;
            }
        }
        if (!found) {
            System.out.println("DVD not found in store.");
        }
    }
}