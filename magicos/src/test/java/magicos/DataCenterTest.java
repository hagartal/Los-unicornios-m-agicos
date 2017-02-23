package magicos; /**
 * Created by Noa Agiv on 2/19/2017.
 */
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DataCenterTest extends TestCase {

    DataCenter ds = new DataCenter();
    @Override
    protected void setUp() throws Exception{
        ds.addCache(0, 500);
        ds.addCache(1, 500);
        ds.getCache(0).addVideo(new Video(0, 20));
        ds.getCache(0).addVideo(new Video(1, 10));
        ds.getCache(1).addVideo(new Video(0, 20));
    }

    @Test
    public void testOutputString(){
        String solution = ds.outputSolution();
        Assert.assertEquals("2\n" +
                "0 0 1\n" +
                "1 0", solution);
    }

    @Test
    public void testOutputFile(){
        try {
            ds.outputSolution("testOutput.txt");
        }
        catch(Exception e){

        }
    }

}
