public OptionGroup showGameOptionsDialog(boolean editable, boolean custom) {
    GameOptionsDialog god = new GameOptionsDialog(freeColClient, frame, editable, custom);
    return showFreeColDialog(god, null);
}