package nextstep.blackjack;

import java.util.List;
import java.util.StringJoiner;

/**
 * [x] 추가로 카드를 받는다.
 * [x] 뽑은 카드를 소유한다.
 * [x] 카드를 오픈한다.
 * [] 보유한 카드를 확인한다.
 */
public class Gamer implements Player{

    //private List<Card> cards;
    private String name;
    //private int betAmount;
    private PlayerMoney playerMoney;

    private boolean turn = true; //== 카드받기 턴 ==//
    private Cards cards = new Cards();

    public Gamer(String name, int betMoney) {
        this.name = name;
        this.playerMoney = new PlayerMoney(betMoney);
        //this.betAmount = betMoney;
    }

    @Override
    public String getName() {
        return name;
    }

    public PlayerMoney getPlayerMoney() {
        return playerMoney;
    }

    /*public int getBetAmount() {
        return betAmount;
    }*/

    /**
     * 카드를 오픈한다.
     * @return
     */
    public Cards openCards() {
        return cards;
    }

    /**
     * 카드를 한장 받는다.
     * @param card
     */
    @Override
    public void receiveCard(Card card) {
        this.cards.addCard(card);
        //cards.add(card);
    }

    /**
     * 현재 보유한 카드목록을 출력한다.
     * @return
     */
    @Override
    public String showCards() {
        StringJoiner stringJoiner = new StringJoiner(Constant.SPLIT_MARK_PLAYERS_NAME);
        //stringJoiner.add("현재 보유 카드목록 \n");
        for (Card card : cards.getCards()) {
            stringJoiner.add(card.toString());
            //stringJoiner.add("\n");
        }
        return stringJoiner.toString();
    }

    public void turnOff() {
        this.setTurn(false);
    }

    public void turnOn() {
        this.setTurn(true);
    }

    private void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean isTurn() {
        return this.turn;
    }
}
