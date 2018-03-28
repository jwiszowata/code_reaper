private void update() {
    boolean changed = !this.specification.getId().equals(getSelectedTC().getId());
    if (changed)
        this.specification = getSpecification();
    if (!this.difficulty.getId().equals(getSelectedDifficulty().getId())) {
        this.difficulty = getSelectedDifficulty();
        changed = true;
    }
    if (changed) {
        if (this.difficulty.isEditable()) {
            this.specification.prepare(null, this.difficulty);
        } else {
            String oldId = this.difficulty.getId();
            this.difficulty = this.specification.getDifficultyOptionGroup(oldId);
        }
        updateDifficultyBox();
    }
}