public void enableMapControls(boolean enable) {
    if (enable && mapControls == null) {
        String className = getClientOptions().getString(ClientOptions.MAP_CONTROLS);
        try {
            final String panelName = "net.sf.freecol.client.gui.panel." + lastPart(className, ".");
            Class<?> controls = Class.forName(panelName);
            mapControls = (MapControls) controls.getConstructor(FreeColClient.class).newInstance(getFreeColClient());
            logger.info("Instantiated " + panelName);
        } catch (Exception e) {
            logger.log(Level.INFO, "Fallback to CornerMapControls from " + className, e);
            mapControls = new CornerMapControls(getFreeColClient());
        }
        if (mapControls != null) {
            mapControls.addToComponent(canvas);
            mapControls.update();
        }
    } else if (!enable && mapControls != null) {
        mapControls.removeFromComponent(canvas);
        mapControls = null;
    }
}