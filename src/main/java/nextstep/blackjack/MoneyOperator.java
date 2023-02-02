package nextstep.blackjack;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public enum MoneyOperator {
    PLUS((num1, num2) -> num2 + num1),
    MINUS((num1, num2) -> num2 - num1),
    MULTIPLY((num1, num2)-> new BigDecimal(num2).multiply(new BigDecimal(num1)).intValue());

//    private String operator;
    private BiFunction<Integer, Integer, Integer> biFunction;

    MoneyOperator(BiFunction<Integer, Integer, Integer> biFunction) {
        this.biFunction = biFunction;
    }

    public Integer calculate(int num1, int num2) {
        return this.biFunction.apply(num1, num2);


    }

}
