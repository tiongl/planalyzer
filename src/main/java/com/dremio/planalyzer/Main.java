package com.dremio.planalyzer;

import java.io.IOException;

class Main {

   public static void main(String[] args) {
      System.out.println("Antlr4 Example");
      try {
          PlanLine planLine = PlanUtils.parsePlan(args[0]);
          new PlanPrinter().process(planLine);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }


}
