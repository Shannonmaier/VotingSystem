import java.util.Random;

/*
Creates a class that implements VoterInt interface in order to vote for the even indexed candidates
 */

public class EvenVoter implements VoterInt{

    @Override
    public void Voter() {
    }

    @Override
    public void vote(VotingMachine machine) {
        machine.getBallot();
        //Makes an array of only the ven indexed values in the candidates from the Ballot
        int topNum = machine.getBallot().countCandidates()-1;
        int evenNums[] = new int[topNum];
        for (int i =0; i<topNum; i++){
            if (i%2 ==0){
                evenNums[i]=i;
            }
        }
        //gets a random value from this new array and votes for that value index
        int voteFor = evenNums[new Random().nextInt(evenNums.length)];
        machine.getBallot().mark(voteFor, Ballot.VoteType.ClearMark);
        machine.cast(machine.getBallot());


    }
}
