package nextstep.blackjack;

import org.assertj.core.api.Assertions;
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
        PlayerMoney playerMoney = new PlayerMoney(10000);
        playerMoney.calculateResultMoney(playerMoney.getBetMoney(), MoneyOperator.PLUS);

        Assertions.assertThat(playerMoney.getResultMoney()).isEqualTo(10000);

        playerMoney.calculateResultMoney(5000, MoneyOperator.MINUS);
        Assertions.assertThat(playerMoney.getResultMoney()).isEqualTo(5000);

        playerMoney.calculateResultMoney(Constant.BONUS_DEALER_OVER_BLACKJEKNUMBER_BLACKJEK, MoneyOperator.MULTIPLY);
        Assertions.assertThat(playerMoney.getResultMoney()).isEqualTo(20000);
    }

}
