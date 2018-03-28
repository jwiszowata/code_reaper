private boolean attackerVisible(ServerPlayer serverPlayer) {
    return serverPlayer.canSeeUnit(this.attacker);
}