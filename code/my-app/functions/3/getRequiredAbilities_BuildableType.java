public Map<String, Boolean> getRequiredAbilities() {
    return (requiredAbilities == null) ? Collections.<String, Boolean>emptyMap() : new HashMap<>(requiredAbilities);
}