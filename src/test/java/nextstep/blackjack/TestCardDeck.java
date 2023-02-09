package nextstep.blackjack;

public class TestCardDeck {

    public static Dealer getDealer() {
        Dealer dealer = new Dealer();
        dealer.receiveCard(new Card(Card.Pattern.DIAMOND, Card.Denomination.ACE));
        dealer.receiveCard(new Card(Card.Pattern.DIAMOND, Card.Denomination.TEN)); //== 11 ==//

        return dealer;
    }

    public static Dealer getOverLimitDealer() {
        Dealer dealer = new Dealer();
        dealer.receiveCard(new Card(Card.Pattern.CLOVER, Card.Denomination.FOUR));
        dealer.receiveCard(new Card(Card.Pattern.CLOVER, Card.Denomination.JACK));
        dealer.receiveCard(new Card(Card.Pattern.CLOVER, Card.Denomination.TEN)); // 24
        return dealer;
    }

    public static Gamer getBlackJekGamer(String name, int betMoney) {
        Gamer gamer = new Gamer(name, betMoney);
        gamer.receiveCard(new Card(Card.Pattern.CLOVER, Card.Denomination.QUEEN));
        gamer.receiveCard(new Card(Card.Pattern.CLOVER, Card.Denomination.ACE));
        gamer.receiveCard(new Card(Card.Pattern.CLOVER, Card.Denomination.KING)); //== blackjek ==//
        return gamer;
    }

}

