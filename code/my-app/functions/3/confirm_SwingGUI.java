public boolean confirm(Tile tile, StringTemplate template, String okKey, String cancelKey) {
    return canvas.showConfirmDialog(tile, Utility.localizedTextArea(template), null, okKey, cancelKey);
}