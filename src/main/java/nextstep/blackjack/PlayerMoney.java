package nextstep.blackjack;

public class PlayerMoney {
    private int betMoney;
    private int resultMoney;

    public PlayerMoney(int betMoney) {
        this.betMoney = betMoney;
        this.resultMoney = 0;
    }

    public int getBetMoney() {
        return betMoney;
    }

    public int getResultMoney() {
        return resultMoney;
    }

    /**
     * 게임결과 합계금액을 변경하고 변경값을 리턴한다.
     * @param money
     * @param moneyOperator
     * @return
     */
    public int calculateResultMoney(int money, MoneyOperator moneyOperator) {
        switch (moneyOperator) {
            case PLUS: return resultMoney += money;
            case MINUS: return resultMoney -= money;
            case MULTIPLY: return resultMoney *= money;
            default: return resultMoney;
        }
    }
}
