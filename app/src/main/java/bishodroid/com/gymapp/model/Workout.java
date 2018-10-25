package bishodroid.com.gymapp.model;

public class Workout {

    private String title;
    private String videoUrl;
    private String category;

    public Workout() {
    }

    public Workout(String title, String videoUrl, String category) {
        this.title = title;
        this.videoUrl = videoUrl;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
