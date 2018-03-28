public boolean containsAbilityKey(String key) {
    return first(getAbilities(key, null, null)) != null;
}