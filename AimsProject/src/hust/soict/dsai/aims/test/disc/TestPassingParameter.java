import hust.soict.dsai.aims.media.DVD;
package hust.soict.dsai.aims.test.disc;

public class TestPassingParameter {

    public static void main(String[] args) {
        DVD jungleDVD = new DVD("Jungle");
        DVD cinderellaDVD = new DVD("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(DVD dvd1, DVD dvd2) {
        String tmpTitle = dvd1.getTitle();
        String tmpCategory = dvd1.getCategory();
        String tmpDirector = dvd1.getDirector();
        int tmpLength = dvd1.getLength();
        float tmpCost = dvd1.getCost();
        
        dvd1.setTitle(dvd2.getTitle());
        dvd1.setCategory(dvd2.getCategory());
        dvd1.setDirector(dvd2.getDirector());
        dvd1.setLength(dvd2.getLength());
        dvd1.setCost(dvd2.getCost());
        
        dvd2.setTitle(tmpTitle);
        dvd2.setCategory(tmpCategory);
        dvd2.setDirector(tmpDirector);
        dvd2.setLength(tmpLength);
        dvd2.setCost(tmpCost);
    }

    public static void changeTitle(DVD dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DVD(oldTitle);
    }
}