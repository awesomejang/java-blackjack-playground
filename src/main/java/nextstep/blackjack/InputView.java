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

    public String[] getPlayersNames(){
        String stringInput = getStringInput();
        return splitPlayerNames(stringInput);
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
