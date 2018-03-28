public boolean canAttack(Unit defender) {
    if (!isOffensiveUnit() || defender == null || !defender.hasTile())
        return false;
    Tile tile = defender.getTile();
    return (isNaval()) ? !tile.hasSettlement() && defender.isNaval() : !defender.isNaval() || defender.isBeached();
}