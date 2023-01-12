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

        List<Gamer> playingAfterPlayer = ExtraCardDraw(cardDeck, inputView); //== 게이머 추가 draw 로직 ==//
        ExtraDrawDealer(dealer, cardDeck); //== 딜러 카드 추가 draw 로직 ==//

        if(rule.isDealerInitBlackJek(dealer)) { //== 딜러가 21을 초과하면 배팅금액을 보너스로 지급==//
            rule.bonusToPlayers(gamers);
            // 결과 출력

            this.endGame();
        }


        //== 게임 결과 출력 ==//
        resultView.printResultCard(dealer, gamers.getGamers());

        /*for (Gamer gamer : this.gamers.getGamers()) {
            System.out.println(gamer.getPlayerMoney().getResultMoney());
        }*/
        

    }
    public static void main(String[] args) {
        new Game().play();
    }


    private void endGame() {
        System.out.print("게임종료");
        Thread.currentThread().stop();
    }

    private void ExtraDrawDealer(Dealer dealer, CardDeck cardDeck) {
        if(dealer.isReceiveExtraCard()) {
            dealer.receiveCard(cardDeck.draw());
            System.out.println("딜러는 16이하라 카드 한장을 더 받았습니다. \n");
        }
    }

    private List<Gamer> ExtraCardDraw(CardDeck cardDeck, InputView inputView) {
        List<Gamer> cardReceivedPlayers;
        while(true) {
            cardReceivedPlayers = receiveCardAllPlayers(inputView, cardDeck);
            if(isAllPlayerTurnOff(cardReceivedPlayers)) {
                break;
            }
        }
        return cardReceivedPlayers; 
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
                gamer.receiveCard(cardDeck.draw()); //== 카드 받고 ==//
                inputView.printGamerCardState(gamer); //== 보유 카드 출력 ==//
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
