package nextstep.blackjack;

import java.util.List;

/**
 * [x] 카드를 받는다
 * [] 뽑은 카드를 소유한다.
 * [x] 카드를 오픈한다.
 * [] 2카드의 합계 점수가 16점 이하이면 반드시 1장을 추가로 뽑고, 17점 이상이면 받을 수 없다.
 */
public class Dealer {
    private Cards cards;
    //private List<Card> cards;

    /**
     * 카드를 받는다.
     * @param card
     */
    public void receiveCard(Card card) {
        if(isReceiveCard()) {
            cards.addCard(card);
            showCards();
        }else {
            System.out.println("보유한 카드의 점수가 17점 이상이기 때문에 카드를 받을 수 없습니다.");
        }
        //cards.add(card);
    }

    /**
     * 보유한 카드를 오픈한다.
     * @return
     */
    public List<Card> openCards() {
        return cards.getCards();
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

    /**
     * 보유한 카드의 점수 합계를 리턴한다.
     */
    private int getPointSum() {
        int sum = 0;
        for (Card card : cards.getCards()) {
            sum += card.getPoint();
        }
        return sum;
    }

    /**
     * 보유한 카드의 점수가 17점 이상인지 판단한다.
     * @return
     */
    private boolean isReceiveCard() {
        return this.getPointSum() <= Constant.DEALER_CAN_RECEIVE_POINT;
    }
}
