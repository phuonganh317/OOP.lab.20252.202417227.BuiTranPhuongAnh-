package hust.soict.dsai.aims.cart;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;
    private DVD itemsList[] = new DVD[MAX_NUMBERS_ORDERED];
    private float cost = 0.0f;

    public void addDVD(DVD disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsList[qtyOrdered] = disc;
            qtyOrdered++;
            cost += disc.getCost();
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
    for (DigitalVideoDisc disc : dvdList) {
        addDigitalVideoDisc(disc); 
    }
}

	public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
    for (DigitalVideoDisc disc : dvdList) {
        addDigitalVideoDisc(disc); 
    }
}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
    addDigitalVideoDisc(dvd1);
    addDigitalVideoDisc(dvd2);
}

    public void removeDVD(DVD disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsList[i] == disc) {
                cost -= disc.getCost();
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsList[j] = itemsList[j+1];
                }
                itemsList[qtyOrdered - 1] = null;
                qtyOrdered--;
                found = true;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc was not found in the cart.");
        }
    }

    public float getCost() {
        return cost;
    }
}
public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
            total += itemsOrdered[i].getCost();
        }
        System.out.println("Total cost: " + total + " $");
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        boolean matchFound = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Found match for ID " + id + ": " + itemsOrdered[i].toString());
                matchFound = true;
                break;
            }
        }
        if (!matchFound) {
            System.out.println("No match found for ID: " + id);
        }
    }

    public void searchByTitle(String title) {
        boolean matchFound = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("Found match for title '" + title + "': " + itemsOrdered[i].toString());
                matchFound = true;
            }
        }
        if (!matchFound) {
            System.out.println("No match found for title: " + title);
        }
    }
