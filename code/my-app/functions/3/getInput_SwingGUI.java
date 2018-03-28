public String getInput(Tile tile, StringTemplate template, String defaultValue, String okKey, String cancelKey) {
    return canvas.showInputDialog(tile, template, defaultValue, okKey, cancelKey);
}