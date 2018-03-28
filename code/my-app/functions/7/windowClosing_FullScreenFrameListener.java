public void windowClosing(WindowEvent event) {
    if (freeColClient.isInGame()) {
        freeColClient.askToQuit();
    } else {
        freeColClient.quit();
    }
}