package magicos;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by Noa Agiv on 2/23/2017.
 */
public class Cache {
    int id;
    int space;
    int freeSpace;
    HashMap<Endpoint, Integer> endpointLatency;
    Set<Video> videos;

    public Cache(int id, int space) {
        this.id = id;
        this.space = space;
        this.freeSpace = space;
    }

    public void addVideo (Video video){
        videos.add(video);
        subtractSpace(video.sizeMb);
    }

    public void subtractSpace(int spaceMb){
        freeSpace =-spaceMb;
    }


    public boolean isInCache(int videoId){
        return videos.contains(new Video(videoId, 0));
    }

    public void addEndpointLatency(Endpoint enpoint, int enpointLatency){
        this.endpointLatency.put(enpoint, enpointLatency);
    }
}
