private boolean checkAbilities(BuildableType bt, List<String> lockReason) {
    final Specification spec = getSpecification();
    final int oldSize = lockReason.size();
    forEachMapEntry(bt.getRequiredAbilities(), e -> {
        final String id = e.getKey();
        final boolean value = e.getValue();
        if (this.featureContainer.hasAbility(id, null, null) != value && this.colony.hasAbility(id) != value) {
            FreeColSpecObjectType source = first(spec.getTypesProviding(id, value));
            lockReason.add((source != null) ? Messages.getName(source) : Messages.getName(bt));
        }
    });
    return lockReason.size() == oldSize;
}