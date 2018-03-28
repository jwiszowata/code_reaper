private void completeInternal(boolean result, ChangeSet cs) {
    final ServerPlayer demandPlayer = getUnitOwner();
    final ServerPlayer colonyPlayer = getColonyOwner();
    colonyPlayer.csCompleteNativeDemand(demandPlayer, this.unit, this.colony, this.type, this.amount, result, cs);
}