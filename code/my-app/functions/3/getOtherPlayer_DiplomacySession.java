private ServerPlayer getOtherPlayer() {
    return (ServerPlayer) ((this.settlement != null) ? this.settlement.getOwner() : this.otherUnit.getOwner());
}