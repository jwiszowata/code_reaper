public void changeClientState(boolean inGame) {
    if (inGame) {
        setDOMMessageHandler(this.inGameInputHandler);
    } else {
        setDOMMessageHandler(this.preGameInputHandler);
    }
    this.inGame = inGame;
}