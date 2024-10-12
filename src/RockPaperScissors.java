import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerA, playerB; // variable bs
        boolean playAgain = true;

        while (playAgain) { //Basic while function
            playerA = getPlayerMove(scanner, "Player A");
            playerB = getPlayerMove(scanner, "Player B");

            // who win dis shi
            System.out.println(determineWinner(playerA, playerB));

            // yooo
            System.out.print("Do you want to play again? (Y/N): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("Y");
        }

        scanner.close();
    }

    private static String getPlayerMove(Scanner scanner, String playerName) {
        String move;
        do {
            System.out.print(playerName + ", enter your move (R/P/S): ");
            move = scanner.next();
        } while (!isValidMove(move));
        return move.toUpperCase();
    }

    private static boolean isValidMove(String move) {
        return move.equalsIgnoreCase("R") || move.equalsIgnoreCase("P") || move.equalsIgnoreCase("S");
    }

    private static String determineWinner(String playerA, String playerB) {
        if (playerA.equals(playerB)) return playerA + " vs " + playerB + " - It's a Tie!";

        // switch case seemed most optimal
        return switch (playerA) {
            case "R" ->
                    playerB.equals("S") ? "Rock breaks Scissors - Player A wins!" : "Paper covers Rock - Player B wins!";
            case "P" ->
                    playerB.equals("R") ? "Paper covers Rock - Player A wins!" : "Scissors cuts Paper - Player B wins!";
            case "S" -> {
                yield playerB.equals("P") ? "Scissors cuts Paper - Player A wins!" : "Rock breaks Scissors - Player B wins!";
            }
            default -> {
                yield "Invalid move!";
            }
        };
    }
}