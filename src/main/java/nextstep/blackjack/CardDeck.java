package nextstep.blackjack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 카드를 플레이어, 딜러에게 제공
 * 총 52장의 각기다른 카드를 보유
 * 일급 컬렉션으로 구성
 * 본인의 역할을 하기위해 무조건 카드가 있어야되기 때문에 생성자로 카드를 초기화
 */
public class CardDeck {
    private static final String[] PATTENS = {"spade", "heart", "diamond", "club"};
    private static final int CARD_COUNT = 13;
    private Cards cards;
    //private List<Card> cards;

    public CardDeck() {
        new Cards(generateCards());
        //cards = generateCards();
    }

    // list 사이즈안에서 랜덤값 받아서
    // 해당하는 list.get()후 list에서 제거 후
    // 카드 리턴
    public Card draw() {
        Card card = getSelectedCard();
        cards.removeCard(card);
        //cards.remove(card);
        return card;
    }

    /**
     * 랜덤하게 카드를한장 뽑아 준다.
     * @return
     */
    private Card getSelectedCard() {
        int size = cards.getCardSize();
        int targetIndex = (int)(Math.random() * size);
        return cards.getCard(targetIndex);
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
        return cards.getCards();
    }

}
