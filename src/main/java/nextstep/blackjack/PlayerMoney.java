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
    public int calculateResultMoney(double amount, MoneyOperator moneyOperator) {
        //int num1 = amount;
        int target;
        if(moneyOperator.name().equals("MULTIPLY")) {
            //target = betMoney;
            resultMoney += moneyOperator.calculate(amount, betMoney);
        }else {
            //target = resultMoney;
            resultMoney = moneyOperator.calculate(amount, resultMoney);
        }
        /*switch (moneyOperator) {
            case PLUS: resultMoney += amount;
                break;
            case MINUS:resultMoney -= amount;
                break;
             case MULTIPLY: return resultMoney += new BigDecimal(betMoney).multiply(new BigDecimal(amount)).intValue();
                //break;            //default: return resultMoney;
        }*/
        return resultMoney;
    }
}
