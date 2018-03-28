public void actionPerformed(ActionEvent ae) {
    getGUI().miniMapToggleFogOfWarControls();
    if (freeColClient.getClientOptions().getBoolean(ClientOptions.MINIMAP_TOGGLE_FOG_OF_WAR)) {
        addImageIcons("toggle_fog_of_war");
    } else {
        addImageIcons("toggle_fog_of_war_no");
    }
}