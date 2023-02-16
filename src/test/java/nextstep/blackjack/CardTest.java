package nextstep.blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    @DisplayName("생성자로 생성한 카드의 패턴과 숫자가 일치한다.")
    void CardCreateTest() {
        // given
        Card.Pattern diamond = Card.Pattern.DIAMOND;
        Card.Denomination four = Card.Denomination.FOUR;

        // when

        Card card = new Card(diamond, four);
        // then
        Assertions.assertThat(card.getPattern()).isEqualTo(diamond);
        Assertions.assertThat(card.getDenomination()).isEqualTo(four);
        Assertions.assertThat(card.getDenomination().getPoint()).isEqualTo(four.getPoint());
    }
}
