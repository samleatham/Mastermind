package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Code collectInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your guess:");
        String[] input = scanner.nextLine().trim().split(" ");
        int[] code = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            code[i] = Integer.parseInt(input[i]);
        }
        return new Code(code);
    }

    public static void main(String[] args) {

        final int COLOURS = 6;
        final int WIDTH = 4;
        final int HEIGHT = 12;
        boolean won = false;
        final Code solution = new Code(WIDTH,COLOURS);
        Board board = new Board(HEIGHT);
        while(!board.gameOver()) {
            Code guess = collectInput();
            int[] result = solution.compare(guess);
            board.takeTurn(guess,result);
            board.printBoard();
            if (result[0] == 4){
                won = true;
                break;
            }
        }
        if (won)
            System.out.println("Congrats");
        else
            System.out.println("Better Luck Next Time!");
    }
}
