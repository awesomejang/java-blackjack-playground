package nextstep.blackjack;

import java.util.List;

/**
 * [x] 카드를 받는다
 * [] 뽑은 카드를 소유한다.
 * [x] 카드를 오픈한다.
 * [] 2카드의 합계 점수가 16점 이하이면 반드시 1장을 추가로 뽑고, 17점 이상이면 받을 수 없다.
 */
public class Dealer {
    private List<Card> cards;

    /**
     * 카드를 받는다.
     * @param card
     */
    public void receiveCard(Card card) {
        cards.add(card);
    }

    /**
     * 보유한 카드를 오픈한다.
     * @return
     */
    public List<Card> openCards() {
        return cards;
    }
}
