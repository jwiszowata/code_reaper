public boolean saveAndQuit() {
    if (!saveGame())
        return false;
    getFreeColClient().quit();
    return true;
}