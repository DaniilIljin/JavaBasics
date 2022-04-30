package reflection.serializer;

public class Post {
    @Stored("post-title")
    private String title;
    @Stored
    private String text;

    private int replycount;

    public Post(){
    }

    public Post(String title, String text, int replycount) {
        this.title = title;
        this.text = text;
        this.replycount = replycount;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", replycount=" + replycount +
                '}';
    }
}
