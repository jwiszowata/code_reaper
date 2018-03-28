private boolean defenderVisible(ServerPlayer serverPlayer) {
    return serverPlayer.canSeeUnit(this.defender) && (!this.defenderInSettlement || serverPlayer.owns(this.defender));
}