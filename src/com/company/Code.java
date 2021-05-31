package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Code {

    private int[] code;

    public Code(int length, int colours){
        int[] code = new int[length];
        for (int i = 0; i < code.length; i++) {
            code[i] = (int) Math.floor(Math.random()*colours);
        }
        this.code = code;
    }

    public Code(int[] code){
        this.code = code;
    }

    public int[] getCode() {
        return code;
    }

    public int[] compare(Code other){
        boolean[] matchedOriginalCode = new boolean[this.code.length];
        boolean[] matchedInNewCode = new boolean[this.code.length];
        int correctColourAndPosition = 0;
        // find out how many are in the right place
        for (int i = 0; i < this.code.length; i++) {
            if (this.code[i] == other.getCode()[i]){
                correctColourAndPosition++;
                matchedOriginalCode[i] = true;
                matchedInNewCode[i] = true;
            }
        }

        int correctColour = 0;
        // find out how many of the right colours are used
        for (int i = 0; i < this.code.length; i++) {
            if (!matchedOriginalCode[i]){
                for (int j = 0; j < this.code.length; j++) {
                    if ((!matchedInNewCode[j]) && (this.code[i] == other.getCode()[j])){
                        correctColour++;
                        matchedInNewCode[i] = true;
                    }
                }
            }
        }
        return new int[]{correctColourAndPosition, correctColour};

    }
}
