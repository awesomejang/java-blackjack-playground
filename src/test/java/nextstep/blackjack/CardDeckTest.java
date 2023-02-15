package nextstep.blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


public class CardDeckTest {
    private CardDeck cardDeck;
    //private static final CardDeck.Pattern[] PATTENS = {"spade", "heart", "diamond", "club"};
    private static final int CARD_COUNT = 13;

    public static <K, V, W> Map<K, V> nMap(K key, W value, Object... rest) {
        Map<K, V> m = new HashMap<K, V>(3);
        m.put(key, (V) value);
        for (int i = 0; i < rest.length; i += 2) {
            m.put((K) rest[i], (V) rest[i + 1]);
        }
        return m;
    }


    @Test
    @DisplayName("카드가 규칙대로 생성됐는지 테스트")
    void generateCardsTest() {
        cardDeck = new CardDeck();
        Stack<Card> cards = cardDeck.getCards();
        for (Card.Pattern pattern : Card.Pattern.values()) {
            for (Card.Denomination denomination : Card.Denomination.values()) {
                Card card = new Card(pattern, denomination);
                //System.out.println(targetCard.getDenomination() + " " + targetCard.getPattern());
                Assertions.assertThat(cards.contains(card)).isTrue();

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

    @Test
    void tmpTest() {
        Map<String, Object> cardSeq = CardDeckTest.nMap("cardSeq", 914);
        for (String ss : cardSeq.keySet()) {
            System.out.println(cardSeq.get(ss));
        }
    }

}
