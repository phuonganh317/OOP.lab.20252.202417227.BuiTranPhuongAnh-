package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    public Disc() {
        super();
    }

    public Disc(String title) {
        super(title);
    }

    public Disc(String category, String title, float cost) {
        super(category, title, cost);
    }

    public Disc(String director, String category, String title, float cost) {
        super(category, title, cost);
        this.director = director;
    }

    public Disc(String title, String category, String director, int length, float cost) {
        super(category, title, cost);
        this.director = director;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    protected void setLength(int length) {
        this.length = length;
    }

    protected void setDirector(String director) {
        this.director = director;
    }
}