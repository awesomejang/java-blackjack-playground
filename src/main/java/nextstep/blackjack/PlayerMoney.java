package nextstep.blackjack;

import java.math.BigDecimal;

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
     * @param amount
     * @param moneyOperator
     * @return
     */
    public int calculateResultMoney(int amount, MoneyOperator moneyOperator) {
        switch (moneyOperator) {
            case PLUS: return resultMoney += amount;
            case MINUS: return resultMoney -= amount;
            case MULTIPLY: return resultMoney += new BigDecimal(betMoney).multiply(new BigDecimal(String.valueOf(amount)))
                                                                         .intValue();
            default: return resultMoney;
        }
    }
}
