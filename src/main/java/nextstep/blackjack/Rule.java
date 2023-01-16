package nextstep.blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * [] 점수를 측정해준다.
 * [] 승패를 판단한다.
 */
public class Rule {

    /**
     * 점수를 측정해준다.
     *
     * @param cards
     * @return
     */
    public int getScore(List<Card> cards) {
        return 0;
    }

    /**
     * 승패를 판단한다.
     *
     * @param dealer
     * @param gamers
     */
    public Gamers judgeWinner(Dealer dealer, Gamers gamers) {
        //== 딜러보다 숫자가 높으면 우승 ==//
        int dealerPoint = dealer.openCards()
                                .getpointSum();
        for (Gamer gamer : gamers.getGamers()) {
            int playerPoint = gamer.openCards()
                                   .getpointSum();
            PlayerMoney playerMoney = gamer.getPlayerMoney();

            if(isOverLimit(gamer.openCards())) {
                playerMoney.calculateResultMoney(playerMoney.getBetMoney(), MoneyOperator.MINUS);
                continue;
            }
            if(dealerPoint > playerPoint) {
                playerMoney.calculateResultMoney(playerMoney.getBetMoney(), MoneyOperator.MINUS);
            }
            if(dealerPoint < playerPoint) {
                playerMoney.calculateResultMoney(playerMoney.getBetMoney(), MoneyOperator.PLUS);
            }
        }
        return gamers;
    }

    //== 처음 두 장의 카드 합이 21일 경우 배팅금액의 1.5배를 딜러에게 받는다. ==//
    public Gamers firstBlackJekEvent(Gamers gamers, Dealer dealer) {
        ArrayList<Gamer> nonOverPlayers = new ArrayList<>();
        for (Gamer gamer : gamers.getGamers()) {
            boolean isBlackJek = false;
            PlayerMoney playerMoney = gamer.getPlayerMoney();
            //== 딜러,게이머 블랙잭일때 ==//
            if(isBlackJek(dealer.openCards()) && isBlackJek(gamer.openCards())) {
                playerMoney.calculateResultMoney(playerMoney.getBetMoney(), MoneyOperator.PLUS);
                continue;
            }

            //== 게이머만 블랙잭할때 ==//
            if(isBlackJek(gamer.openCards())) {
                playerMoney.calculateResultMoney(Constant.BONUS_DEALER_OVER_BLACKJEKNUMBER_BLACKJEK, MoneyOperator.MULTIPLY);
                isBlackJek = true;
            }

            if(!isBlackJek) {
                nonOverPlayers.add(gamer);
            }
        }
        return new Gamers(nonOverPlayers);
    }

    //== 딜러가 21을 초과하면 플레이어들은 가지고 있는 패에 상관 없이 승리해 베팅 금액을 받는다. ==//
    public boolean isDealerOverLimitPoint(Dealer dealer) {
        Cards dealerCards = dealer.openCards();
        if (isOverLimit(dealerCards)) { // 딜러 21임?
            return true;
        }
        return false;
    }

    public void bonusToPlayers(Gamers gamers) {
        for (Gamer gamer : gamers.getGamers()) {
            PlayerMoney playerMoney = gamer.getPlayerMoney();
            playerMoney.calculateResultMoney(playerMoney.getBetMoney(), MoneyOperator.PLUS);
        }

    }

    private boolean isOverLimit(Cards Cards) {
        return Cards.getpointSum() > Constant.NUMBER_BLACKJEK;
    }

    /**
     * 블랙잭 여부 확인
     * @param cards
     * @return
     */
    private boolean isBlackJek(Cards cards) {
        if(cards.getpointSum() == Constant.NUMBER_BLACKJEK) {
            return true;
        }
        return false;
    }
}
