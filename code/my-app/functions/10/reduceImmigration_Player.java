public void reduceImmigration() {
    if (!isColonial())
        return;
    int cost = getSpecification().getBoolean(GameOptions.SAVE_PRODUCTION_OVERFLOW) ? immigrationRequired : immigration;
    if (cost > immigration) {
        immigration = 0;
    } else {
        immigration -= cost;
    }
}