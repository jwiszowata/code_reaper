private boolean requireOurTurn() {
    if (currentPlayerIsMyPlayer())
        return true;
    if (getFreeColClient().isInGame()) {
        getGUI().showInformationMessage("info.notYourTurn");
    }
    return false;
}