package nextstep.blackjack;

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
}
