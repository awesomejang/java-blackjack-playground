import nextstep.blackjack.Card;
import nextstep.blackjack.Dealer;
import nextstep.blackjack.Gamer;
import nextstep.blackjack.Gamers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RuleTest {

    @Test
    void judgeWinnerTest() {
        // given
        Dealer dealer = new Dealer();
        Gamer test1 = new Gamer("test1", 10000);
        Gamer test2 = new Gamer("test2", 20000);
        Gamers gamers1 = new Gamers(Arrays.asList(test1, test2));

        // when
        dealer.receiveCard(new Card(Card.Pattern.DIAMOND, Card.Denomination.ACE));
        dealer.receiveCard(new Card(Card.Pattern.DIAMOND, Card.Denomination.TEN)); //== 11 ==//

        test1.receiveCard(new Card(Card.Pattern.DIAMOND, Card.Denomination.TEN));
        test1.receiveCard(new Card(Card.Pattern.DIAMOND, Card.Denomination.NINE)); //== 19 ==//

        test2.receiveCard(new Card(Card.Pattern.DIAMOND, Card.Denomination.NINE));
        test2.receiveCard(new Card(Card.Pattern.DIAMOND, Card.Denomination.ACE)); //== 10 ==//

        // then


    }
}
