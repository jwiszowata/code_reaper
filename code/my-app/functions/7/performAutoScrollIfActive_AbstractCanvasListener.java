protected void performAutoScrollIfActive(MouseEvent e, boolean ignoreTop) {
    if (e.getComponent().isEnabled() && getClientOptions().getBoolean(ClientOptions.AUTO_SCROLL)) {
        scroll(e.getX(), e.getY(), AUTO_SCROLL_SPACE, ignoreTop);
    } else {
        stopScrollIfScrollIsActive();
    }
}