private <T> void viewFreeColDialog(final FreeColDialog<T> freeColDialog, Tile tile) {
    PopupPosition pp = setOffsetFocus(tile);
    if (!freeColDialog.isModal()) {
        int canvasWidth = getWidth();
        int dialogWidth = freeColDialog.getWidth();
        if (dialogWidth * 2 <= canvasWidth) {
            Point location = freeColDialog.getLocation();
            if (pp == PopupPosition.CENTERED_LEFT) {
                freeColDialog.setLocation(location.x - canvasWidth / 4, location.y);
            } else if (pp == PopupPosition.CENTERED_RIGHT) {
                freeColDialog.setLocation(location.x + canvasWidth / 4, location.y);
            }
        }
    }
    dialogAdd(freeColDialog);
    if (freeColDialog.isModal())
        stopBlinking();
    freeColDialog.requestFocus();
    freeColDialog.setVisible(true);
}