public ChangeSet addAbility(ServerPlayer serverPlayer, FreeColGameObject object, Ability ability, boolean add) {
    changes.add(new FeatureChange(See.only(serverPlayer), object, ability, add));
    if (add) {
        object.addAbility(ability);
    } else {
        object.removeAbility(ability);
    }
    return this;
}