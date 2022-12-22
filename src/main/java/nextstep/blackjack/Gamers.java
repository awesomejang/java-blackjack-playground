package nextstep.blackjack;

import java.util.LinkedList;
import java.util.List;

public class Gamers {
    private List<Gamer> gamers = new LinkedList<>();

    /**
     * 게이머 추가
     * @param gamer
     */
    public void addGamer(Gamer gamer) {
        gamers.add(gamer);
    }

}
