public boolean updateGameOptions(OptionGroup gameOptions) {
    return send(new UpdateGameOptionsMessage(gameOptions));
}