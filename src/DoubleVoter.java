import java.util.Random;

/*
Implements the voterInt in order to create a voter that randomly votes for two candidates - this will be discarded in the Voting Simulation
 */
public class DoubleVoter implements VoterInt{
    @Override
    public void Voter() {
    }

    @Override
    public void vote(VotingMachine machine) {
        //Votes for the first candidate randomly from all the choices
        machine.getBallot();
        int MaxCand = machine.getBallot().countCandidates();
        Random rand = new Random();
        int voteFor1 = rand.nextInt(MaxCand);
        machine.getBallot().mark(voteFor1, Ballot.VoteType.ClearMark);

        //creates a new array without the candidate that was voted for first
        int votes[] = new int[machine.getBallot().countCandidates()];
        for (int e = 0; e < machine.getBallot().countCandidates(); e++) {
            if (e == voteFor1) {
                continue;
            } else {
                votes[e] = e;
            }
        }
        //creates a votefor2 using a Random value from the new array and votes for that candidate
        int voteFor2 = votes[new Random().nextInt(votes.length)];
        machine.getBallot().mark(voteFor2, Ballot.VoteType.FaintMark);
        machine.cast(machine.getBallot());



    }
}
