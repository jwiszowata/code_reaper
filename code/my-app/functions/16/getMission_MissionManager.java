public static Mission getMission(Game game, FreeColXMLReader xr) throws XMLStreamException {
    String tag = xr.getLocalName();
    Constructor<? extends Mission> c = missionMap.get(tag);
    if (c == null) {
        logger.warning("Unknown type of mission: '" + tag + "'.");
        xr.nextTag();
        return null;
    } else {
        try {
            return c.newInstance(game, xr);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Failed to instatiate mission with tag: " + tag, e);
            return null;
        }
    }
}