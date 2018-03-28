public final Level getLevel() {
    return find(Level.values(), level -> value <= level.getLimit(), Level.HATEFUL);
}