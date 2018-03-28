public void removeKeyStroke(KeyStroke keyStroke) {
    for (OptionUpdater optionUpdater : optionUpdaters) {
        if (optionUpdater instanceof FreeColActionUI) {
            ((FreeColActionUI) optionUpdater).removeKeyStroke(keyStroke);
        }
    }
}