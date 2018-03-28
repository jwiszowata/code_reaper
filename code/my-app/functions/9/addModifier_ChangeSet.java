public ChangeSet addModifier(ServerPlayer serverPlayer, FreeColGameObject object, Modifier modifier, boolean add) {
    changes.add(new FeatureChange(See.only(serverPlayer), object, modifier, add));
    if (add) {
        object.addModifier(modifier);
    } else {
        object.removeModifier(modifier);
    }
    return this;
}