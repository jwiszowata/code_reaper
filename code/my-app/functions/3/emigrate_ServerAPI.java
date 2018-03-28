public boolean emigrate(Game game, int slot) {
    return ask(game, new EmigrateUnitMessage(slot));
}