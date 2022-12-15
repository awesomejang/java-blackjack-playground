package nextstep.blackjack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 카드를 플레이어, 딜러에게 제공
 * 총 52장의 각기다른 카드를 보유
 * 일급 컬렉션으로 구성
 * 본인의 역할을 하기위해 무조건 카드가 있어야되기 때문에 생성자로 카드를 초기화
 */
public class CardDeck {
    private static final String[] PATTENS = {"spade", "heart", "diamond", "club"};
    private static final int CARD_COUNT = 13;
    private List<Card> cards;

    public CardDeck() {
        cards = generateCards();
    }

    private List<Card> generateCards() {
        List<Card> cards = new LinkedList<>();

        for (String patten : PATTENS) {
            for (int i = 0; i < CARD_COUNT; i++) {
                String denomination = numberToDenomination(i);
                Card card = new Card(patten, denomination);
                cards.add(card);
            }
        }
        return cards;
    }

    private String numberToDenomination(int number) {
        if(number == 1) {
            return  "A";
        }
        if(number == 11) {
            return  "J";
        }
        if(number == 12) {
            return  "Q";
        }
        if(number == 13) {
            return  "K";
        }
        return String.valueOf(number);
    }

    public List<Card> getCards() {
        return cards;
    }

}
