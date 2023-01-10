package nextstep.blackjack;

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
     * @param gamer
     */
    public void getWinner(Dealer dealer, Gamer gamer) {
        return;
    }

    //== 처음 두 장의 카드 합이 21일 경우 배팅금액의 1.5배를 딜러에게 받는다. ==//
    public boolean isDealerFirstBlackJek(Dealer dealer) {
        Cards cards = dealer.openCards();
        if (isDealerOverLimit(cards)) {
            return true;
        }
        return false;
    }

    //== 딜러가 21을 초과하면 플레이어들은 가지고 있는 패에 상관 없이 승리해 베팅 금액을 받는다. ==//
    public Gamers checkDealerOverLimit(Dealer dealer, Gamers gamers) {
        Cards dealerCards = dealer.openCards();
        if (isDealerOverLimit(dealerCards)) { // 딜러 21임?
            bonusToPlayers(gamers);
        }
        return gamers;
    }

    private void bonusToPlayers(Gamers gamers) {
        for (Gamer gamer : gamers.getGamers()) {
            PlayerMoney playerMoney = gamer.getPlayerMoney();
            playerMoney.calculateResultMoney(Constant.BONUS_DEALER_OVER_BLACKJEKNUMBER_BLACKJEK, MoneyOperator.MULTIPLY);
        }

    }

    private static boolean isDealerOverLimit(Cards dealerCards) {
        return dealerCards.getpointSum() == Constant.NUMBER_BLACKJEK;
    }


}
