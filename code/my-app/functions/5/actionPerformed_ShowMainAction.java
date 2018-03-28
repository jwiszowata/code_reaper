public void actionPerformed(ActionEvent ae) {
    if (getGUI().confirmStopGame()) {
        getFreeColClient().getConnectController().mainTitle();
    }
}