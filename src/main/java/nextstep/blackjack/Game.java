package nextstep.blackjack;

public class Game {

    /**
     * 게임 실행
     */
    public void play() {
        System.out.println("============Game Start============");
        Dealer dealer = new Dealer();
        Gamer gamer = new Gamer();
        Rule rule = new Rule();
        CardDeck cardDeck = new CardDeck();

    }
}
