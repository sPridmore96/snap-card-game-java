import java.awt.*;
import java.util.ArrayList;

public class Snap extends CardGame {
    protected Snap() {
        super("Snap");
    }
    private boolean hasSnap = false;
    private Card cardOne;
    private Card cardTwo;
    private boolean isGameActive = true;
    private void setHasSnap(boolean hasSnap) {
        this.hasSnap = hasSnap;
    }
    private void setCardOne(Card cardOne) {
        this.cardOne = cardOne;
    }
    private void setCardTwo(Card cardTwo) {
        this.cardTwo = cardTwo;
    }
    private void setGameActive(boolean gameActive) {
        isGameActive = gameActive;
    }

    private boolean isGameActive() {
        return isGameActive;
    }
    User userOne = new User("PLAYER 1");
    User userTwo = new User("PLAYER 2");

    private void welcomeAndShuffle() {
        printGreetings("Snap");
        DeckOfCards.setDeck(DeckOfCards.shuffleDeck((ArrayList) DeckOfCards.getDeck()));
    }
    private boolean handleTurn() {
        if (!(DeckOfCards.getDeck().size() == 0)) {
            setCardOne(DeckOfCards.dealCard());
            setCardTwo(DeckOfCards.dealCard());
            if (cardOne.getSymbol() == cardTwo.getSymbol()) {
                setHasSnap(true);
            }
            return hasSnap;
        } else {
            printMessage("The deck has finished. It has now been Re-Shuffled");
            DeckOfCards.setDeck(DeckOfCards.shuffleDeck((ArrayList) DeckOfCards.getUsedDeck()));
            runSnapGame();
        }
        return hasSnap;
    }
    private void handleSnap(User firstUser, User secondUser, String WinnerMessage, int userNumber) {
        secondUser.setHasPlayed(false);
        if (!hasSnap) {
            printMessage("\n\nUser " + userNumber + "...");
            printMessage(" hit enter to deal Two more Cards?");
        } else {
            printMessage("\nSNAP!!!");
            printMessage(WinnerMessage);
            if (userOne.getHasPlayed()) {
                secondUser.setScore(secondUser.getScore() + 1);
            } else {
                firstUser.setScore(firstUser.getScore() + 1);
            }
            printMessage("\n" + userOne.getName() + " Score: " + userOne.getScore() + "\n" + userTwo.getName() + " Score: " + userTwo.getScore());
            handleEndGame();
        }
        firstUser.setHasPlayed(true);
    }
    private void runSnapGame() {
        while (isGameActive) {
            getStringInput();
            if (!userOne.getHasPlayed()) {
                handleTurn();
                handleSnap(userOne, userTwo, "User 1 Wins!", 2);
            } else {
                handleTurn();
                handleSnap(userTwo, userOne, "User 2 Wins!", 1);

            }
        }
    }
    private void handleEndGame() {
        boolean isIntActive = true;
        printMessage("Do you want to play Again?? \n1 For yes \n2 For no..");
        while (isIntActive) {
            int userScanner = scanner.nextInt();
            if (userScanner == 1) {
                DeckOfCards.handleDeckRemake();
                setHasSnap(false);
                runSnapGame();
            } else {
                isIntActive = false;
                setGameActive(false);
            }
            scanner.nextInt();
        }

    }
    @Override
    public void run() {
        welcomeAndShuffle();
        runSnapGame();
    }
}