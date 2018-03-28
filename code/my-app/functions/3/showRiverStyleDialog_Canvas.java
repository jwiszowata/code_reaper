public String showRiverStyleDialog(List<String> styles) {
    return showFreeColDialog(new RiverStyleDialog(freeColClient, frame, styles), null);
}