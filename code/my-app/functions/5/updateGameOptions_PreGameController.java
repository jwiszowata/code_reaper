public void updateGameOptions() {
    OptionGroup gameOptions = getGame().getGameOptions();
    getSpecification().clean("update game options (client initiated)");
    askServer().updateGameOptions(gameOptions);
}