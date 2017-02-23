package magicos;

/**
 * Created by Noa Agiv on 2/19/2017.
 */
public class Main {

    public static void main(String[] args){
        Parser bestParserEver = new Parser();
        DataCenter bestDataCenterEver = bestParserEver.parse("input_filename");
        Algorithm bestAlgEver = new Algorithm(bestDataCenterEver);
        bestAlgEver.run();
        try {
            bestDataCenterEver.outputSolution("output_filename");
        } catch (Exception E){
        }
    }

}
