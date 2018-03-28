public AnimateMoveMessage toMessage(ServerPlayer serverPlayer) {
    if (!isNotifiable(serverPlayer))
        return null;
    Unit u = (serverPlayer.owns(unit)) ? unit : unit.reduceVisibility(oldLocation.getTile(), serverPlayer);
    return new AnimateMoveMessage(u, oldLocation.getTile(), newTile, !seeOld(serverPlayer));
}