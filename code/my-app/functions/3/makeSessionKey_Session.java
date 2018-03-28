protected static String makeSessionKey(Class type, FreeColGameObject o1, FreeColGameObject o2) {
    return makeSessionKey(type, o1.getId(), o2.getId());
}