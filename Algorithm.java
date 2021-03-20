


//S[i][j] = { if j = 0 or i =0 then 0  | max{S[i-1][j] ; p[i] + S[i][j-1]} if i<=j | S[i-1][j] if i >j}

package com.test.fibonacci;

public class Algorithm {

	private int rLength;
	private int[][] solTable;
	private int[] price_amount;
	
	public Algorithm(int rLength, int[] price_amount) {
		this.rLength = rLength;
		this.price_amount = price_amount;
		this.solTable = new int[price_amount.length+1][rLength+1];
	}
	
	public void solveRodCutting() {		
		for(int i=1;i<price_amount.length;i++) {
			for(int j=1;j<rLength+1;j++) {
				if( i <= j ) {
					solTable[i][j] = Math.max(solTable[i-1][j], price_amount[i] + solTable[i][j-i]);
				} else {
					solTable[i][j] = solTable[i-1][j];
				}
			}
		}
	}
	
	public void display() {
		
		System.out.println("Optimal profit: $" + solTable[price_amount.length-1][rLength]);
		
		for(int rIndex=price_amount.length-1, cIndex=rLength;rIndex>0;) {
			if( solTable[rIndex][cIndex] != 0 && solTable[rIndex][cIndex] != solTable[rIndex-1][cIndex]) {
				System.out.println("We use piece: "+rIndex+"m");
				cIndex = cIndex - rIndex;
			} else {
				rIndex--;
			}
		}
	}
}
