package magicos;
import java.util.*;

/**
 * Created by pavelr on 23/2/17.
 */
public class Algorithm {
    List<Cache> cacheList;

    public Algorithm(DataCenter dc){
        cacheList = new ArrayList<Cache>(dc.caches.values());
    }

    public void run(){
        for (Cache currCache: cacheList){
            Set<Endpoint> cacheEps = currCache.endpointLatency.keySet();
            HashMap<Video, Integer> videoScores = new HashMap();

            for (Endpoint currEp : cacheEps){
                HashMap<Video, Integer> epVideos = currEp.videoRequests;
                Set<Video> epVideoSet = epVideos.keySet();
                for (Video currVid : epVideoSet){
                    int currScore = videoScores.containsKey(currVid) ? videoScores.get(currVid) : 0;
                    currScore += epVideos.get(currVid)*(currEp.dataCenterLatency - currCache.endpointLatency.get(currEp));
                    videoScores.put(currVid, currScore);
                }
            }

            Set<Map.Entry<Video, Integer>> scoreEntriesSet = videoScores.entrySet();
            ArrayList<Map.Entry<Video, Integer>> scoreEntriesList = new ArrayList(scoreEntriesSet);
            Collections.sort(scoreEntriesList,new Comparator<Map.Entry<Video, Integer>>(){
                public int compare(Map.Entry<Video, Integer> me1, Map.Entry<Video, Integer> me2){
                    return me2.getValue() - me1.getValue();
                }
            });

            int cacheSize = currCache.freeSpace;
            for (Map.Entry<Video, Integer> scoreEntry : scoreEntriesList){
                int videoSize = scoreEntry.getKey().sizeMb;
                if (cacheSize >= videoSize){
                    currCache.addVideo(scoreEntry.getKey());
                    cacheSize -= videoSize;
                }
                if (cacheSize == 0){
                    break;
                }
            }

        }
    }

}
