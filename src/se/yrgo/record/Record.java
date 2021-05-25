package se.yrgo.record;

/**
 * 
 * @author Alexander Gabay
 *
 */

public class Record {
    private int id;
    private String artist;
    private String title;
    private String genre;
    private String barCode;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getBarCode() {
        return barCode;
    }
    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
    @Override
    public String toString() {
        return "Record (" + this.id + ") - " + this.artist
                + " - " + this.title;
    }
    
    
}
