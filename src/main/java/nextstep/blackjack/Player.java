package nextstep.blackjack;

public interface Player {

    String getName();

    Cards openCards();

    void receiveCard(Card card);

    String showCards();
}
