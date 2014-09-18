//Aaron Pycraft
//AAPYC1@gmail.com
// http://www.linkedin.com/pub/aaron-pycraft/93/486/610/
//5-22-14
//Dice Programming Challenge; Resource Trading
//http://news.dice.com/2014/05/05/mays-programming-challenge-resource-trading/

//import java.io.*;
//import java.util.Scanner;
//import java.util.Arrays;
//import java.*;

class ResourceTrading {
	//Data Fields
	public static char[][] originalMap = new char[20][20];
	public static char[][] map = new char[20][20];
	public static String[] islandData = new String[20];
	public static int[] boatLocation = {0,0};
	public static int boat_Row=0;
	public static int boat_Col=0;
	public static int numberOfMoves=0;
	public static int boatCash=10000;
	public static int boatGold=0;
	public static int boatIron=0;
	public static int boatWood=0;
	public static int numberOfIslandsVisited=0;
	public static String boatPath="";
	
	//Methods
	public static void PrintMap() {
		for(int k=0;k<20;k++) {
			System.out.println(map[k]);	
		}
		ResetMap();
	}
	
	public static void ResetMap() {
		for(int i=0;i<20;i++) {
			for(int k=0;k<20;k++) {
			map[i][k]=originalMap[i][k];
			}
		}
		map[boat_Row][boat_Col]='@';
	}
	
	//step methods. Move in direction one space.
	//TODO: fix this methods to follow SailEast() /*
	public static void SailNorth() {
		if(boat_Row-1<0) 
				return;
		if(map[boat_Row-1][boat_Col]=='~' || map[boat_Row-1][boat_Col]=='^') {
			map[boat_Row][boat_Col]='^';
			boat_Row--;
			map[boat_Row][boat_Col]='@';
			numberOfMoves++;
			boatPath+=1;
		}
	}//end sail N
	public static void SailNorthEast() {
		if(boat_Col+1>19 || boat_Row-1<0) 
			return;
		if(map[-1+boat_Row][1+boat_Col]=='~' || map[boat_Row-1][boat_Col+1]=='^') {
			map[boat_Row][boat_Col]='^';
			boat_Col++;
			boat_Row--;
			map[boat_Row][boat_Col]='@';
			numberOfMoves++;
			boatPath+=2;
		}	
	}
	public static void SailEast() {
		if(boat_Col+1>19) 
				return;
		if(map[boat_Row][boat_Col+1]=='~' || map[boat_Row][boat_Col+1]=='^') {
			map[boat_Row][boat_Col]='^';
			boat_Col++;
			map[boat_Row][boat_Col]='@';
			numberOfMoves++;
			boatPath+=3;
		}
		return;
	}
	public static void SailSouthEast() {
		if(boat_Col+1>19 || boat_Row+1>19) 
			return;
		if(map[1+boat_Row][1+boat_Col]=='~' || map[boat_Row+1][boat_Col+1]=='^') {
			map[boat_Row][boat_Col]='^';
			System.out.println(map[boat_Row][boat_Col]=='^');
			boat_Col++;
			boat_Row++;
			map[boat_Row][boat_Col]='@';
			numberOfMoves++;
			boatPath+=4;
		}
	}
	public static void SailSouth() {
		if(boat_Row+1>19) 
				return;
		if(map[boat_Row+1][boat_Col]=='~' || map[boat_Row+1][boat_Col]=='^') {
			map[boat_Row][boat_Col]='^';
			boat_Row++;
			map[boat_Row][boat_Col]='@';
			numberOfMoves++;
			boatPath+=5;
		}
		return;
	}
	public static void SailSouthWest() {
		if(boat_Col-1<0 || boat_Row+1>19) 
				return;
			if(map[boat_Row+1][boat_Col-1]=='~' || map[boat_Row+1][boat_Col-1]=='^') {
				map[boat_Row][boat_Col]='^';
				boat_Col--;
				boat_Row++;
				map[boat_Row][boat_Col]='@';
				numberOfMoves++;
				boatPath+=6;
			}
	}
	public static void SailWest() {
		if(boat_Col-1<0) 
				return;
		if(map[boat_Row][boat_Col-1]=='~' || map[boat_Row][boat_Col-1]=='^') {
			map[boat_Row][boat_Col]='^';
			boat_Col--;
			map[boat_Row][boat_Col]='@';
			numberOfMoves++;
			boatPath+=7;
		}
		return;
	} 
	public static void SailNorthWest() {
		if(boat_Row-1<0 || boat_Col-1<0) 
				return;
			if(map[boat_Row-1][boat_Col-1]=='~' || map[boat_Row-1][boat_Col-1]=='^') {
				map[boat_Row][boat_Col]='^';
				boat_Col--;
				boat_Row--;
				map[boat_Row][boat_Col]='@';
				numberOfMoves++;
				boatPath+=8;
			}
	}
	
