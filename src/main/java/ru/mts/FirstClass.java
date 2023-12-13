package ru.mts;

/**
 * Первый класс с тремя переменными
 *
 * @version 1.0
 * @autor SaintMouS
 */
public class FirstClass {
    /**
     * Количество товара
     */
    int countProduct; //Количество товара до 2022
    /**
     * Сумма товара
     */
    double sumProduct; //Сумма товара до 1 доллар = 200 руб
    /**
     * Скидка на товар
     */
    double saleOnProduct; //Скидка на товар вводится в процентах: 150%

    public FirstClass(int countProduct, double sumProduct, double saleOnProduct) {
        this.countProduct = countProduct;
        this.sumProduct = sumProduct;
        this.saleOnProduct = saleOnProduct;
    }
}
