package main.java.ru.mts;

import java.math.BigDecimal;

public abstract class AbstractAnimal implements Animal {
    protected String breed; //порода
    protected String name; //имя
    protected BigDecimal cost; //цена в магазине, до двух знаков после запятой
    protected String character; //характер

}
