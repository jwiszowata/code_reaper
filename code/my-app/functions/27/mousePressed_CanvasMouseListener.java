public void mousePressed(MouseEvent e) {
    if (!e.getComponent().isEnabled())
        return;
    int me = e.getButton();
    if (e.isPopupTrigger())
        me = MouseEvent.BUTTON3;
    Tile tile = canvas.convertToMapTile(e.getX(), e.getY());
    switch(me) {
        case MouseEvent.BUTTON1:
            canvas.setDragPoint(e.getX(), e.getY());
            if (!doubleClickTimer.isRunning()) {
                centerX = e.getX();
                centerY = e.getY();
            }
            doubleClickTimer.start();
            canvas.requestFocus();
            break;
        case MouseEvent.BUTTON2:
            immediateGoto(tile);
            break;
        case MouseEvent.BUTTON3:
            immediatePopup(tile, e.getX(), e.getY());
            break;
        default:
            break;
    }
}