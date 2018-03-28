private <T> T showFreeColDialog(FreeColDialog<T> freeColDialog, Tile tile) {
    viewFreeColDialog(freeColDialog, tile);
    T response = freeColDialog.getResponse();
    remove(freeColDialog);
    dialogRemove(freeColDialog);
    if (freeColDialog.isModal())
        restartBlinking();
    return response;
}