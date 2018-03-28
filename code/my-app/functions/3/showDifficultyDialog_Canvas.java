public OptionGroup showDifficultyDialog(Specification spec, OptionGroup group, boolean editable) {
    return showFreeColDialog(new DifficultyDialog(freeColClient, frame, spec, group, editable), null);
}