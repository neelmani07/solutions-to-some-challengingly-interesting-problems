/*
Coin game:  Alice and Bob are playing a game
using a bunch of coins.  The players pick several coins out of the
bunch in turn.  Each time a player is allowed to pick 1, 2 or 4 coins,
and the player that gets the last coin is the winner.  Assume that
both  players  are  very  smart  and  he/she  will  try  his/her  best  to
work out a strategy to win the game.  For example, if there are 2
coins and Alice is the  rst player to pick, she will de nitely pick 2
coins and win.  If there are 3 coins and Alice is still the  rst player
to pick, no matter she picks 1 or 2 coins, Bob will get the last coin
and  win  the  game.   Given  the  number  of  coins  and  the  order  of
players (which means the  rst and the second players to pick the
coins), you are required to write a program to calculate the winner
of the game, and calculate how many di erent strategies there are
for  he/she  to  win  the  game.   You  should  use  recursion  to  solve
the problem, and the parameters are read from the command line.
You can assume that there are no more than 30 coin  */
import java.util.*;
import java.lang.*;
class PickLastCoinToWin
{
	public static int depictWinner(int n, int playerNumber)
	{
		int opponentNumber=Math.abs(playerNumber-1);
		//System.out.println(opponentNumber);
		int winNumber=9;
		if(n<5)
		{
			if(n==1 || n==2 || n==4)
				winNumber= playerNumber;
			else if(n==3)
				winNumber= opponentNumber;
				
		}		
		else
		{	
			if(depictWinner(n-1,opponentNumber)==playerNumber)
				winNumber= playerNumber;
			else if(depictWinner(n-2,opponentNumber)==playerNumber)
				winNumber= playerNumber;
			else if(depictWinner(n-4,opponentNumber)==playerNumber)
				winNumber= playerNumber;
			else
				winNumber=opponentNumber;
		}
		//System.out.println(winNumber);
		return winNumber;
	
	}
	public static void main(String arg[])
	{	
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the numbers of coins");
		int nOfCoins=sc.nextInt();
		System.out.println("enter the name of two players");
		String p1=sc.next();
		String p2=sc.next();
		//System.out.println(p1);
		//System.out.println(p2);
		//reprsentin p1 by 0 and p2 by 1
		int winNumber=depictWinner(nOfCoins,0);
		if(winNumber==0)
			System.out.println("winner is \t" +p1);
		else
			System.out.println("winner is \t" +p2);
		
	}
}
