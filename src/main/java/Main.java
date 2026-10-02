import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int balance = 100;
        int bet;
        int payout;
        String[] row;
        String playagain;

        System.out.println("**********************************");
        System.out.println("   Welcome to Java Slot Machine   ");
        System.out.println("**********************************");
        System.out.println("Symbols: 🍕 🍔 🥪 🍩 🍪 ");

        while (balance > 0) {
            System.out.println("current balance: $" + balance);
            System.out.print("placed your balance amount: ");
            bet = scanner.nextInt();
            scanner.nextLine();

            if (bet > balance) {
                System.out.println("INSUFFICIENT FUNDS");
                continue;
            } else if (bet <= 0) {
                System.out.println("bet must be greater than zero");
                continue;
            } else {
                balance -= bet;
            }
            System.out.println("spinning...");
            row = spinRow();
            printRow(row);
            payout = getpayout(row, bet);

            if (payout > 0) {
                System.out.println("you won $" + payout);
                balance += payout;
            } else {
                System.out.println("sorry you lost this round");
            }
            System.out.print("Do you want to play again? (Y/N): ");
            playagain = scanner.nextLine().toUpperCase();

            if (!playagain.equals("Y")){
                break;
            }

        }

        System.out.println("GAME OVER! your final balance is $"+balance);

        scanner.close();
    }

    static String[] spinRow() {
        String[] symbols = {"🍕", "🍔", "🥪", "🍩", "🍪"};
        String[] row = new String[3];
        Random random = new Random();


        for (int i = 0; i < 3; i++) {
            row[i] = (symbols[random.nextInt(symbols.length)]);
        }

        return row;
    }

    static void printRow(String[] row) {
        System.out.println("**************");
        System.out.println(" " + String.join(" | ", row));
        System.out.println("**************");
    }

    static int getpayout(String[] row, int bet) {
        if (row[0].equals(row[1]) && row[0].equals(row[1])) {
            return switch (row[0]) {
                case "🍕" -> bet * 3;
                case "🍔" -> bet * 4;
                case "🥪" -> bet * 5;
                case "🍩" -> bet * 10;
                case "🍪" -> bet * 15;
                default -> 0;
            };

        } else if (row[0].equals(row[1])) {
            return switch (row[0]) {
                case "🍕" -> bet * 2;
                case "🍔" -> bet * 3;
                case "🥪" -> bet * 4;
                case "🍩" -> bet * 5;
                case "🍪" -> bet * 10;
                default -> 0;
            };
        } else if (row[1].equals(row[2])) {
            return switch (row[1]) {
                case "🍕" -> bet * 2;
                case "🍔" -> bet * 3;
                case "🥪" -> bet * 4;
                case "🍩" -> bet * 5;
                case "🍪" -> bet * 10;
                default -> 0;
            };
        }

            return 0;
        }
}


