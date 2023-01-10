package nextstep.blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


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
                Card targetCard = new Card(patten, i);
                //System.out.println(targetCard.getDenomination() + " " + targetCard.getPattern());
                Assertions.assertThat(cards.contains(targetCard)).isTrue();

            }
        }
    }
    @Test
    @DisplayName("카드를 뽑으면 뽑힌 카드는 카드덱에서 제거된다.")
    void randomTest() {
        cardDeck = new CardDeck();
        Card drawCard = cardDeck.draw();
        Assertions.assertThat(cardDeck.getCards().contains(drawCard)).isFalse();
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
