public OptionGroup showDifficultyDialog() {
    final Specification spec = getSpecification();
    return canvas.showDifficultyDialog(spec, spec.getDifficultyOptionGroup(), false);
}