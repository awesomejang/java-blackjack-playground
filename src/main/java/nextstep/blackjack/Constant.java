package nextstep.blackjack;

public class Constant {

    private Constant() {

    }
    public static final String ANNOUNCE_GET_PLAYER_LIST = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    public static final String ANNOUNCE_GET_PLATER_BET = "%s의 배팅 금액은?";
    public static final int TOTAL_CNT_INIT_CARD = 2;
    public static final String ANNOUNCE_INIT_GAME = "딜러와 %s에게 " + TOTAL_CNT_INIT_CARD + "장의 카드를 나누었습니다.";

    public static final String SPLIT_MARK_PLAYERS_NAME =",";

    public static final int DEALER_CAN_RECEIVE_POINT = 17;

}
