package nextstep.blackjack;

import java.util.List;
import java.util.StringJoiner;

/**
 * [x] 추가로 카드를 받는다.
 * [x] 뽑은 카드를 소유한다.
 * [x] 카드를 오픈한다.
 * [] 보유한 카드를 확인한다.
 */
public class Gamer {

    //private List<Card> cards;
    private String name;
    private int betAmount;
    private Cards cards;

    public Gamer(String name, int betAmount) {
        this.name = name;
        this.betAmount = betAmount;
    }

    /**
     * 카드를 오픈한다.
     * @return
     */
    public List<Card> openCards() {
        return cards.getCards();
//      return this.cards;
    }

    /**
     * 카드를 한장 받는다.
     * @param card
     */
    public void receiveCard(Card card) {
        this.cards.addCard(card);
        //cards.add(card);
    }

    /**
     * 현재 보유한 카드목록을 출력한다.
     * @return
     */
    public String showCards() {
        StringJoiner stringJoiner = new StringJoiner(Constant.SPLIT_MARK_PLAYERS_NAME);
        //stringJoiner.add("현재 보유 카드목록 \n");
        for (Card card : cards.getCards()) {
            stringJoiner.add(card.toString());
            //stringJoiner.add("\n");
        }
        return stringJoiner.toString();
    }

    public String getName() {
        return name;
    }

    public int getBetAmount() {
        return betAmount;
    }
}
