public boolean csEquipForRole(Unit unit, Role role, int roleCount, Random random, ChangeSet cs) {
    boolean ret = equipForRole(unit, role, roleCount);
    if (ret) {
        ServerPlayer serverPlayer = (ServerPlayer) getOwner();
        cs.addPartial(See.only(serverPlayer), serverPlayer, "gold", String.valueOf(serverPlayer.getGold()));
        cs.add(See.only(serverPlayer), unit);
        serverPlayer.flushExtraTrades(random);
        serverPlayer.csFlushMarket(cs);
    }
    return ret;
}