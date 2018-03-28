public final void internId(final String newId) {
    final Game game = getGame();
    if (game != null && newId != null && isInternable()) {
        final String oldId = getId();
        if (!newId.equals(oldId)) {
            if (oldId != null) {
                game.removeFreeColGameObject(oldId, "override");
            }
            setId(newId);
            game.setFreeColGameObject(newId, this);
        }
    } else {
        setId(newId);
    }
}