package nextstep.optional;

import nextstep.blackjack.MoneyOperator;
import nextstep.blackjack.PlayerMoney;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static nextstep.optional.User.ageIsInRange1;
import static nextstep.optional.User.ageIsInRange2;
import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @Test
    public void whenFiltersWithoutOptional_thenCorrect() {
        assertThat(ageIsInRange1(new User("crong", 35))).isTrue();
        assertThat(ageIsInRange1(new User("crong", 48))).isFalse();
        assertThat(ageIsInRange1(new User("crong", null))).isFalse();
        assertThat(ageIsInRange1(new User("crong", 29))).isFalse();
        assertThat(ageIsInRange1(null)).isFalse();
    }

    @Test
    public void whenFiltersWithOptional_thenCorrect() {
        assertThat(ageIsInRange2(new User("crong", 35))).isTrue();
        assertThat(ageIsInRange2(new User("crong", 48))).isFalse();
        assertThat(ageIsInRange2(new User("crong", null))).isFalse();
        assertThat(ageIsInRange2(new User("crong", 29))).isFalse();
        assertThat(ageIsInRange2(null)).isFalse();
    }

    @Test
    public void test() {
        PlayerMoney playerMoney = new PlayerMoney(100);
        int i = playerMoney.calculateResultMoney(playerMoney.getBetMoney(), MoneyOperator.MULTIPLY);
        System.out.println(i);
        System.out.println(playerMoney.getResultMoney());
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(123));
        BigDecimal multiply = bigDecimal.multiply(new BigDecimal(String.valueOf(1.6)));
        System.out.println(multiply);
        System.out.println(multiply.setScale(0, RoundingMode.HALF_UP).intValue());
    }
}
