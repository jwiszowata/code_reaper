public Location showSelectDestinationDialog(Unit unit) {
    return showFreeColDialog(new SelectDestinationDialog(freeColClient, frame, unit), unit.getTile());
}