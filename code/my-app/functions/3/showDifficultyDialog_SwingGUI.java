public OptionGroup showDifficultyDialog(Specification spec, OptionGroup group) {
    return canvas.showDifficultyDialog(spec, group, group.isEditable());
}