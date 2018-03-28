public void toggleFogOfWar() {
    miniMap.setToggleFogOfWarOption(!getClientOptions().getBoolean(ClientOptions.MINIMAP_TOGGLE_FOG_OF_WAR));
    repaint();
}