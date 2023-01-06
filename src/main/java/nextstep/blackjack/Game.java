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
        this.gamers = new Gamers(inputView.initPlayers()); // 플레이어 초기화

        inputView.printFirstDraw(gamers.getGamers()); //== 초기 카드 draw 메세지 ==//
        initPhase(dealer, cardDeck); //== 카드 초기화 ==//
        resultView.printInitCard(dealer, gamers); //== 초기 카드결과 출력 ==//

        //== 카드 추가 draw 로직 ==//
        if(dealer.isReceiveExtraCard()) {
            dealer.receiveCard(cardDeck.draw());
        }
        //== 게이머 추가 draw 로직 ==//
        while(true) {
            // 게이머는 n할때 까지 계속 지급
            for (Gamer gamer : gamers.getGamers()) {
                boolean isAllPlayerTurnOff = false;
                if(inputView.isReceiveExtraCard(gamer)) {
                    // 카드 받고
                    gamer.receiveCard(cardDeck.draw());
                    // 보유 카드 출력
                    System.out.println(gamer.showCards());
                    gamer.turnOn();
                }else {
                    gamer.turnOff();
                }
            }
        }


    }

    public static void main(String[] args) {
        new Game().play();
    }

    private void initPhase(Dealer dealer, CardDeck cardDeck) {
        for (int i = 0; i < Constant.TOTAL_CNT_INIT_CARD; i++) {
            dealer.receiveCard(cardDeck.draw());
            for (Gamer gamer : gamers.getGamers()) {
                gamer.receiveCard(cardDeck.draw());
            }
        }
    }
}
