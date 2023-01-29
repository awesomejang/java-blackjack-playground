package nextstep.blackjack;

import nextstep.blackjack.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RuleTest {
    private Gamer gamer1 = new Gamer("gamer1", 10000);
    private Gamer gamer2 = new Gamer("gamer2", 20000);
    Rule rule = new Rule();

    /*@BeforeEach
    void createGamers() {
        gamer1 = new Gamer("gamer1", 10000);
        gamer2 = new Gamer("gamer2", 20000);
    }*/
    @Test
    @DisplayName("딜러와 플레이어의 카드를 확인하여 게임머니를 계산한다.")
    void judgeWinnerTest() {
        // given
        Dealer dealer = new Dealer();
//        Rule rule = new Rule();

        /*Gamer gamer1 = new Gamer("gamer1", 10000);
        Gamer gamer2 = new Gamer("gamer2", 20000);*/
        Gamer overLimitGamer = new Gamer("overLimitGamer", 30000);
        Gamers gamers = new Gamers(Arrays.asList(gamer1, gamer2, overLimitGamer));

        // when
        dealer.receiveCard(new Card(Card.Pattern.DIAMOND, Card.Denomination.ACE));
        dealer.receiveCard(new Card(Card.Pattern.DIAMOND, Card.Denomination.TEN)); //== 11 ==//

        gamer1.receiveCard(new Card(Card.Pattern.DIAMOND, Card.Denomination.TEN));
        gamer1.receiveCard(new Card(Card.Pattern.DIAMOND, Card.Denomination.NINE)); //== 19 ==//

        gamer2.receiveCard(new Card(Card.Pattern.DIAMOND, Card.Denomination.NINE));
        gamer2.receiveCard(new Card(Card.Pattern.DIAMOND, Card.Denomination.ACE)); //== 10 ==//

        overLimitGamer.receiveCard(new Card(Card.Pattern.DIAMOND, Card.Denomination.TEN));
        overLimitGamer.receiveCard(new Card(Card.Pattern.DIAMOND, Card.Denomination.JACK));
        overLimitGamer.receiveCard(new Card(Card.Pattern.DIAMOND, Card.Denomination.FIVE)); //== 25 ==//


        rule.judgeWinner(dealer, gamers);

        // then
        Assertions.assertThat(gamer1.getPlayerMoney().getResultMoney()).isEqualTo(10000);
        Assertions.assertThat(gamer2.getPlayerMoney().getResultMoney()).isEqualTo(-20000);
        Assertions.assertThat(overLimitGamer.getPlayerMoney().getResultMoney()).isEqualTo(-30000);
    }

    @Test
    @DisplayName("처음 두 장의 카드 합이 21(블랙잭)일 경우 배팅금액의 1.5배를 딜러에게 받는다.")
    void firstBlackJekEventTest() {
        // given
//        Rule rule = new Rule();
        Dealer dealer = new Dealer();
        // when
        gamer1.receiveCard(new Card(Card.Pattern.CLOVER, Card.Denomination.QUEEN));
        gamer1.receiveCard(new Card(Card.Pattern.CLOVER, Card.Denomination.ACE));
        gamer1.receiveCard(new Card(Card.Pattern.CLOVER, Card.Denomination.KING)); //== blackjek ==//

        gamer2.receiveCard(new Card(Card.Pattern.CLOVER, Card.Denomination.ACE));
        gamer2.receiveCard(new Card(Card.Pattern.CLOVER, Card.Denomination.KING)); //== Non BlackJek ==//

        rule.firstBlackJekEvent(new Gamers(Arrays.asList(gamer1, gamer2)), dealer);

        // then
        Assertions.assertThat(gamer1.getPlayerMoney().getResultMoney()).isEqualTo(15000);
    }

    @Test
    @DisplayName("딜러가 21(블랙잭)을 초과하면 boolean(true)를 리턴한다.")
    void isDealerOverLimitPointTest() {
        // given
        Dealer overDealer = new Dealer();
        Dealer dealer = new Dealer();
        // when
        overDealer.receiveCard(new Card(Card.Pattern.CLOVER, Card.Denomination.FOUR));
        overDealer.receiveCard(new Card(Card.Pattern.CLOVER, Card.Denomination.JACK));
        overDealer.receiveCard(new Card(Card.Pattern.CLOVER, Card.Denomination.TEN));

        dealer.receiveCard(new Card(Card.Pattern.CLOVER, Card.Denomination.FOUR));

        boolean overLimitResult = rule.isDealerOverLimitPoint(overDealer);
        boolean nonOverLimitResult = rule.isDealerOverLimitPoint(dealer);
        // then
        Assertions.assertThat(overLimitResult).isTrue();
        Assertions.assertThat(nonOverLimitResult).isFalse();

    }
}
