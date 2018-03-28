public boolean showConfirmDialog(Tile tile, Object obj, ImageIcon icon, String okKey, String cancelKey) {
    FreeColConfirmDialog fcd = new FreeColConfirmDialog(freeColClient, frame, true, obj, icon, okKey, cancelKey);
    return showFreeColDialog(fcd, tile);
}