package model;

public class Post {
    private Long ID;
    private String imageIrl;
    private String direction;

    public Post() {
    }

    public Post(Long ID, String imageIrl, String direction) {
        this.ID = ID;
        this.imageIrl = imageIrl;
        this.direction = direction;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getImageIrl() {
        return imageIrl;
    }

    public void setImageIrl(String imageIrl) {
        this.imageIrl = imageIrl;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        int count = 1;
        return "\n Post "+
                " ID = " + ID +
                ",  imageIrl = " + imageIrl +
                ",  direction = " + direction ;
    }
}
