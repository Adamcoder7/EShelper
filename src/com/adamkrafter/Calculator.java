/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adamkrafter;

/**
 *
 * @author Adam
 */
public class Calculator {
    public String calculate (String cislo1, String cislo2, String operacia) {
     
      int num1 = Integer.parseInt(cislo1);
      int num2 = Integer.parseInt(cislo2);
      Number vysledok;
      if (operacia.equalsIgnoreCase("plus") || operacia.equalsIgnoreCase("+")) {
         vysledok = Math.addExact(num1, num2);
      }
      else if (operacia.equalsIgnoreCase("minus") || operacia.equalsIgnoreCase("-")) {
         vysledok = Math.subtractExact(num1, num2);
      }
      else if (operacia.equalsIgnoreCase("krat") || operacia.equalsIgnoreCase("*")) {
         vysledok = Math.multiplyExact(num1, num2);
      }
      else if (operacia.equalsIgnoreCase("deleno") || operacia.equalsIgnoreCase("/")) {
         vysledok = num1 / num2;
      }
      else {
          String neplatnaOperacia = "NEplatna operacia "+operacia;
          return neplatnaOperacia;
      }
      return vysledok.toString();
    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String v = calculator.calculate("8", "4", "-");
        System.out.println("Vysledok: "+v);
    }
}