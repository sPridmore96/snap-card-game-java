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

    User userOne = new User("Sam");
    User userTwo = new User("Emily");

    private void welcomeAndShuffle() {
        printGreetings("Snap");
        DeckOfCards.shuffleTheDeck();
    }
    private void runSnapGame() {
        while (isGameActive) {
            if (!userOne.getHasPlayed()) {
                handleTurn();
                handleTurnResult(userOne, userTwo, "User 1 Wins!", 2);
            } else {
                handleTurn();
                handleTurnResult(userTwo, userOne, "User 2 Wins!", 1);

            }
        }
    }
    private void handleTurn() {
        long start = System.currentTimeMillis();
        long end = start + 3 * 1000;
        if (!(DeckOfCards.getDeck().size() == 0)) {
            setCardOne(DeckOfCards.dealCard());
            setCardTwo(DeckOfCards.dealCard());
                String userString = scanner.nextLine();
                if(cardOne.getSymbol() == cardTwo.getSymbol() && userString.contains("snap") && System.currentTimeMillis() < end) {
                    setHasSnap(true);
                }
        }
    }
    private void handleTurnResult(User firstUser, User secondUser, String WinnerMessage, int userNumber) {
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
            printMessage("\n" + userOne.getName() + "'s Score: " + userOne.getScore() + "\n" + userTwo.getName() + "'s Score: " + userTwo.getScore());
            handleEndGame();
        }
        firstUser.setHasPlayed(true);
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
            scanner.nextInt();
            } else if(userScanner == 2) {
                isIntActive = false;
                isGameActive = false;
                break;
            }
        }

    }

    @Override
    public void run() {
        welcomeAndShuffle();
        runSnapGame();
    }
}
