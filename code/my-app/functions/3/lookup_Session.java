public static <T extends Session> T lookup(Class<T> type, FreeColGameObject o1, FreeColGameObject o2) {
    return lookup(type, o1.getId(), o2.getId());
}