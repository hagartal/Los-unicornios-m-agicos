package magicos;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Shimrit on 23-Feb-17.
 */
public class Parser {
    public DataCenter parse(String fileName){
        DataCenter dc = new DataCenter();
        Scanner sc = null;
        try {
            File file = new File(fileName);
            sc = new Scanner(file);
            String[] settings = sc.nextLine().split(" ");
            int numOfVideos = Integer.valueOf(settings[0]);
            int numOfEp =  Integer.valueOf(settings[1]);
            int numOfReqDes =  Integer.valueOf(settings[2]);
            int numOfCache =  Integer.valueOf(settings[3]);
            int sizeOfCache =  Integer.valueOf(settings[4]);

            for (int i = 0 ; i < numOfCache; i++){
                dc.addCache(i, sizeOfCache);
            }
            String[] line;
            for(int i = 0; i<numOfVideos; i++) {
                dc.addVideo(i, Integer.valueOf(sc.next()));
            }
            sc.nextLine();
            for(int i = 0; i<numOfEp; i++) {
                line = sc.nextLine().split(" ");
                dc.addEndpoint(i, Integer.valueOf(line[0]));
                int numOfEpCache = Integer.valueOf(line[1]);
                for(int j =0; j<numOfEpCache; j++) {
                    line = sc.nextLine().split(" ");
                    dc.getEndPoint(i).addCacheLatency(
                            dc.getCache(Integer.valueOf(line[0])),
                            Integer.valueOf(line[1]));
                }
            }
            for(int i = 0; i<numOfCache; i++) {
                dc.addCache(i, sizeOfCache);
            }
            for(int i = 0; i<numOfReqDes; i++) {
                line = sc.nextLine().split(" ");
                dc.getEndPoint(Integer.valueOf(line[1])).addVideoRequest(dc.getVideo(Integer.valueOf(line[0])), Integer.valueOf(line[2]));
            }
            return dc;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
