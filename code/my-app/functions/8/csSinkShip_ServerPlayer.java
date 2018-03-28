private void csSinkShip(Unit ship, ServerPlayer attackerPlayer, ChangeSet cs) {
    ServerPlayer shipPlayer = (ServerPlayer) ship.getOwner();
    ((ServerUnit) ship).csRemove(See.perhaps().always(shipPlayer), ship.getLocation(), cs);
    shipPlayer.invalidateCanSeeTiles();
    if (attackerPlayer != null) {
        cs.addAttribute(See.only(attackerPlayer), "sound", "sound.event.shipSunk");
    }
}