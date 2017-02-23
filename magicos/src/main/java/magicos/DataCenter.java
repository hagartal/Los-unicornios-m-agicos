package magicos;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static java.awt.SystemColor.text;
import static java.io.FileDescriptor.out;

/**
 * Created by Noa Agiv on 2/23/2017.
 */
public class DataCenter {
    public HashMap<Integer, Video> videos = new HashMap<Integer, Video>();
    public HashMap<Integer, Cache> caches = new HashMap<Integer, Cache>();
    public HashMap<Integer, Endpoint> endpoints = new HashMap<Integer, Endpoint>();

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

    public String outputSolution(){
        int numCaches = caches.size();
        String solution = Integer.toString(numCaches);
        Iterator it = caches.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            String line = pair.getKey().toString();
            Cache cache = (Cache) pair.getValue();
            for (Video video : cache.videos){
                line = line + " " + video.id;
            }
            solution = solution + "\n" + line;
            it.remove(); // avoids a ConcurrentModificationException
        }
        return solution;
    }

    public void outputSolution(String filePath) throws FileNotFoundException{
        BufferedWriter writer = null;
        try
        {
            writer = new BufferedWriter( new FileWriter(filePath));
            writer.write(outputSolution());

        }
        catch (IOException e)
        {
        }
        finally
        {
            try
            {
                if ( writer != null)
                    writer.close( );
            }
            catch ( IOException e)
            {
            }
        }
    }

//    public int calculateBestRoutLatency(Endpoint endpoint, Video video){
//        Iterator it = endpoint.cacheLatency.entrySet().iterator();
//        int minLatency = Integer.MAX_VALUE;
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry)it.next();
//            Cache cache = (Cache) pair.getKey();
//            int latency = (Integer) pair.getValue();
//            if (cache.isInCache(video.id) && latency < minLatency){
//                minLatency = latency;
//            }
//            it.remove(); // avoids a ConcurrentModificationException
//        }
//        return minLatency;
//    }
//
//    public void calculateScore(){
//        for (Endpoint e : endpoints.values()){
//            Iterator it = e.videoRequests.entrySet().iterator();
//            while (it.hasNext()) {
//                Map.Entry pair = (Map.Entry)it.next();
//                Video video = (Video) pair.getKey();
//                int requests = (Integer) pair.getValue();
//                int latency = calculateBestRoutLatency(e, video);
//                int worseLatency =  e.dataCenterLatency;
//                int latencyImprove =
//                it.remove(); // avoids a ConcurrentModificationException
//            }
//            return solution;
//        }
//    }
}
