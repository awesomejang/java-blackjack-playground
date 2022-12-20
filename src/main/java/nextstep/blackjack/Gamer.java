package nextstep.blackjack;

import java.util.List;

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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("현재 보유 카드목록 \n");

        for (Card card : cards.getCards()) {
            stringBuilder.append(card.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


}
