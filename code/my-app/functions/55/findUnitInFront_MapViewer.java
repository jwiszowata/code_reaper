private Unit findUnitInFront(Tile unitTile) {
    Unit result;
    if (unitTile == null || unitTile.isEmpty()) {
        result = null;
    } else if (activeUnit != null && activeUnit.getTile() == unitTile) {
        result = activeUnit;
    } else if (unitTile.hasSettlement()) {
        result = null;
    } else if (activeUnit != null && activeUnit.isOffensiveUnit()) {
        result = unitTile.getDefendingUnit(activeUnit);
    } else {
        List<Unit> units = unitTile.getUnitList();
        result = units.remove(0);
        int best = result.getMovesLeft();
        boolean carrier, active = result.getState() == Unit.UnitState.ACTIVE;
        for (Unit u : units) {
            carrier = false;
            if (active) {
                if (u.getState() == Unit.UnitState.ACTIVE) {
                    if (best < u.getMovesLeft()) {
                        best = u.getMovesLeft();
                        result = u;
                    }
                } else {
                    carrier = !u.isEmpty();
                }
            } else if (u.getState() == Unit.UnitState.ACTIVE) {
                active = true;
                best = u.getMovesLeft();
                result = u;
            } else {
                if (best < u.getMovesLeft()) {
                    best = u.getMovesLeft();
                    result = u;
                }
                carrier = !u.isEmpty();
            }
            if (carrier) {
                for (Unit c : u.getUnitList()) {
                    if (active) {
                        if (best < c.getMovesLeft()) {
                            best = c.getMovesLeft();
                            result = c;
                        }
                    } else if (c.getState() == Unit.UnitState.ACTIVE) {
                        active = true;
                        best = c.getMovesLeft();
                        result = c;
                    }
                }
            }
        }
    }
    return result;
}