import java.util.Random;

/*
Creates a OddVoter class from the voterINt interface that votes for a random candidate chosen from the odd indexed candidates
 */

public class OddVoter implements VoterInt {
    @Override
    public void Voter() {

    }

    @Override
    public void vote(VotingMachine machine) {
        machine.getBallot();
        int topNum = machine.getBallot().countCandidates()-1;
        int oddNums[] = new int[topNum];
        //Adds the odd numbers from the candidates to a new array
        for (int i =0; i<topNum; i++){
            if (i%2 !=0){
                oddNums[i]=i;
            }
        }
        //Chooses a random candidate from the array just created and votes for them
        int voteFor = oddNums[new Random().nextInt(oddNums.length)];
        machine.getBallot().mark(voteFor, Ballot.VoteType.ClearMark);
        machine.cast(machine.getBallot());

    }
}

