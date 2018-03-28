public void actionPerformed(ActionEvent ae) {
    getGUI().miniMapToggleViewControls();
    if (freeColClient.getClientOptions().getBoolean(ClientOptions.MINIMAP_TOGGLE_BORDERS)) {
        addImageIcons("toggle_view_politics");
    } else {
        addImageIcons("toggle_view_economic");
    }
}