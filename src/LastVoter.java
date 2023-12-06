import java.util.Random;
/*
Last voter always votes for the highest indexed candidaye
 */
public class LastVoter implements VoterInt{
    @Override
    public void Voter() {

    }

    @Override

    //counts the candidates to find the max Candidates
    public void vote(VotingMachine machine) {
        machine.getBallot();
        int MaxCand = machine.getBallot().countCandidates()-1;
        //Votes for the Max Cand
        machine.getBallot().mark(MaxCand, Ballot.VoteType.ClearMark);
        machine.cast(machine.getBallot());

    }
}
