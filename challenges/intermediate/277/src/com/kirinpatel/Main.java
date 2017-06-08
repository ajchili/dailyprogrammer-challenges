/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kirin Patel
 * @version 1.0
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        ArrayList<Coin> coins = new ArrayList<Coin>();
        ArrayList<String> operators = new ArrayList<String>();
        
        int size = s.nextInt();
        
        for (int i = 0; i < size; i++) {
            String[] input = { s.next(), s.next(), s.next() };
            
            Coin a = new Coin(input[0], false);
            Coin b = new Coin(input[1], false);
            
            for (Coin c : coins) {
                if (a.name.equals(c.name))
                    a = c;
                else if (b.name.equals(c.name))
                    b = c;
            }
            
            coins.add(a);
            coins.add(b);
            operators.add(input[2]);
        }
        
        for (int i = 0; i < coins.size() / 2; i++) {
            int j = i * 2;
            switch (operators.get(i)) {
                case "equal":
                    coins.get(j + 1).isFake = coins.get(j).isFake;
                    break;
                case "left":
                    for (Coin c : coins) {
                        if (c.equals(coins.get(j + 1))) {
                            printOutput(null);
                            return;
                        }
                    }
                    
                    coins.get(j).isFake = false;
                    coins.get(j + 1).isFake = true;
                    break;
                case "right":
                    for (Coin c : coins) {
                        if (c.equals(coins.get(j + 1))) {
                            printOutput(null);
                            return;
                        }
                    }
                    coins.get(j).isFake = true;
                    coins.get(j + 1).isFake = false;
                    break;
                default:
                    break;
            }
        }
        
        printOutput(coins);
    }
    
    // Setup method to parse the information and print out whether or not the
    // data is consistant or not
    public static void printOutput(ArrayList<Coin> coins) {
        if (coins == null) {
            System.out.println("data is inconsistent");
            return;
        } 
        
        int numOfFakes = 0;
        for (Coin c : coins)
            if (c.isFake)
                numOfFakes++;
        
        if (numOfFakes == 0)
            System.out.println("no fake coins detected");
        else if (numOfFakes == 1)
            for (Coin c : coins)
                if (c.isFake)
                    System.out.println(c.name + " is lighter");
    }
    
    public static class Coin {
        
        private String name;
        private boolean isFake;
        
        public Coin(String name, boolean isFake) {
            this.name = name;
            this.isFake = isFake;
        }
        
        @Override
        public String toString() {
            return "Coin " + name + " : fake? " + isFake;
        }
        
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Coin)) {
                return false;
            } else {
                Coin objC = (Coin) o;
                if (name.equals(objC.name) && isFake == objC.isFake)
                    return true;
                else
                    return false;
            }
        }
    }
}
