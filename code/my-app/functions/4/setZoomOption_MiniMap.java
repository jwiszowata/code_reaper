private void setZoomOption(int tileSize) {
    int zoom = tileSize / 4;
    freeColClient.getClientOptions().setInteger(ClientOptions.DEFAULT_MINIMAP_ZOOM, zoom);
}