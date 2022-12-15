package nextstep.blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;


public class CardDeckTest {
    private CardDeck cardDeck;
    private static final String[] PATTENS = {"spade", "heart", "diamond", "club"};
    private static final int CARD_COUNT = 13;

    @Test
    @DisplayName("카드가 규칙대로 생성됐는지 테스트")
    void generateCardsTest() {
        cardDeck = new CardDeck();
        List<Card> cards = cardDeck.getCards();
        for (String patten : PATTENS) {
            for (int i = 0; i < CARD_COUNT; i++) {
                Card targetCard = new Card(patten, numberToDenomination(i));
                //System.out.println(targetCard.getDenomination() + " " + targetCard.getPattern());
                Assertions.assertThat(cards.contains(targetCard)).isTrue();

            }
        }
    }

    @Test
    void asdasd() {
        LinkedList<Card> cards = new LinkedList<>();
        Card card = new Card("A", "spade");
        cards.add(card);
        Card card2 = new Card("A", "spade");
        System.out.println(cards.contains(card2));
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

}
