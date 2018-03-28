public void removeNotify() {
    applet.stop();
    applet.destroy();
    try {
        super.removeNotify();
    } catch (Exception e) {
        logger.log(Level.WARNING, "Video removal crash", e);
    }
}