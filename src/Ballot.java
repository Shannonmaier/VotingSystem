import java.util.Scanner;
import java.util.Arrays;
/*
The Ballot class creates a Ballot that will be used to provide the voting machine with a template to vote on. The class
has a constructor,"Ballot," and three other methods, mark(), countCandidates(), and getCandidates().
 */
public class Ballot {

    //makes an enum for the types of marks that can be put on the ballot


    enum VoteType {NoMark, FaintMark, ClearMark}

    //makes the array of candidates an array of these enums VoteType
    private VoteType[] candidates;


    /*
    Constructor method that creates an array based on the number of candidates inputted. The array is a VoteType array
    that will be set initially to all NoMark
     */
    public Ballot(int numCandidates){
        candidates = new VoteType[numCandidates];
        for (int i = 0; i < candidates.length; i++) {
            candidates[i] = VoteType.NoMark;
        }
    }
    /*
    The mark method will set whatever index put in the parameter, to the type of mark that is also put in the parameter.
     */
    public void mark(int index, VoteType mark ){
        candidates[index] = mark;

    }
    /*
    The countCandidates method returns the length of the candidates array that was declared in the beginning of the class
    in order to find the number of candidates.
     */
    public int countCandidates(){
        return candidates.length;

    }
    /*
    The getCandidates method return the candidates array to the method for use later in the program.
     */
    public VoteType[] getCandidates(){
        return candidates;
    }




}


