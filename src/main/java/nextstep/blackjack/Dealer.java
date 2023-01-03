package nextstep.blackjack;

import java.util.List;
import java.util.StringJoiner;

/**
 * [x] 카드를 받는다
 * [x] 뽑은 카드를 소유한다.
 * [x] 카드를 오픈한다.
 * [] 2카드의 합계 점수가 16점 이하이면 반드시 1장을 추가로 뽑고, 17점 이상이면 받을 수 없다.
 */
public class Dealer {
    private Cards cards = new Cards();
    private final String name = "딜러";
    //private List<Card> cards;

    /**
     * 카드를 받는다.
     * @param card
     */
    public void receiveCard(Card card) {
        if(isReceiveCard()) {
            cards.addCard(card);
        }else {
            System.out.println("카드의 총 합이 17이상입니다. 더 이상 카드를 받을 수 없습니다.");
        }
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
        StringJoiner stringJoiner = new StringJoiner(Constant.SPLIT_MARK_PLAYERS_NAME);
        //stringJoiner.add("현재 보유 카드목록 \n");
        for (Card card : cards.getCards()) {
            stringJoiner.add(card.toString());
            //stringJoiner.add("\n");
        }
        return stringJoiner.toString();
    }

    /**
     * 딜러의 카드 합이 16이상인지 확인한다.
     * @return
     */
    public boolean isReceiveCard() {
        return cards.getpointSum() <= Constant.CAN_RECEIVE_DEALER_POINT;
    }

    public String getName() {
        return name;
    }



}
