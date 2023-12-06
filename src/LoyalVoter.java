/*
Creates a class from VoterInt that votes for a user specified candidate every time
 */

public class LoyalVoter implements VoterInt {
    //Creates the variable for what candidate the voter will be loyal to
    private int LoyalTo;

    //Establishes a constructor with a parameter that will equate to this Loyalto variable
    public void Voter(int Loy){
        LoyalTo = Loy;

    }
    @Override
    public void Voter() {

    }

    @Override
    public void vote(VotingMachine machine) {
        machine.getBallot();
        int MaxCand = machine.getBallot().countCandidates();
        //makes the candidate that will be voted for the Loyalto variable and votes for that candidate
        int voteFor = LoyalTo;
        machine.getBallot().mark(voteFor, Ballot.VoteType.ClearMark);
        machine.cast(machine.getBallot());


    }


}
