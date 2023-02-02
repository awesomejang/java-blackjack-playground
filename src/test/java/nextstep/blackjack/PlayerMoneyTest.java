package nextstep.blackjack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class PlayerMoneyTest {

    //@Test
//    @ParameterizedTest
    //@EnumSource(value = MoneyOperator.class, names = {"PLUS", "MINUS", "MULTIPLY"})
//    @EnumSource(MoneyOperator.class)
    @Test
    void calculateResultMoneyTest() {
        Integer calculate = MoneyOperator.PLUS.calculate(10, 20);
        System.out.println(calculate.intValue());


        //PlayerMoney playerMoney = new PlayerMoney(10000);

        //playerMoney.
    }

}
