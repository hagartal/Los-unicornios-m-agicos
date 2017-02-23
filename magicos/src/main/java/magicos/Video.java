package magicos;

/**
 * Created by Noa Agiv on 2/23/2017.
 */
public class Video {
    int id;
    int sizeMb;

    public Video(int id, int sizeMb) {
        this.id = id;
        this.sizeMb = sizeMb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Video video = (Video) o;

        return (id != video.id);
    }

    @Override
    public int hashCode() {
        int result = id;
        return result;
    }
}
