public void actionPerformed(ActionEvent ae) {
    if (((JRadioButtonMenuItem) ae.getSource()).isSelected()) {
        freeColClient.getClientOptions().setInteger(ClientOptions.DISPLAY_TILE_TEXT, display.ordinal());
        getGUI().refresh();
    }
}