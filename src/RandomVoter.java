import java.util.Random;

/*
The RandomVoter Class creates a Random voter to use the voting machine
A random voter is one that chooses randomly from all the candidates with no preferences
Implements the VoterInt Interface
 */

public class RandomVoter implements VoterInt {


    @Override
    public void Voter(){


    }
    /*
    The vote method goes through the process of a voter voting. Getting a ballot, picking a candidate to voting for using Random, marking the ballot,
    and casting the voter.
     */
    @Override
    public void vote(VotingMachine machine){
        machine.getBallot();
        int MaxCand = machine.getBallot().countCandidates();
        //New random value
        Random rand = new Random();
        int voteFor = rand.nextInt(MaxCand);
        //Voting for the random value
        machine.getBallot().mark(voteFor, Ballot.VoteType.ClearMark);
        machine.cast(machine.getBallot());



    }
}
