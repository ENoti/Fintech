package ru.mts;

/**
 * Первый класс с тремя переменными
 * @autor SaintMouS
 * @version 1.0
 */
class FirstClass {
    /** Количество товара */
    int countProduct; //Количество товара до 2022
    /** Сумма товара */
    double sumProduct; //Сумма товара до 1 доллар = 200 руб
    /** Скидка на товар */
    double saleOnProduct; //Скидка на товар вводится в процентах: 150%

    public void calculate(int countProduct, double sumProduct, double saleOnProduct){
        this.sumProduct = sumProduct;
        this.saleOnProduct = saleOnProduct;
        this.countProduct = countProduct;
        double sumWithSale = sumProduct * (1 - (saleOnProduct / 100)) * countProduct;
        double sumWithoutSale = sumProduct * countProduct;
        System.out.println("Sum without sale: " + String.format("%.2f", sumWithoutSale) + "₽");
        System.out.println("Sum with sale: " + String.format("%.2f", sumWithSale) + "₽\n");
    }

}

public class Main {
    public static void main(String[] args) {
        FirstClass firstClass = new FirstClass();
        firstClass.calculate(12, 54, 0.75);
        firstClass.calculate(512, 515, 42.575);
        firstClass.calculate(1024, 12,59.1);
    }

}