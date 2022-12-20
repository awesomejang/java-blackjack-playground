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




    /**
     * 참여자 이름을 받아 ','기준으로 split하여 리턴한다.
     * @return
     */
    public String[] getPlayersNames(){
        String stringInput = getStringInput();
        return splitPlayerNames(stringInput);
    }

    /**
     * 문자열 입력값을 받는다.
     * @return
     */
    public String getStringInput() {
        return scanner.next();
    }

    /**
     * 숫자형 입력값을 받는다.
     * @return
     */
    public int getNumberInput() {
        return scanner.nextInt();
    }

    /**
     * name,name1 형식의 문자열을 ','기준으로 split한다.
     * @param playerNames
     * @return
     */
    private String[] splitPlayerNames(String playerNames) {
        return playerNames.split(Constant.SPLIT_MARK_PLAYERS_NAME);
    }
}
