private FreeColObject lookup(Game game, String id) {
    FreeColObject fco = (shouldIntern()) ? null : uninterned.get(id);
    return (fco != null) ? fco : (game == null) ? null : game.getFreeColGameObject(id);
}