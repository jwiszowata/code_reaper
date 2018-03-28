public <T extends FreeColObject> T copy(Game game, Class<T> returnClass, Player player) {
    T ret = null;
    try (FreeColXMLReader xr = new FreeColXMLReader(new StringReader(this.serialize(player)))) {
        ret = xr.copy(game, returnClass);
    } catch (Exception e) {
        logger.log(Level.WARNING, "Failed to copy: " + getId(), e);
    }
    return ret;
}