	//slide methods. Move in direction as much as possible
	/*public static void SlideRight() {
		do {
			map[boat_Row][boat_Col]='^';
			boat_Col++;
			if(boat_Col>19)
				return;
			map[boat_Row][boat_Col]='@';
			numberOfMoves++;
		} while(map[boat_Row][boat_Col+1] == '~');
		PrintMap();
		PrintTransaction();
	} */
	/*public static void SlideLeft() {
		do {
			map[boat_Row][boat_Col]='^';
			boat_Col--;
			if(boat_Col<0)
				return;
			map[boat_Row][boat_Col]='@';
			numberOfMoves++;
		} while(map[boat_Row][boat_Col-1] == '~');
		PrintMap();
		PrintTransaction();
	}*/
	/*public static void SlideDown() {
		do {
			map[boat_Row][boat_Col]='^';
			boat_Row--;
			if(boat_Row>19)
				return;
			map[boat_Row][boat_Col]='@';
			numberOfMoves++;
		} while(map[boat_Row+1][boat_Col] == '~');
		PrintMap();
		PrintTransaction();
	} */
	/*public static void SlideUp() {
		do {
			map[boat_Row][boat_Col]='^';
			boat_Row--;
			if(boat_Row>19)
				return;
			map[boat_Row][boat_Col]='@';
			numberOfMoves++;
		} while(map[boat_Row-1][boat_Col] == '~');
		PrintMap();
		PrintTransaction();
	} */
	// TODO: fix infinite loop 
	public static void SailTo(Island island) {
		int island_Row=island.getIslandCoordinate_Row();
		int island_Col=island.getIslandCoordinate_Column();
		
		System.out.println("island " + island.islandLetter + " coordinates are: " + island_Row + " " + island_Col + "" 
			+ " ... boat coordinates are: "+boat_Row + " " + boat_Col);
			//TODO determine how to move between islands
			{
			//	SailNorth();
				
			//	SailNorthEast();
				
			//	SailEast();
				
			//	SailSouthEast();
				
			//	SailSouth();
				
			//	SailSouthWest();
			//	SailWest();
				
				
			//	SailNorthWest();
			}
		System.out.println(" the boat is now at "+boat_Row +" "+boat_Col+". Moves: "+numberOfMoves+". Path: "+boatPath);
		boatPath="";
		PrintMap();
	}
	public static void PlanVoyage(Island[] islandArray) {
		Island islandOfMaxProfit=new Island();
		//determine best island to travel to
		for(int i=0;i<20;i++) {
			try{
				if(islandArray[i+1].getPotentialProfit() > islandArray[i].getPotentialProfit() ) {
					islandOfMaxProfit=islandArray[i+1];
			}	}
			catch(ArrayIndexOutOfBoundsException e) { continue; }
		}
		//go there
		islandOfMaxProfit=islandArray[0]; //temp set to island A
		SailTo(islandOfMaxProfit);
	}
	public static void main(String[] args) {	
		//establish file for the input
			java.io.File sampleInputFile = new java.io.File("input.txt");
			java.io.File voyageOutputFile = new java.io.File("voyage.txt");
			Scanner fileReader;
			try {
				fileReader=new Scanner(sampleInputFile);
				java.io.PrintWriter fileWriter = new java.io.PrintWriter(voyageOutputFile);
			 
				//input map using a file input reader
				for (int i=0;i<20;i++) {
					map[i]=fileReader.next().toCharArray();
					fileReader.nextLine();
				}
				//fileReader.useDelimiter(",");
				for(int l=0;l<20;l++) {
					islandData[l]=fileReader.nextLine();
					//System.out.println(islandData[l]+" ");
				}	
			
				//make copy of original map for reference
				for(int j=0;j<20;j++) {
					originalMap[j]=Arrays.copyOf(map[j],map[j].length);
				}
				map[boat_Row][boat_Col]='@';
				System.out.println("The voyage begins...");
				PrintMap();
				
			
	
		/*create all island objects*/ 
			Island A = new Island(0);
			Island B = new Island(1);
			Island C = new Island(2);
			Island D = new Island(3);
			Island E = new Island(4);
			Island F = new Island(5);
			Island G = new Island(6);
			Island H = new Island(7);
			Island I = new Island(8);
			Island J = new Island(9);
			Island K = new Island(10);
			Island L = new Island(11);
			Island M = new Island(12);
			Island N = new Island(13);
			Island O = new Island(14);
			Island P = new Island(15);
			Island Q = new Island(16);
			Island R = new Island(17);
			Island S = new Island(18);
			Island T = new Island(19);
			Island[] islandArray={A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T};
			/*while(numberOfMoves<1000)*/ {
				PlanVoyage(islandArray);

		
				//TODO:eventually write transactions to output file
					//System.out.println(A.Buy(50,50,50));
					//System.out.println(T.Sell(50,50,50));
					
			}
		}//end try...
			catch(FileNotFoundException e) { System.out.println("file not found exception, lol"); }	
	}//end main
	/*public static Island getNearestIsland() {
		//TODO: the closest island will be the island with the fewest number of moves
	}*/

}//end ResourceTrading class


