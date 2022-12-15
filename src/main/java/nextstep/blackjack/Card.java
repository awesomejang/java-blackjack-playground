package nextstep.blackjack;

import java.util.Objects;

/**
 * 한개의 패턴(다이아, 하트, 스페이스, 클럽)중 한개
 * A,2~10,K,Q,J중 하나를 가지고 있다.
 */
public class Card {
    private String pattern;  // 패턴
    private String denomination; // 숫자

    public Card(String pattern, String denomination) {
        this.pattern = pattern;
        this.denomination = denomination;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (!Objects.equals(pattern, card.pattern)) return false;
        return Objects.equals(denomination, card.denomination);
    }

    @Override
    public int hashCode() {
        int result = pattern != null ? pattern.hashCode() : 0;
        result = 31 * result + (denomination != null ? denomination.hashCode() : 0);
        return result;
    }
}
