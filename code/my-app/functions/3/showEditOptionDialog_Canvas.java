public boolean showEditOptionDialog(Option option) {
    return showFreeColDialog(new EditOptionDialog(freeColClient, frame, option), null);
}