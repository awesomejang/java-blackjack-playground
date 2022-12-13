package nextstep.blackjack;

import java.util.List;

/**
 * [x] 추가로 카드를 받는다.
 * [x] 뽑은 카드를 소유한다.
 * [x] 카드를 오픈한다.
 */
public class Gamer {

    private List<Card> cards;

    /**
     * 카드를 오픈한다.
     * @return
     */
    public List<Card> openCards() {
        return cards;
    }

    public void receiveCard(Card card) {
        cards.add(card);
    }



}
