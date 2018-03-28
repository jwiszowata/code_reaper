private void featureChange(FeatureChangeMessage message) {
    final Game game = getGame();
    final Specification spec = game.getSpecification();
    final FreeColGameObject parent = message.getParent(game);
    final List<FreeColObject> children = message.getChildren();
    final boolean add = message.getAdd();
    if (parent == null) {
        logger.warning("featureChange with null parent.");
        return;
    }
    if (children.isEmpty()) {
        logger.warning("featureChange with no children.");
        return;
    }
    for (FreeColObject fco : children) {
        if (fco instanceof Ability) {
            if (add) {
                parent.addAbility((Ability) fco);
            } else {
                parent.removeAbility((Ability) fco);
            }
        } else if (fco instanceof Modifier) {
            if (add) {
                parent.addModifier((Modifier) fco);
            } else {
                parent.removeModifier((Modifier) fco);
            }
        } else if (fco instanceof HistoryEvent) {
            if (parent instanceof Player && add) {
                Player player = (Player) parent;
                player.addHistory((HistoryEvent) fco);
            } else {
                logger.warning("Feature change NYI: " + parent + "/" + add + "/" + fco);
            }
        } else if (fco instanceof LastSale) {
            if (parent instanceof Player && add) {
                Player player = (Player) parent;
                player.addLastSale((LastSale) fco);
            } else {
                logger.warning("Feature change NYI: " + parent + "/" + add + "/" + fco);
            }
        } else if (fco instanceof ModelMessage) {
            if (parent instanceof Player && add) {
                Player player = (Player) parent;
                player.addModelMessage((ModelMessage) fco);
            } else {
                logger.warning("Feature change NYI: " + parent + "/" + add + "/" + fco);
            }
        } else {
            logger.warning("featureChange unrecognized: " + fco);
        }
    }
}