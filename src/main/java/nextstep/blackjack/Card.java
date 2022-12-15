package nextstep.blackjack;

/**
 * 한개의 패턴(다이아, 하트, 스페이스, 클럽)중 한개
 * A,2~10,K,Q,J중 하나를 가지고 있다.
 */
public class Card {
    private String pattern;  // 패턴
    private String denomination; // 숫자

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
}
