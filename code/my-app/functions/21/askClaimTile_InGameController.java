private boolean askClaimTile(Player player, Tile tile, FreeColGameObject claimant, int price) {
    final Player owner = tile.getOwner();
    if (price < 0) {
        return false;
    } else if (price > 0) {
        ClaimAction act = getGUI().getClaimChoice(tile, player, price, owner);
        if (act == null)
            return false;
        switch(act) {
            case CLAIM_ACCEPT:
                break;
            case CLAIM_STEAL:
                price = STEAL_LAND;
                break;
            default:
                logger.warning("Claim dialog fail: " + act);
                return false;
        }
    }
    return askServer().claimTile(tile, claimant, price) && player.owns(tile);
}