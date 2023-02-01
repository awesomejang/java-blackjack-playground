package nextstep.blackjack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class PlayerMoneyTest {

    //@Test
    @ParameterizedTest
    //@EnumSource(value = MoneyOperator.class, names = {"PLUS", "MINUS", "MULTIPLY"})
    @EnumSource(MoneyOperator.class)
    void calculateResultMoneyTest(MoneyOperator moneyOperator) {
        System.out.println(moneyOperator.name());

        //PlayerMoney playerMoney = new PlayerMoney(10000);

        //playerMoney.
    }

}
