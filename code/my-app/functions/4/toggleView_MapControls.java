public void toggleView() {
    miniMap.setToggleBordersOption(!getClientOptions().getBoolean(ClientOptions.MINIMAP_TOGGLE_BORDERS));
    repaint();
}