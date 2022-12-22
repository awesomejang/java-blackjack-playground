package nextstep.blackjack;

import java.util.Scanner;

/**
 * [x] 게임에 참여할 사람 리스트 받는 안내
 */
public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public void pringGetPlayers(){
        System.out.println(Constant.ANNOUNCE_GET_PLAYER_LIST);
    }

    //public

    /**
     * 문자열을 입력받아 ','기준으로 분할하여 문자열 배열을 리턴한다.
     * @return
     */
    public String[] getPlayersNames(){
        String stringInput = getStringInput();
        return splitPlayerNames(stringInput);
    }

    /**
     * 플레이어 이름 받아서 배팅정보 요구
     * 입력값(배팅액) 리턴
     * @param player
     * @return
     */
    public int getPlayersBet(String player) {
        System.out.println(String.format(Constant.ANNOUNCE_GET_PLATER_BET, player));
        return getNumberInput();
    }

    public String getStringInput() {
        return scanner.next();
    }

    public int getNumberInput() {
        return scanner.nextInt();
    }

    private String[] splitPlayerNames(String playerNames) {
        return playerNames.split(Constant.SPLIT_MARK_PLAYERS_NAME);
    }
}
