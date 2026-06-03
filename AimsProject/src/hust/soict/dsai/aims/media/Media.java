package hust.soict.dsai.aims.media;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    private static int nbMedia = 0;

    public Media() {
        nbMedia++;
        this.id = nbMedia;
    }

    public Media(String title) {
        this();
        this.title = title;
    }

    public Media(String title, String category, float cost) {
        this(title);
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Media)) {
            return false;
        }

        Media other = (Media) obj;

        if (this.title == null) {
            return other.title == null;
        }

        return this.title.equals(other.title);
    }

    @Override
    public String toString() {
        return this.title + " - " + this.category + " - " + this.cost + " $";
    }
}