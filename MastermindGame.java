// The game of Mastermind, made for Java by 
// James Butcher  
// Version 1.0 
// September 15, 2013 
  
import java.util.*; 
  
public class MastermindGame { 
  
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in); 
        Random generator = new Random(); 
          
        // Declare variables 
        String code; 
        int C1, C2, C3, C4;     // code to guess 
        int G1, G2, G3, G4;     // entered guess 
          
        int guessCount, playerWins, computerWins; 
        int guess; 
        long random; 
          
    // Game introduction to player and prompt for first round input 
        System.out.println("Guess the 4-number code made by the computer using   1 , 2 , 3, 4 , 5 , 6"); 
        System.out.println("a \"!!\" indicates a correct number in the correct position"); 
        System.out.println("a \"<>\" indicates a correct number in the wrong position"); 
        System.out.println("You have ten tries to guess the code"); 
        System.out.print("Enter your guess. For example: 1556 [Enter]\n\t\t\t\t\t\t\t"); 
          
          
//////////////////////////////////////////////////////////////////////////////////////////////////////// 
//      Generate random 4 digit code, each between 1 and 6 
//////////////////////////////////////////////////////////////////////////////////////////////////////// 
          
        int r = Math.abs(generator.nextInt() % 6); 
          
        if(r == 0) 
            C1 = 1; 
        else if(r == 1) 
            C1 = 2; 
        else if(r == 2) 
            C1 = 3; 
        else if(r == 3) 
            C1 = 4; 
        else if(r == 4) 
            C1 = 5; 
        else
            C1 = 6; 
          
        r = Math.abs(generator.nextInt() % 6); 
          
        if(r == 0) 
            C2 = 1; 
        else if(r == 1) 
            C2 = 2; 
        else if(r == 2) 
            C2 = 3; 
        else if(r == 3) 
            C2 = 4; 
        else if(r == 4) 
            C2 = 5; 
        else
            C2 = 6; 
          
        r = Math.abs(generator.nextInt() % 6); 
          
        if(r == 0) 
            C3 = 1; 
        else if(r == 1) 
            C3 = 2; 
        else if(r == 2) 
            C3 = 3; 
        else if(r == 3) 
            C3 = 4; 
        else if(r == 4) 
            C3 = 5; 
        else
            C3 = 6; 
          
        r = Math.abs(generator.nextInt() % 6); 
          
        if(r == 0) 
            C4 = 1; 
        else if(r == 1) 
            C4 = 2; 
        else if(r == 2) 
            C4 = 3; 
        else if(r == 3) 
            C4 = 4; 
        else if(r == 4) 
            C4 = 5; 
        else
            C4 = 6; 
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
//      Gameplay - Player tries to guess the random 4-digit code generated by the computer 
////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
  
        // Command used for debugging, un-comment to display the computer's 4-digit code during the game 
        // 
        // System.out.println(C1 +" " + C2 + " " + C3 +  " " + C4); 
          
    // Repeat the following code up to 10 times. These are the "rounds" 
        for (int i = 1; i < 11; i++){ 
              
        // Assign the master code from the capital C's to the temporary code digits with little c's 
            int c1 = C1, c2 = C2, c3 = C3, c4 = C4; 
          
        // Take 4 digit guess from player 
            guess = input.nextInt(); 
              
          
        // Asks again for input if outside of range 
            while((guess > 6666) || (guess < 1111)){ 
                System.out.println("You must guess between 1111 and 6666"); 
                guess = input.nextInt(); 
                } 
      
        //  Take 4 digit guess from the player and separate it into 4 variables 
            G1 = guess/1000;                             
            G2 = (guess - 1000*G1) / 100;                
            G3 = (guess - 1000*G1 - 100*G2) / 10;        
            G4 = (guess - 1000*G1 - 100*G2 - 10*G3); 
              
        // Assign the master code guess from the capital G's to the temporary code guess with little g's 
            int g1 = G1, g2 = G2, g3 = G3, g4 = G4; 
              
        // Keeps all the text lined up when displaying 2 digit guess number 10 
            if (i != 10) 
                System.out.print("Guess " + i + "  : " + g1 +" " + g2 + " " + g3 +  " " + g4 + "  - result ->   "); 
            else 
                System.out.print("Guess " + i + " : " + g1 +" " + g2 + " " + g3 +  " " + g4 + "  - result ->   "); 
          
        // Tests for correct number in the correct position. If so, remove both guess digit and code digit from 
        // further analysis to avoid extra "!!" and/or "<>" 
            if (g1 == c1){ System.out.print("!! "); g1 = 0; c1 = 11;} 
            if (g2 == c2){ System.out.print("!! "); g2 = 7; c2 = 12;} 
            if (g3 == c3){ System.out.print("!! "); g3 = 8; c3 = 13;} 
            if (g4 == c4){ System.out.print("!! "); g4 = 9; c4 = 14;}  
                  
        // Tests for correct number in the wrong position. If so, remove both guess digit and code digit from 
        // further analysis to avoid extra "<>" 
            if (g1==c2){ System.out.print("<> "); g1 = 0; c2 = 11;} 
            if (g1==c3){ System.out.print("<> "); g1 = 0; c3 = 11;} 
            if (g1==c4){ System.out.print("<> "); g1 = 0; c4 = 11;} 
            if (g2==c1){ System.out.print("<> "); g2 = 0; c1 = 11;} 
            if (g2==c3){ System.out.print("<> "); g2 = 0; c3 = 11;} 
            if (g2==c4){ System.out.print("<> "); g2 = 7; c4 = 12;} 
            if (g3==c1){ System.out.print("<> "); g3 = 0; c1 = 11;} 
            if (g3==c2){ System.out.print("<> "); g3 = 0; c2 = 11;} 
            if (g3==c4){ System.out.print("<> "); g3 = 8; c4 = 13;} 
            if (g4==c1){ System.out.print("<> "); g4 = 0; c1 = 11;} 
            if (g4==c2){ System.out.print("<> "); g4 = 0; c2 = 11;} 
            if (g4==c3){ System.out.print("<> "); g4 = 9; c3 = 14;} 
              
            System.out.print("\t"); 
              
        // Test for winning condition: All guessed code digits equal all computer code digits 
            if ((G1 == C1) && (G2 == C2) && (G3 == C3) && (G4 == C4)) 
                System.out.println("You win!"); 
        // Test for losing condition: If it's the end of round 10 and the code still wasn't guessed, you lose 
            else if (i == 10) 
                System.out.println("You lose. The correct code was\n           " + C1 +" " + C2 + " " + C3 +  " " + C4); 
              
        // Lines up correct code under previous guessed codes 
            System.out.print("\t\t"); 
        } 
              
    } 
  
} 