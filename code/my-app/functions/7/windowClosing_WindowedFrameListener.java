public void windowClosing(WindowEvent event) {
    if (getFreeColClient().isInGame()) {
        getFreeColClient().askToQuit();
    } else {
        getFreeColClient().quit();
    }
}