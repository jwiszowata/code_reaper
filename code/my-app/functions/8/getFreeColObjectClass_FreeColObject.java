public static <T extends FreeColObject> Class<T> getFreeColObjectClass(String name) {
    final String type = "net.sf.freecol.common.model." + capitalize(name);
    final Class<T> c = (Class<T>) Introspector.getClassByName(type);
    if (c != null)
        return c;
    logger.warning("getFreeColObjectClass could not find: " + type);
    return null;
}