class Island extends ResourceTrading { 
	//Data Fields
	private int islandNumber;
	public char islandLetter;
	private int goldPrice=0;
	private int woodPrice=0;
	private int ironPrice=0;
	private int[] islandCoordinates=new int[2];

	//methods
	public int getGoldPrice() {	return goldPrice; }
	public int getWoodPrice() {	return woodPrice; }
	public int getIronPrice() {	return ironPrice; }
	//public char getIslandLetter() { return islandLetter; }
	public String Buy(int quantityOfGold, int quantityOfWood, int quantityOfIron) {
		int totalCost=(quantityOfGold*goldPrice)+(quantityOfWood*woodPrice)+(quantityOfIron*ironPrice);
		boatCash-=totalCost;
		//System.out.println("Buy "+quantityOfGold+"/"+quantityOfWood+"/"+quantityOfIron
		//	+ " at "+goldPrice+"/"+woodPrice+"/"+ironPrice+" costing $"+totalCost+" leaves $"+boatCash);
		return new String("Buy "+quantityOfGold+"/"+quantityOfWood+"/"+quantityOfIron
			+ " at "+goldPrice+"/"+woodPrice+"/"+ironPrice+" costing $"+totalCost+" leaves $"+boatCash);
	}
	public String Sell(int quantityOfGold, int quantityOfWood, int quantityOfIron) {
		int totalProfit=(quantityOfGold*goldPrice)+(quantityOfWood*woodPrice)+(quantityOfIron*ironPrice);
		boatCash+=totalProfit;
		//System.out.println("Sell "+quantityOfGold+"/"+quantityOfWood+"/"+quantityOfIron
		//	+ " at "+goldPrice+"/"+woodPrice+"/"+ironPrice+" earning $"+totalProfit+" leaves $"+boatCash);
		return new String("Sell "+quantityOfGold+"/"+quantityOfWood+"/"+quantityOfIron
			+ " at "+goldPrice+"/"+woodPrice+"/"+ironPrice+" earning $"+totalProfit+" leaves $"+boatCash);
	}
	public int getPotentialProfit() {
		/* 		This method will be used to determine the next destination, based on profit from trip
		* profit=sell$ -buy$ - move cost. We want a large sell$, a small buy$, and a small move cost.
		*		
		*/
		int sellProfit=0;
		int buyCost=0;	//the cost to fill the rest of the boat's inventory
		int moveCost=0;
		int profit=sellProfit-buyCost-moveCost;
		
		return profit;
	}
	/*public int getDistance() {
		return -1;
	}//getDistance method */
	public void findIslandCoordinates() {
		int i=0,j=0;
		/*islandLetter='?';
		switch (islandNumber) {
            case  1:  islandLetter = 'A'; break;
			case  2:  islandLetter = 'B'; break;
			case  3:  islandLetter = 'C'; break;
			case  4:  islandLetter = 'D'; break;
			case  5:  islandLetter = 'E'; break;
			case  6:  islandLetter = 'F'; break;
			case  7:  islandLetter = 'G'; break;
			case  8:  islandLetter = 'H'; break;
			case  9:  islandLetter = 'I'; break;
			case 10:  islandLetter = 'J'; break;
			case 11:  islandLetter = 'K'; break;
			case 12:  islandLetter = 'L'; break;
			case 13:  islandLetter = 'M'; break;
			case 14:  islandLetter = 'N'; break;
			case 15:  islandLetter = 'O'; break;
			case 16:  islandLetter = 'P'; break;
			case 17:  islandLetter = 'Q'; break;
			case 18:  islandLetter = 'R'; break;
			case 19:  islandLetter = 'S'; break;
			case 20:  islandLetter = 'T'; break;
		}*/	
		while(true) {
			if(map[i][j]==islandLetter) {
				islandCoordinates[0]=i;
				islandCoordinates[1]=j;
				//System.out.println("island "+islandLetter+" coordinates are : "+islandCoordinates[0]+" and "+islandCoordinates[1]);
				return;
			} 
			i++;
			if(i>19) { i=0;  j++; }//end if...		
		}//end while... loop
	}//end findIslandCoordinates method
	public int getIslandCoordinate_Row() { return islandCoordinates[0]; }
	public int getIslandCoordinate_Column() { return islandCoordinates[1]; }
	
