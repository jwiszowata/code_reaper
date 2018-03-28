public void ownerChanged(FreeColGameObject source, Player oldOwner, Player newOwner) {
    AIObject ao = getAIObject(source);
    if (ao == null)
        return;
    logger.finest("Owner changed for " + source.getId() + " with AI object: " + ao);
    AIPlayer oldAIOwner = getAIPlayer(oldOwner);
    if (oldAIOwner != null)
        oldAIOwner.removeAIObject(ao);
    if (ao != null) {
        ao.dispose();
        setFreeColGameObject(source.getId(), source);
    }
}