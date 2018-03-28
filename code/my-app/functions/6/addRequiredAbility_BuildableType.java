private void addRequiredAbility(String tag, boolean value) {
    if (requiredAbilities == null) {
        requiredAbilities = new HashMap<>();
    }
    requiredAbilities.put(tag, value);
}