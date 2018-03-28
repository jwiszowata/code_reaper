private void restartBlinking() {
    if (mapViewer.getViewMode() != GUI.MOVE_UNITS_MODE)
        return;
    for (FreeColDialog<?> f : dialogs) {
        if (f.isModal())
            return;
    }
    mapViewer.restartBlinking();
}