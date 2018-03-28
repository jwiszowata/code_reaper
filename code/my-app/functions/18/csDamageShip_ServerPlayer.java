private void csDamageShip(Unit ship, Location repair, ChangeSet cs) {
    ServerPlayer player = (ServerPlayer) ship.getOwner();
    for (Goods g : ship.getGoodsContainer().getCompactGoods()) {
        ship.remove(g);
    }
    for (Unit u : ship.getUnitList()) {
        ship.remove(u);
        ((ServerUnit) u).csRemove(See.only(player), null, cs);
    }
    Location shipLoc = (repair instanceof Colony) ? repair.getTile() : repair;
    ship.setHitPoints(1);
    ship.setDestination(null);
    ship.setLocation(shipLoc);
    ship.setState(Unit.UnitState.ACTIVE);
    ship.setMovesLeft(0);
    cs.add(See.only(player), (FreeColGameObject) shipLoc);
    player.invalidateCanSeeTiles();
}