	//constructor for island
	public Island() {;}
	public Island(int letterIndex) {
		//Set prices from input file
		{	
			//get index locations of the commas
				int[] commaLocation=new int[3];
				int i=0, j=0;
				do{
					if(islandData[letterIndex].charAt(j)==',') {
						commaLocation[i]=j;
						i++;
					}
					j++;
				} while(commaLocation[2]==0);
				//System.out.println("commas are at: "+commaLocation[0]+" "+commaLocation[1]+" "+commaLocation[2]);
			
			//anything between these commas are numbers
				islandNumber=Integer.parseInt(islandData[letterIndex].substring(0,commaLocation[0]));
				goldPrice=Integer.parseInt(islandData[letterIndex].substring(commaLocation[0]+1,commaLocation[1]));
				ironPrice=Integer.parseInt(islandData[letterIndex].substring(commaLocation[1]+1,commaLocation[2]));
				woodPrice=Integer.parseInt(islandData[letterIndex].substring(commaLocation[2]+1));
				//System.out.println(islandNumber+" "+goldPrice+" "+ironPrice+" "+woodPrice);
		}
		//get letter of island
		islandLetter='?';
		switch (islandNumber) {
            case  1:  islandLetter = 'A'; break;
			case  2:  islandLetter = 'B'; break;
			case  3:  islandLetter = 'C'; break;
			case  4:  islandLetter = 'D'; break;
			case  5:  islandLetter = 'E'; break;
			case  6:  islandLetter = 'F'; break;
			case  7:  islandLetter = 'G'; break;
			case  8:  islandLetter = 'H'; break;
			case  9:  islandLetter = 'I'; break;
			case 10:  islandLetter = 'J'; break;
			case 11:  islandLetter = 'K'; break;
			case 12:  islandLetter = 'L'; break;
			case 13:  islandLetter = 'M'; break;
			case 14:  islandLetter = 'N'; break;
			case 15:  islandLetter = 'O'; break;
			case 16:  islandLetter = 'P'; break;
			case 17:  islandLetter = 'Q'; break;
			case 18:  islandLetter = 'R'; break;
			case 19:  islandLetter = 'S'; break;
			case 20:  islandLetter = 'T'; break;
		}
		//get location of island
		findIslandCoordinates();
		
	}//island constructor

}//end island class
