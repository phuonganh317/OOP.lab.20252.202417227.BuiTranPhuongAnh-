package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DVD extends Disc implements Playable {
    public DVD(String title) {
        super(title);
    }

    public DVD(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DVD(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }

    public DVD(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }

        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - "
                + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + " $";
    }
}