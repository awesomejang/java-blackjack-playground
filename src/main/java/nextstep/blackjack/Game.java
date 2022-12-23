package nextstep.blackjack;

import java.util.List;

// [x] 게임의 참가자들을 보유한다.
// [x] 참가자들의 배팅 금액을 관리한다.
// [x] Gamer -> Coadrs 로 변경하고
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

        // 플레이어 초기화
        gamers = new Gamers(inputView.initPlayers());

        //
        inputView.printFirstDraw(gamers.getGamers());

        for (int i = 0; i < Constant.TOTAL_CNT_INIT_CARD; i++) {
             dealer.receiveCard(cardDeck.draw());
            for (int j = 0; j < gamers.gamerSize(); j++) {
                 //gamers.

            }
        }



    }

    public static void main(String[] args) {
        new Game().play();
    }
}
