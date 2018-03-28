private MoveType getNavalMoveType(@SuppressWarnings("unused") Tile from, Tile target) {
    if (target == null) {
        return (getOwner().canMoveToEurope()) ? MoveType.MOVE_HIGH_SEAS : MoveType.MOVE_NO_EUROPE;
    } else if (isDamaged()) {
        return MoveType.MOVE_NO_REPAIR;
    }
    if (target.isLand()) {
        Settlement settlement = target.getSettlement();
        if (settlement == null) {
            return MoveType.MOVE_NO_ACCESS_LAND;
        } else if (settlement.getOwner() == getOwner()) {
            return MoveType.MOVE;
        } else if (isTradingUnit()) {
            return getTradeMoveType(settlement);
        } else {
            return MoveType.MOVE_NO_ACCESS_SETTLEMENT;
        }
    } else {
        Unit defender = target.getFirstUnit();
        if (defender != null && !getOwner().owns(defender)) {
            return (isOffensiveUnit()) ? MoveType.ATTACK_UNIT : MoveType.MOVE_NO_ATTACK_CIVILIAN;
        } else {
            return (target.isDirectlyHighSeasConnected()) ? MoveType.MOVE_HIGH_SEAS : MoveType.MOVE;
        }
    }
}