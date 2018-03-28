public boolean hasAnyScouted() {
    return any(contactLevels.keySet(), p -> hasScouted(p));
}