package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc() {
        super();
    }

    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(String title, String category, String director, String artist, float cost) {
        super(title, category, director, 0, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("The track has been added.");
        } else {
            System.out.println("The track already exists.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("The track has been removed.");
        } else {
            System.out.println("The track does not exist.");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;

        for (Track track : tracks) {
            totalLength += track.getLength();
        }

        return totalLength;
    }

    @Override
    public void play() {
        if (getLength() > 0) {
            System.out.println("Playing CD: " + getTitle());
            System.out.println("CD length: " + getLength());

            for (Track track : tracks) {
                track.play();
            }
        } else {
            System.out.println("Cannot play this CD.");
        }
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - "
                + getArtist() + " - " + getDirector() + " - "
                + getLength() + ": " + getCost() + "$";
    }
}