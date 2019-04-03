//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack
{
	//add in Player instance variable
        private Player player;
	//add in Dealer instance variable
        private Dealer dealer;
	public BlackJack()
	{
            player = new Player();
            dealer = new Dealer();

	}
        public void printWins(){
            System.out.println("Dealer has won " + dealer.getWinCount() + "times");
            System.out.println("Player has won " + player.getWinCount() + "times");
        }
	public void playGame()
	{
                dealer.shuffle();
                player.resetHand();
                dealer.resetHand();
		Scanner keyboard = new Scanner(System.in);
		String choice = "";
                player.addCardToHand(dealer.deal());
                dealer.addCardToHand(dealer.deal());
                player.addCardToHand(dealer.deal());
                dealer.addCardToHand(dealer.deal());
                System.out.println(player);
                choice = keyboard.nextLine();
                while(player.getHandValue() <= 21 && choice.equals("hit") ){
                    player.addCardToHand(dealer.deal());
                    System.out.println(player);
                    if(player.getHandValue() > 21){
                        break;
                    }
                    choice = keyboard.nextLine();
                    player.getHandValue();
                }
                if(player.getHandValue() > 21){
                    dealer.setWinCount(dealer.getWinCount() + 1);
                    System.out.println("Player: " + player); System.out.println("Dealer: " + dealer);
                    System.out.println("Dealer wins! - Player busted");
                    return;
                }
                while(dealer.hit()){
                    dealer.addCardToHand(dealer.deal());
                }
                if(dealer.getHandValue() > 21){
                    player.setWinCount(player.getWinCount() + 1);
                    System.out.println("Player: " + player); System.out.println("Dealer: " + dealer);
                    System.out.println("Player wins! - Dealer busted");
                    return;
                }
                System.out.println("Player: " + player); System.out.println("Dealer: " + dealer);
                if(player.getHandValue() > dealer.getHandValue()){
                    player.setWinCount(player.getWinCount() + 1);
                    System.out.println("Player wins!");
                    return;
                }
                if(player.getHandValue() < dealer.getHandValue()){
                    dealer.setWinCount(dealer.getWinCount() + 1);
                    System.out.println("Player wins!");
                    return;
                }
                System.out.println("Tie!");
	}
	
	public static void main(String[] args)
	{
		BlackJack game = new BlackJack();
		game.playGame();
                game.printWins();
                String choice = "";
                System.out.println("Play again? [Y, N]");
                Scanner kb = new Scanner(System.in);
                choice = kb.nextLine();
                while(choice.equals("Y")){
                    game.playGame();
                    game.printWins();
                    System.out.println("Play again? [Y, N]");
                    choice = kb.nextLine();
                }
	}
}