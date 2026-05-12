package hust.soict.dsai.aims.media;

public class DVD extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DVD(String title) {
        super(title);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

    public DVD(String category, String title, float cost) {
        super(category, title, cost);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

    public DVD(String director, String category, String title, float cost) {
        super(director, category, title, cost);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

    public DVD(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

    @Override
    public void play() {
        if (getLength() > 0) {
            System.out.println("Playing DVD: " + getTitle());
            System.out.println("DVD length: " + getLength());
        } else {
            System.out.println("Cannot play this DVD.");
        }
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - "
                + getDirector() + " - " + getLength() + ": " + getCost() + "$";
    }
}