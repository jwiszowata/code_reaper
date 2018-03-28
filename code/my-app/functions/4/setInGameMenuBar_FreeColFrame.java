public void setInGameMenuBar() {
    setJMenuBar(new InGameMenuBar(freeColClient, new MenuMouseMotionListener(freeColClient, canvas)));
    validate();
}