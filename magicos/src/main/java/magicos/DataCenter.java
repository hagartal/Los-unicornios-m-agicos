package magicos;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by Noa Agiv on 2/23/2017.
 */
public class DataCenter {
    public HashMap<Integer, Video> videos;
    public HashMap<Integer, Cache> caches;
    public HashMap<Integer, Endpoint> endpoints;

    public Video getVideo(int id){
        return videos.get(id);
    }

    public Video addVideo(int id, int sizeMb){
        return videos.put(id, new Video(id, sizeMb));
    }

    public Cache getCache(int id){
        return caches.get(id);
    }

    public Cache addCache(int id, int sizeMb){
        return caches.put(id, new Cache(id, sizeMb));
    }

    public Endpoint getEndPoint(int id){
        return endpoints.get(id);
    }

    public Endpoint addEndpoint(int id, int DsLatency){
        return endpoints.put(id, new Endpoint(id, DsLatency));
    }
}
