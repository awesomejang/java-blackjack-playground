package nextstep.blackjack;

import java.util.List;

/**
 * [] 점수를 측정해준다.
 * [] 승패를 판단한다.
 */
public class Rule {

    /**
     * 점수를 측정해준다.
     * @param cards
     * @return
     */
    public int getScore(List<Card> cards) {
        return 0;
    }

    /**
     * 승패를 판단한다.
     * @param dealer
     * @param gamer
     */
    public void getWinner(Dealer dealer, Gamer gamer) {
        //== 딜러가 21을 초과하면 그 시점까지 남아 있던 플레이어들은 가지고 있는 패에 상관 없이 승리해 베팅 금액을 받는다. ==//
        return;
    }

    public void checkDealerOverLimit(Dealer dealer, Gamers gamers) {

    }


}
