package nextstep.blackjack;

import java.util.List;

// [] 게임의 참가자들을 보유한다.
// [] 참가자들의 배팅 금액을 관리한다.
// [] Gamer -> Coadrs 로 변경하고
// 참여자이름, 배팅금액을 Gamer 필드에 넣고 푸는 방법을 생각해봐야할듯
public class Game {

    //private List<Gamer> gamers;
    private Gamers gamers;

    /**
     * 게임 실행
     */
    public void play() {
        System.out.println("============Game Start============");

        Dealer dealer = new Dealer();
        Rule rule = new Rule();
        CardDeck cardDeck = new CardDeck();
        InputView inputView = new InputView();

        this.gamers = new Gamers(inputView.initPlayers());


    }

    public static void main(String[] args) {
        new Game().play();
    }
}
