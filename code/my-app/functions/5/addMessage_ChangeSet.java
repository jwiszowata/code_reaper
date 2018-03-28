public ChangeSet addMessage(Player player, ModelMessage message) {
    ServerPlayer serverPlayer = (ServerPlayer) player;
    changes.add(new FeatureChange(See.only(serverPlayer), serverPlayer, message, true));
    return this;
}