public boolean victory(Boolean quit) {
    if (quit) {
        getFreeColClient().getConnectController().newGame();
    } else {
        askServer().continuePlaying();
    }
    return true;
}