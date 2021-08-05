package BowlingScore;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author potte
 */
public class BowlingGame {
        
    
    public static void main(String args[]){
        int k;
        int i = 1;
        int r = 0;
        int s = 0;
        int pinsRoll1 = 0;
        int pinsRoll2 = 0;
        int tempSpareRoll1 = 0;
        int tempSpareRoll2 = 0;
        int[] Score = new int[10];
        int[] Rolls = new int[21];
        boolean spareHappened = false;
        boolean strikeHappened1 = false;
        boolean strikeHappened2 = false;
        int finalScore = 0;
        
        Scanner sc = new Scanner(System.in);
        for (k = 1; k < 3; k++) {
            if (k == 1) { 
                System.out.println("Pins:" + Arrays.toString(Rolls));
                System.out.println("Score:" +Arrays.toString(Score));
                System.out.println("Frame " + i + " Roll 1");
                System.out.println("Input roll: ");
                pinsRoll1 = sc.nextInt();
                if (pinsRoll1 < 0 || pinsRoll1 > 10) {
                    k = Error();
                } else {
                    Rolls[r] = pinsRoll1;  
                    if (strikeHappened2 && strikeHappened1 && pinsRoll1 == 10) {                        
                        finalScore += 30;
                        Score[s] = finalScore;
                        s += 1;
                        k = 0;
                        r += 2;
                        i += 1;
                    } else if (strikeHappened1 && pinsRoll1 == 10){ 
                        System.out.println("STRIKE!");
                        strikeHappened2 = true;
                        k = 0;
                        i += 1;
                    } else if (pinsRoll1 == 10) {
                        System.out.println("STRIKE!");
                        strikeHappened1 = true;
                        k = 0;
                        i += 1;
                        r += 2;
                    }  else if (spareHappened) {
                        finalScore += tempSpareRoll1 + tempSpareRoll2 + pinsRoll1;
                        spareHappened = false;
                        Rolls[r] = pinsRoll1;
                        r += 1;
                        Score[s] = finalScore; 
                        s += 1;                         
                        if (strikeHappened2) {        
                            strikeHappened2 = false;
                        }
                    } else {                        
                        r += 1; 
                    } 
                }
            } else {
                System.out.println("Pins:" + Arrays.toString(Rolls));
                System.out.println("Score:" +Arrays.toString(Score));
                System.out.println("Frame " + i + " Roll 2");
                System.out.println("Input roll: ");
                pinsRoll2 = sc.nextInt();
                if (pinsRoll2 < 0 || pinsRoll2 > 10 || pinsRoll1 + pinsRoll2 > 10) {
                    k = Error();
                } else {
                    Rolls[r] = pinsRoll2;
                    if (pinsRoll1 + pinsRoll2 == 10) {
                        System.out.println("SPARE!");
                        tempSpareRoll1 = pinsRoll1;
                        tempSpareRoll2 = pinsRoll2;
                        spareHappened = true;
                        k = 0;
                        i += 1;
                        r += 1;
                    } else if (strikeHappened1) {
                        finalScore += 10 + pinsRoll2 + pinsRoll1;
                        strikeHappened1 = false;
                        k = 0;
                        Score[s] = finalScore;
                        i += 1;
                        r += 1;
                        s += 1;
                    } else {
                        finalScore += pinsRoll2 + pinsRoll1;
                        k = 0;
                        Score[s] = finalScore;
                        i += 1;
                        r += 1;
                        s += 1;
                    }
                }     
            }              
            if (i == 11 && pinsRoll1 == 10) {                
                Rolls[r] = pinsRoll1;
                finalScore += 30;
                Score[s] = finalScore;
                k = 3;
                s += 1; 
                r += 1;
                System.out.println("Pins:" + Arrays.toString(Rolls));
                System.out.println("Score:" +Arrays.toString(Score)); 
                System.out.println("Two more rolls!");
                pinsRoll1 = sc.nextInt();
                Rolls[r] = pinsRoll1;
                r += 1;
                System.out.println("Pins:" + Arrays.toString(Rolls));
                System.out.println("Score:" +Arrays.toString(Score)); 
                System.out.println("Last ball!");
                pinsRoll2 = sc.nextInt();
                Rolls[r] = pinsRoll2;
                if (pinsRoll1 == 10 && pinsRoll2 == 10) {
                    finalScore += 30;
                    Score[s] = finalScore;
                } else {
                    finalScore += pinsRoll2 + pinsRoll1;
                    Score[s] = finalScore;
                }
                
            } else if (i == 11 && pinsRoll1 + pinsRoll2 == 10) {
                Score[s] = finalScore;
                k = 3;
                s += 1; 
                r += 1;
                System.out.println("Pins:" + Arrays.toString(Rolls));
                System.out.println("Score:" +Arrays.toString(Score));                
                System.out.println("One more roll!");
                pinsRoll1 = sc.nextInt(); 
                Rolls[r] = pinsRoll1;  
                finalScore += pinsRoll1;
                Score[s] = finalScore;
            } else if  (i == 11) {
                break; 
            }
        }
            
        System.out.println("Pins:" + Arrays.toString(Rolls));
        System.out.println("Score:" +Arrays.toString(Score));
        System.out.println("Game Over!");
        System.out.println("Final Score: " + finalScore); 
    }

    private static int Error() {
        int k;
        System.out.println("Invaild number.");
        k = 0;
        return k;
    }
}
