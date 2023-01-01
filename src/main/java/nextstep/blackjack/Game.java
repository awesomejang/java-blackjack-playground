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
        ResultView resultView = new ResultView();
        // 플레이어 초기화
        this.gamers = new Gamers(inputView.initPlayers());

        //== 초기 카드 draw 메세지 ==//
        inputView.printFirstDraw(gamers.getGamers());
        //== 카드 초기화 ==//
        for (int i = 0; i < Constant.TOTAL_CNT_INIT_CARD; i++) {
             dealer.receiveCard(cardDeck.draw());
            for (Gamer gamer : gamers.getGamers()) {
                gamer.receiveCard(cardDeck.draw());
            }
        }
        resultView.printInitCard(dealer, gamers);



    }

    public static void main(String[] args) {
        new Game().play();
    }
}
