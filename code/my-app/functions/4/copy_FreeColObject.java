public <T extends FreeColObject> T copy(Game game, Player player) {
    @SuppressWarnings("unchecked") Class<T> returnClass = (Class<T>) this.getClass();
    return this.copy(game, returnClass, player);
}