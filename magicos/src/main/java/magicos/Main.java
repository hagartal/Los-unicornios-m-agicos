package magicos;

/**
 * Created by Noa Agiv on 2/19/2017.
 */
public class Main {

    public static void main(String[] args){
        Parser bestParserEver = new Parser();
        DataCenter bestDataCenterEver = bestParserEver.parse("me_at_the_zoo.in");
        Algorithm bestAlgEver = new Algorithm(bestDataCenterEver);
        bestAlgEver.run();
        try {
            bestDataCenterEver.outputSolution("me_at_the_zoo_output.txt");
        } catch (Exception E){
        }


        bestDataCenterEver = bestParserEver.parse("kittens.in");
        bestAlgEver = new Algorithm(bestDataCenterEver);
        bestAlgEver.run();
        try {
            bestDataCenterEver.outputSolution("kittens_output.txt");
        } catch (Exception E){
        }

        bestDataCenterEver = bestParserEver.parse("trending_today.in");
        bestAlgEver = new Algorithm(bestDataCenterEver);
        bestAlgEver.run();
        try {
            bestDataCenterEver.outputSolution("trending_today_output.txt");
        } catch (Exception E){
        }

        bestDataCenterEver = bestParserEver.parse("videos_worth_spreading.in");
        bestAlgEver = new Algorithm(bestDataCenterEver);
        bestAlgEver.run();
        try {
            bestDataCenterEver.outputSolution("videos_worth_spreading_output.txt");
        } catch (Exception E){
        }
    }

}
