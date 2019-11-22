import java.lang.IndexOutOfBoundsException;
import java.util.Arrays;


public class FindJudge{


public static final int CANT_FIND = -1;

	//{{1, 2}, {2,1}, {1,3}, {2,3}}
	//Trust is allocated by (0, 1) indexes 
	public static int findJudge(int N, int[][] trust) throws IndexOutOfBoundsException{

		//Error case
		if((N < 1 )|| (N > 1000))
			throw new IndexOutOfBoundsException("Values cannot be less than 1 or greater than 1,000 \n");

      int[] trusted = new int[N+1];

        for (int[] t: trust) {

        	System.out.println(Arrays.toString(t) + "\n");
            System.out.println(Arrays.toString(trusted));
            //If a trusts b, then zero can't be judge, so -- it's value in our trusted array of vertices  	
            trusted[t[0]]--;

            //on the other hand, trust is allocated to the second value in the pair... so ++ it's value in our trusted array of vertices 
            trusted[t[1]]++;
           
        }

             for (int i = 1; i <= N; ++i) {

             //If judge is trusted, then judge's value will be N-1 since he recieved incrementation from every other vertex and no -- since judge doesn't trust anyone; ie will never be at 0th index 
            if (trusted[i] == N - 1)
             return i;
        }
        return CANT_FIND;
    }

	public static void main(String[] args){

			System.out.println(findJudge(4, new int[][]{{1, 2}, {1, 3}, {2, 1}, {2, 3}, {1, 4}, {4, 3}, {4, 1}}));


		}
}


