package nextstep.blackjack;

import java.util.List;
import java.util.StringJoiner;

public class ResultView {

    /**
     * 딜러, 게이머의 카드 초기화 상태를 출력한다.
     * @param dealer
     * @param gamers
     */
    public void printInitCard(Dealer dealer, Gamers gamers) {
        System.out.println(String.format(Constant.ANNOUNCE_INIT_CARD_STATS, dealer.getName(), dealer.showCards()));
        for (Gamer gamer : gamers.getGamers()) {
            System.out.println(String.format(Constant.ANNOUNCE_INIT_CARD_STATS, gamer.getName(), gamer.showCards()));
        }
    }

    /**
     * 게이머 카드 + 총 점수 출력(게임 결과)
     */
    public void printResultCard(Dealer dealer, List<Gamer> gamers) {
        System.out.println(String.format(Constant.ANNOUNCE_RESULT, dealer.getName(), dealer.showCards(), dealer.openCards().getpointSum()));
        for (Gamer gamer : gamers) {
            System.out.println(String.format(Constant.ANNOUNCE_RESULT, gamer.getName(), gamer.showCards(), gamer.openCards().getpointSum()));
        }
    }


}
