import java.util.Random;

/*
Makes a voter that does not mark the ballot so that the simulation sees an empty ballot
 */

public class NonVoter implements VoterInt{

    @Override
    public void Voter() {

    }

    @Override
    //Goes through all the same steps as the Random voter, but does not use the mark method, so the ballot is empty
    public void vote(VotingMachine machine) {
        machine.getBallot();
        int MaxCand = machine.getBallot().countCandidates();
        //New random value
        Random rand = new Random();
        int voteFor = rand.nextInt(MaxCand);
        //Voting for the random value
        machine.cast(machine.getBallot());

    }
}
