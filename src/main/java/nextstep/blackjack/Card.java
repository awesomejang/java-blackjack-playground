package nextstep.blackjack;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * 한개의 패턴(다이아, 하트, 스페이스, 클럽)중 한개
 * A,2~10,K,Q,J중 하나를 가지고 있다.
 */
public class Card {
    private Pattern pattern;  // 패턴
    /*private String denomination; // 숫자
    private int point; // 카드 점수*/
    private Denomination denomination;
    //String denomination, int point
    public Card(Pattern pattern, Denomination denomination) {
        this.pattern = pattern;
        this.denomination = denomination;
        /*this.denomination = numberToDenomination(index);
        this.point = numberToPoint(index);*/
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

//    public String getDenomination() {
//        return denomination;
//    }

//    public void setDenomination(String denomination) {
//        this.denomination = denomination;
//    }

    public int getPoint() {
        return this.denomination.getPoint();
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


    private int numberToPoint(int number) {
        if(number >= 11) {
            return 10;
        }
        return number;
    }
    /*@Override
    public String toString() {
        return getDenomination() + getPattern();
    }*/
    public enum Pattern {
        SPADE("spade"),
        HEART("heart"),
        DIAMOND("diamond"),
        CLOVER("clover");
        private Pattern() {}
        Pattern(String value) {
            this.value = value;
        }
        private String value;
        public String getValue() {
            return this.value;
        }
    }

    public enum Denomination {
        ACE("A", 1),
        TWO("2", 2),
        THREE("3", 3),
        FOUR("4", 4),
        FIVE("5", 5),
        SIX("6", 6),
        SEVEN("7", 7),
        EIGHT("8", 8),
        NINE("9", 9),
        TEN("10", 10),
        JACK("J", 10),
        QUEEN("Q", 10),
        KING("K", 10);
        // 점수와 문자 모두
        private String mark;
        private int point;
        Denomination(String mark, int point) {
            this.mark = mark;
            this.point = point;
        }
        private Denomination() {}

        public String getMark() {
            return this.mark;
        }
        public int getPoint() {
            return this.point;
        }


    }
}
