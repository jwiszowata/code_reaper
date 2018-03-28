public <T> T showChoiceDialog(Tile tile, Object obj, ImageIcon icon, String cancelKey, List<ChoiceItem<T>> choices) {
    if (choices.isEmpty())
        return null;
    FreeColChoiceDialog<T> fcd = new FreeColChoiceDialog<>(freeColClient, frame, true, obj, icon, cancelKey, choices);
    return showFreeColDialog(fcd, tile);
}