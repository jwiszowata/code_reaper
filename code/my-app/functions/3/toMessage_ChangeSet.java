public SetStanceMessage toMessage(ServerPlayer serverPlayer) {
    return (!isNotifiable(serverPlayer)) ? null : new SetStanceMessage(stance, first, second);
}