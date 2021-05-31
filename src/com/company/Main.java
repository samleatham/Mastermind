package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Code collectInput(){
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
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
        final Code solution = new Code(WIDTH,COLOURS);
        System.out.println(Arrays.toString(solution.getCode()));
        Code guess = collectInput();
        int[] result = solution.compare(guess);
        System.out.println("Correct: "+ result[0] +"\nCorrect Colour: "+ result[1]);
    }
}
