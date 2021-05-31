package com.company;

import java.util.Arrays;

public class Board {
    Code[] guesses;
    int[][] results;
    int turnsTaken = 0;
    int totalTurns;

    public Board(int height){
        this.guesses = new Code[height];
        this.results = new int[height][2];
        this.totalTurns = height;
    }

    public boolean gameOver(){
        return turnsTaken >= totalTurns;
    }

    public void takeTurn(Code guess, int[] result){
        int index = turnsTaken;
        guesses[index] = guess;
        results[index] = result;
        turnsTaken++;
    }

    public void printBoard(){
        System.out.println("\t|? ? ? ?|\t");
        System.out.println("_________________");
        final String EMPTYLINE = "\t|- - - -|\t";
        for (int i = 0; i < totalTurns-turnsTaken; i++) {
            System.out.println(EMPTYLINE);
        }
        for (int i = turnsTaken-1; i >= 0; i--) {
            String codeLine = Arrays.toString(guesses[i].getCode());
            codeLine = codeLine.replace("[","").replace("]","").trim().replace(",","");
            System.out.println(results[i][0]+"\t|"+codeLine+"|   "+results[i][1]);
        }
    }
}
