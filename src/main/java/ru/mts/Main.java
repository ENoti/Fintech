package ru.mts;

public class Main {

    public static void calculate(FirstClass firstClass) {
        double sumWithSale = firstClass.sumProduct * (1 - (firstClass.saleOnProduct / 100)) * firstClass.countProduct;
        double sumWithoutSale = firstClass.sumProduct * firstClass.countProduct;
        System.out.println("Sum without sale: " + String.format("%.2f", sumWithoutSale) + "₽");
        System.out.println("Sum with sale: " + String.format("%.2f", sumWithSale) + "₽\n");
    }

    public static void main(String[] args) {
        calculate(new FirstClass(12, 54, 0.75));
        calculate(new FirstClass(512, 515, 42.575));
        calculate(new FirstClass(1024, 12,59.1));
    }

}