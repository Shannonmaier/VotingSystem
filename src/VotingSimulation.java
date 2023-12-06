import java.util.Scanner;
import java.util.Arrays;

/*
The VotingSimulation class uses the main method to iterate and go through rounds of voting based on user input
 */
public class VotingSimulation {

    public static void main(String[] args) {
        //Gets all user input
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the voting simulator");
        System.out.print("How many candidates do you want in your vote?");
        int candidate = in.nextInt();
        System.out.print("How many Random voters do you want ?");
        int Randvoter = in.nextInt();
        System.out.print("How many Loyal voters do you want ?");
        int LoyVoter = in.nextInt();
        System.out.print("What number candidate are the voters loyal to ?");
        int Loyto = in.nextInt();
        System.out.print("How many Odd voters do you want ?");
        int oddVoter = in.nextInt();
        System.out.print("How many Even voters do you want ?");
        int evenVoter = in.nextInt();
        System.out.print("How many Double voters do you want ?");
        int DoubVoter = in.nextInt();
        System.out.print("How many Last voters do you want ?");
        int lastVoter = in.nextInt();
        System.out.print("How many Non voters do you want ?");
        int nonVoter = in.nextInt();

        int quesBallots = 0;

        //creates a variable that adds together all the seperates types of voters to see how many total there are
        int OverallVoters = Randvoter + LoyVoter + oddVoter + evenVoter
                + DoubVoter + lastVoter + nonVoter;
        //variable for overall voters for the second round - does not include loyal voters or double voters
        int SecOverallVoters = Randvoter + oddVoter + evenVoter
                + DoubVoter + lastVoter + nonVoter;


        System.out.print("How many times do you want to run the simulation ?");
        int run = in.nextInt();

        //iterates through how many times the user wants to run the simulation
        for (int x = 0; x < run; x++) {
            VotingMachine Machine = new VotingMachine();
            //Creates the voteCount array
            Machine.configVotes(candidate);
            //iterates through all of the random voters
            for (int i = 0; i < Randvoter; i++) {
                //Configures a new ballot for the voting machine
                Machine.configure(candidate);
                //New voter
                RandomVoter voterX = new RandomVoter();
                //The new voter now votes
                voterX.vote(Machine);
            }

            //iterates through all the Loyal voters
            for (int i = 0; i < LoyVoter; i++) {
                Machine.configure(candidate);
                //New voter
                LoyalVoter voterX = new LoyalVoter();
                //
                voterX.Voter(Loyto-1);
                //The new voter now votes
                voterX.vote(Machine);

            }
            //iterates through all of the odd voters
            for (int i = 0; i < oddVoter; i++) {
                Machine.configure(candidate);
                //New voter
                OddVoter voterX = new OddVoter();
                //The new voter now votes
                voterX.vote(Machine);

            }

            //iterates through all of the even voters
            for (int i = 0; i < evenVoter; i++) {
                Machine.configure(candidate);
                //New voter
                OddVoter voterX = new OddVoter();
                //The new voter now votes
                voterX.vote(Machine);
            }
            //creates a variable for the ballots that might be discarded
            quesBallots= 0;
            //iterates through all of the double votes
            for (int i = 0; i < DoubVoter; i++) {
                Machine.configure(candidate);
                //New voter
                DoubleVoter voterX = new DoubleVoter();
                //The new voter now votes
                voterX.vote(Machine);
                //adds every double voter ballot to the discarded ballot count
                quesBallots = quesBallots + 1;

            }
            //iterates through all of the last voters
            for (int i = 0; i < lastVoter; i++) {
                Machine.configure(candidate);
                //New voter
                LastVoter voterX = new LastVoter();
                //The new voter now votes
                voterX.vote(Machine);

            }

            //iterates through the NonVoters
            for (int i = 0; i < nonVoter; i++) {
                Machine.configure(candidate);
                //New voter
                NonVoter voterX = new NonVoter();
                //The new voter now votes
                voterX.vote(Machine);

                quesBallots = quesBallots + 1;
            }

            int FirstMax = Machine.determineMax();
            //Prints the results fo first round
            Machine.PrintFirstResults();
            //Checks if only one round was needed based on the 50% value of thev oters
            if (FirstMax > OverallVoters / 2) {
                System.out.println("There is a winner from the first Round: " + Machine.determineWinner() + ": " + FirstMax);
                //prints the number of discarded ballots
                System.out.println("Questionable ballots: " + quesBallots);

            } else {
                //Tells the user that a second round is needed
                System.out.println("Need a Second Round: No Candidate had more than 50% of votes");
                System.out.println("Leader in Round 1:" + "Candidate #" + (Machine.determineWinner() + 1));
                System.out.println("Questionable ballots: " + quesBallots);


                Machine.getVoteCounts();
                //copies the voter counts into a new array to save the order and numbers
                int OldVotes[] = new int[Machine.getVoteCounts().length];
                for (int e = 0; e < Machine.getVoteCounts().length; e++) {
                    OldVotes[e] = Machine.getVoteCounts()[e];
                }
                //Sorts the VoteCounts lowest to highest
                java.util.Arrays.sort(Machine.getVoteCounts());
                //Finds the winner vote count and Runner-up vote count from the first round based off the sorted array
                int OriginalWinnerAmount = Machine.getVoteCounts()[Machine.getVoteCounts().length-1];
                int OriginalRunnerUpAmount = Machine.getVoteCounts()[Machine.getVoteCounts().length-2];

                //creates variable for the winner index
                int OriginalWinner = 0 ;
                int OriginalRunnerUp = 0;

                //goes through the Oldvotes to check against the amounts just recorded for the winner index
                for (int z =0; z<OldVotes.length; z++){
                    if (OldVotes[z]== OriginalWinnerAmount){
                        OriginalWinner = z+1;
                        break;
                    }
                }
                //finds the runner up index and assigns to variable
                for (int p = 0; p< OldVotes.length; p ++) {
                    if (OldVotes[p] == OriginalRunnerUpAmount) {
                        OriginalRunnerUp = p + 1;

                    }
                }






                //Resets the Machine
                Machine.reset();
                //Configure with two candidates for second round
                Machine.configVotes(2);
                //Iterates through the voters and votes for Second round

                //Start of re going through all of the voters

                for (int i = 0; i < Randvoter; i++) {
                    //Configures a new ballot for the voting machine
                    Machine.configure(2);
                    //New voter
                    RandomVoter voterX = new RandomVoter();
                    //The new voter now votes
                    voterX.vote(Machine);

                }
                //checks if the Loyal Voters candidate is still in the running
                //if it is, then votes for them again

                if ((Loyto +1) == OriginalWinner){
                    for (int i = 0; i < LoyVoter; i++) {
                        Machine.configure(2);
                        //New voter
                        LoyalVoter voterX = new LoyalVoter();
                        voterX.Voter(0);
                        //The new voter now votes
                        voterX.vote(Machine);

                        SecOverallVoters = Randvoter + LoyVoter+ oddVoter + evenVoter
                                + lastVoter;
                    }
                }
                //checks if the Loyal Voters candidate is still in the running
                //if it is, then votes for them again

                else if((Loyto +1) == OriginalRunnerUp) {
                    for (int i = 0; i < LoyVoter; i++) {
                        Machine.configure(2);
                        //New voter
                        LoyalVoter voterX = new LoyalVoter();
                        voterX.Voter(1);
                        //The new voter now votes
                        voterX.vote(Machine);

                        SecOverallVoters = Randvoter + LoyVoter+ oddVoter + evenVoter
                                + lastVoter;

                    }
                }


                for (int i = 0; i < oddVoter; i++) {
                    Machine.configure(2);
                    //New voter
                    OddVoter voterX = new OddVoter();
                    //The new voter now votes
                    voterX.vote(Machine);
                }

                for (int i = 0; i < evenVoter; i++) {
                    Machine.configure(2);
                    //New voter
                    OddVoter voterX = new OddVoter();
                    //The new voter now votes
                    voterX.vote(Machine);
                }

                for (int i = 0; i < lastVoter; i++) {
                    Machine.configure(2);
                    //New voter
                    LastVoter voterX = new LastVoter();
                    //The new voter now votes
                    voterX.vote(Machine);

                }

                for (int i = 0; i < nonVoter; i++) {
                    Machine.configure(candidate);
                    //New voter
                    NonVoter voterX = new NonVoter();
                    //The new voter now votes
                    voterX.vote(Machine);

                    quesBallots = quesBallots + 1;
                }

                //Prints results
                if (Machine.determineWinner() == 0) {
                    System.out.println("Winner: Candidate #" + OriginalWinner + ":" + Machine.determineMax() + " Votes");
                    System.out.println("Runner UP: Candidate #" + OriginalRunnerUp + ":" + (SecOverallVoters - Machine.determineMax()) + " Votes");
                } else {
                    System.out.println("Winner: Candidate #" + OriginalRunnerUp + ":" + Machine.determineMax() + " Votes");
                    System.out.println("Runner UP: Candidate #" + OriginalWinner + ":" + (SecOverallVoters - Machine.determineMax()) + " Votes");


                }

                //Formatting
                System.out.println("----------------------------------------------");
                System.out.println("                                 ");
                System.out.println("                                     ");



            }


        }

    }

}

