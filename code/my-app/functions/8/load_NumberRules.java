public static void load(InputStream in) {
    try (FreeColXMLReader xr = new FreeColXMLReader(in)) {
        readFromXML(xr);
    } catch (Exception e) {
        logger.log(Level.WARNING, "Load parse", e);
        throw new RuntimeException("Error parsing number rules.", e);
    }
}