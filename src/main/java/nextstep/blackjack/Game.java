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
            System.out.println("딜러는 16이하라 카드 한장을 더 받았습니다.");
        }

        //== 게이머 추가 draw 로직 ==//
        while(true) {
            List<Gamer> cardReceivedPlayers = receiveCardAllPlayers(inputView, cardDeck);
            if(isAllPlayerTurnOff(cardReceivedPlayers)) {
                break;
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

    /**
     * 모든 플레이어 추가 카드 받는 여부 확인 후 y(추가 카드 draw), n(게이머 turnoff)
     * @param inputView
     * @param cardDeck
     * @return
     */
    private List<Gamer> receiveCardAllPlayers(InputView inputView, CardDeck cardDeck) {
        // 게이머는 n할때 까지 계속 지급
        for (Gamer gamer : gamers.getGamers()) {
            if(gamer.isTurn() && inputView.isReceiveExtraCard(gamer)) {
                // 카드 받고
                gamer.receiveCard(cardDeck.draw());
                // 보유 카드 출력
                inputView.printGamerCardState(gamer);
                //System.out.println(gamer.showCards());
                gamer.turnOn();
                return gamers.getGamers();
            }else {
                gamer.turnOff();
            }
        }
        return gamers.getGamers();
    }

    /**
     * 모든 플레이어들의 turnoff 여부를 확인한다.
     * @param gamers
     * @return
     */
    private boolean isAllPlayerTurnOff(List<Gamer> gamers) {
        for (Gamer gamer : gamers) {
            if(gamer.isTurn()) {
                return false;
            }
        }
        return true;
    }
}
