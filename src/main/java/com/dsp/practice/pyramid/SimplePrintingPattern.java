package com.dsp.practice.pyramid;


import java.util.Scanner;

public class SimplePrintingPattern {

    public static void print(double prefix, int middle, double suffix){
        for (int i = 0; i < prefix; i++) {
            System.out.print("1");
        }
        for (int i = 0; i <= middle; i++) {
            if(middle==i || i==0) {
                System.out.print("*");
            }
            else if(i==1 || i%2!=0){
                System.out.print(" * ");
            }
        }

        for (int i = 0; i < suffix; i++) {
            System.out.print("1");

        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the rows to print");
        int rows = scanner.nextInt();
        scanner.close();
        System.out.println(rows);
        int spacers = rows-1;
        for(int i=0;i<rows;i++,spacers--){
                print(spacers,i,spacers);
                //System.out.print(i);

            System.out.println();
        }
    }

}
