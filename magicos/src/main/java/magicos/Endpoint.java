package magicos;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Noa Agiv on 2/23/2017.
 */
public class Endpoint {
    int id;
    HashMap<Video, Integer> videoRequests = new HashMap<Video, Integer>();
    HashMap<Cache, Integer> cacheLatency = new HashMap<Cache, Integer>();
    int dataCenterLatency;

    public Endpoint(int id, int dataCenterLatency) {
        this.id = id;
        this.dataCenterLatency = dataCenterLatency;
    }

    public void addCacheLatency(Cache cache, int cacheLatency){
        this.cacheLatency.put(cache, cacheLatency);
        cache.addEndpointLatency(this, cacheLatency);
    }
    public void setCacheLatency(HashMap<Cache, Integer> cacheLatency) {
        this.cacheLatency = cacheLatency;
    }

    public void addVideoRequest(Video video, int requests){
        videoRequests.put(video, requests);
    }

    public void setDataCenterLatency(int dataCenterLatency) {
        this.dataCenterLatency = dataCenterLatency;
    }

}
