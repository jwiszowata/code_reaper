protected void performDragScrollIfActive(MouseEvent e) {
    if (e.getComponent().isEnabled() && getClientOptions().getBoolean(ClientOptions.MAP_SCROLL_ON_DRAG)) {
        scroll(e.getX(), e.getY(), DRAG_SCROLL_SPACE, false);
    } else {
        stopScrollIfScrollIsActive();
    }
}