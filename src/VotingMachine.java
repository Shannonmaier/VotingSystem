import java.util.Scanner;
import java.util.Random;

/*
The VotingMachine class is used to create new ballots for each voter that will vote for certain election using the methods
cast, configVotes, configure, determineWinner, determineMax, getBallot, reset, PrintFirstResults, getVoteCounts.
 */
public class VotingMachine {

    private Ballot configuredBallot;
    private int[] voteCounts;


    /*
    Cast uses iterations to go through the Ballot and check what is True in order to cast a vote for a certain candidate by adding 1
    to the voteCounts array.
     */
    public boolean cast(Ballot ballot) {
        int DiscardBallots= 0;
        int ballotCount = 0;

        //goes through the candidates and if the candidate has a ClearMark, it adds to the ballotCount
        for (int i = 0; i < ballot.countCandidates(); i++) {
            if (ballot.getCandidates()[i] == Ballot.VoteType.ClearMark) {
                ballotCount = ballotCount + 1;
            }
        }

        //if the ballotCount =1, it will go through the candidates again and check whihc one has the clear mark
        if (ballotCount == 1) {
            for (int z = 0; z < ballot.countCandidates(); z++) {
                if (ballot.getCandidates()[z] == Ballot.VoteType.ClearMark) {
                    //if there is a clear mark, it will add 1 vote to the voteCounts array for that candidate
                    voteCounts[z] = voteCounts[z] + 1;
                }
            }
            return true;
        }
        //if the ballotCount is  greater than 1, it looks for the clear mark
        else if (ballotCount > 1){
            for (int z = 0; z < ballot.countCandidates(); z++) {
                // only marks the clear mark candidate
                //for the DoubleVoter, will skip over the candidate that has a Faint Mark
                if (ballot.getCandidates()[z] == Ballot.VoteType.ClearMark) {
                    voteCounts[z] = voteCounts[z] + 1;
                } else {
                    continue;
                }

            }

            return true;
        }

        // if the ballot count is 0, meaning that there was no mark on the ballot, the first candidate will always be marked
        //therefore the first candidate will always be voted for when there is no mark on the ballot
        else if (ballotCount==0){
            voteCounts[0] = voteCounts[0] + 1;
            return true;

        }

        else {
            return false;
        }


    }


    /*
    ConfigVotes Configures a new voteCounts so that you can do it separately from the configure method
     */
    public void configVotes(int numCandidates){
        voteCounts = new int[numCandidates];

    }
    /*
    Configures an empty ballot for the Voting machine
     */
    public void configure(int numCandidates){
        configuredBallot = new Ballot(numCandidates);


    }
    /*
    determineWinner Determines the winner of the election based off of number of votes
     */
    public int determineWinner(){
        //Makes the original max the first value in the array as a placeholder
        int max = voteCounts[0];
        //Makes the index of the Max 0 as a placeholder
        int indexMax = 0;

        //goes through each value in the array and compares it to the last max value
        for (int i = 1; i < voteCounts.length; i++){
            //if the current value in iteration is larger than the max it changes the max value to that value
            if (voteCounts[i] > max) {
                max = voteCounts[i];
                //changes the index max too
                indexMax = i;

            }

        }
        //Returns the max index to the method as a whole
        return indexMax;

    }
    /*
    Determines the amount of votes that the winner has
     */
    public int determineMax(){
        //Makes the original max the first value in the array as a placeholder
        int max = voteCounts[0];
        //Makes the index of the Max 0 as a placeholder
        int indexMax = 0;

        //goes through each value in the array and compares it to the last max value
        for (int i = 1; i < voteCounts.length; i++){
            //if the current value in iteration is larger than the max it changes the max value to that value
            if (voteCounts[i] > max) {
                max = voteCounts[i];
                //changes the index max too
                indexMax = i;

            }

        }
        //Returns the max value to the method as a whole
        return max;

    }

    /*
    Returns the Ballot being used currently
     */
    public Ballot getBallot(){

        return this.configuredBallot;

    }

    /*
    Resets the voteCounts array so that no votes had been cast
     */
    public void reset(){
        for (int i = 1; i <  voteCounts.length; i++){
            voteCounts[i] = 0;
        }
    }
    /*
    Prints results
     */
    public void PrintFirstResults(){
        for (Integer i = 0; i < voteCounts.length; i++) {
            System.out.println("Candidate #" + (i+1) + ": " + voteCounts[i]);
        }

    }
    /*
    Returns the voteCounts array for use in future
     */
    public int[] getVoteCounts() {
        return voteCounts;
    }
}

