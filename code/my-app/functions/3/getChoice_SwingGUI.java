public <T> T getChoice(Tile tile, Object explain, Unit unit, String cancelKey, List<ChoiceItem<T>> choices) {
    return canvas.showChoiceDialog(tile, explain, new ImageIcon(imageLibrary.getUnitImage(unit)), cancelKey, choices);
}