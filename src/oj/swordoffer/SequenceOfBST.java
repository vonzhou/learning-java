package oj.swordoffer;

public class SequenceOfBST {
	
	public boolean verifySequenceOfBST(int[] seq){
		return verifySequence(seq, 0, seq.length-1);
	}
	public boolean verifySequence(int[] seq, int from, int to){
		if(seq == null || seq.length <= 0)
			return false;
		int root = seq[to];
		int i=from;
		for(; i<to; i++){
			if(seq[i] > root)
				break;
		}
		
		// the remaining must not less than root
		int j = i;
		for(; j<to; j++){
			if(seq[j] < root)
				return false;   ///
		}
		
		boolean left = true;
		if(i > from )
			left = verifySequence(seq, from, i-1);
		
		boolean right = true;
		if(i < to)
			right = verifySequence(seq, i, to-1);
		
		return left && right ;
	}
	
	public static void main(String[] args) {
		SequenceOfBST t = new SequenceOfBST();
		int[] seq = {5,7,6,9,11,10,8};
		System.out.println(t.verifySequenceOfBST(seq));
	}

}
