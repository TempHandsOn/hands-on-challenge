import java.util.Scanner;

public class HandsOnMain {
    private final static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        String choice = returnUserInputtedLine("Which HandsOn challenge do you want to try? Enter 1 or 2");
        while (!choice.equals("1") && !choice.equals("2")) {
            choice = returnUserInputtedLine("That's an incorrect entry. Enter 1 or 2. Press e to exit.");
            if (choice.equals("e")) {
                break;
            }
        }
        if (!choice.equals("e")) {
            if (choice.equals("1")) {
                HandsOn1 challenge1 = new HandsOn1();
                challenge1.setSentence(returnUserInputtedLine("Enter a sentence for hands on challenge 1: "));

                String alphabetical = returnUserInputtedLine("To return results in alphabetical order? Enter y");
                if (alphabetical.equals("y")) {
                    challenge1.setAlphabetical(true);
                } else {
                    String reverse = returnUserInputtedLine("To return results in reverse alphabetical order? Enter y");
                    if (reverse.equals("y")) {
                        challenge1.setReverseAlphabetical(true);
                    }
                }
                challenge1.processChallenge();
            } else {
                HandsOn2 challenge2 = new HandsOn2();
                challenge2.setTargetNumber(returnUserInputtedNumber("Enter the target number for challenge 2: "));

                System.out.println("Enter 4 numbers for challenge 2: ");
                for (int i = 0; i < 4; i++) {
                    int num = userInput.nextInt();
                    challenge2.getExpressionValues()[i] = num;
                }
                challenge2.processChallenge();
            }
        }
    }

    private static String returnUserInputtedLine(String messageToUser) {
        System.out.println(messageToUser);
        return userInput.nextLine();
    }

    private static int returnUserInputtedNumber(String messageToUser) {
        System.out.println(messageToUser);
        return userInput.nextInt();
    }
}
