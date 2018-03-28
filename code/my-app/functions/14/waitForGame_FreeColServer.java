public ServerGame waitForGame() {
    final int timeStep = 1000;
    int timeOut = 20000;
    ServerGame serverGame = null;
    while ((serverGame = getGame()) == null) {
        try {
            Thread.sleep(timeStep);
        } catch (InterruptedException e) {
        }
        if ((timeOut -= timeStep) <= 0)
            break;
    }
    return serverGame;
}