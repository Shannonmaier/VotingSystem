/*
Interface that allows one to create various types of voters who will vote differently using the vote method
 */
public interface VoterInt {
    void Voter();

    /*
        The vote method goes through the process of a voter voting. Getting a ballot, picking a candidate to vote for, marking the ballot,
        and casting the voter.
         */
    void vote(VotingMachine machine);

}

