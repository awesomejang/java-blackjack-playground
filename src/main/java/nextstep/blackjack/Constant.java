package nextstep.blackjack;

public class Constant {

    private Constant() {

    }
    public static final String ANNOUNCE_GET_PLAYER_LIST = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    public static final String ANNOUNCE_GET_PLATER_BET = "%s의 배팅 금액은?";
    public static final int TOTAL_CNT_INIT_CARD = 2;
    public static final int CAN_RECEIVE_DEALER_POINT = 16; // 딜러 초기 허용 최대 점수
    public static final String ANNOUNCE_INIT_GAME = "딜러와 %s에게 " + TOTAL_CNT_INIT_CARD + "장의 카드를 나누었습니다.";

    public static final String ANNOUNCE_INIT_CARD_STATS = "%s카드: %s";
    public static final String ANNOUNCE_RESULT = ANNOUNCE_INIT_CARD_STATS +  " - " + "결과: %s"; //== 최종 카드 결과 표기 ==//

    public static final String STOP_RECEIVE_CARD = "n";
    public static final String CONTINUE_RECEIVE_CARD = "y";

    public static final String ANNOUNCE_RECEIVE_EXTRA_CARD = "%s는 한장의 카드를 더 받겠습니까?(예는 " + CONTINUE_RECEIVE_CARD + ", " + "아니요는 " + STOP_RECEIVE_CARD + ")";

    public static final String SPLIT_MARK_PLAYERS_NAME =",";

    public static final int DEALER_CAN_RECEIVE_POINT = 17;

}
