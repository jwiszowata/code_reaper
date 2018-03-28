public boolean fireChanges() {
    UnitType newType = null;
    Role newRole = null;
    int newRoleCount = 0;
    Location newLoc = null;
    GoodsType newWork = null;
    int newWorkAmount = 0;
    int newMovesLeft = 0;
    boolean ret = false;
    if (!unit.isDisposed()) {
        newLoc = unit.getLocation();
        if (colony != null) {
            newType = unit.getType();
            newRole = unit.getRole();
            newRoleCount = unit.getRoleCount();
            newWork = unit.getWorkType();
            newWorkAmount = (newWork == null) ? 0 : getAmount(newLoc, newWork);
        }
        newMovesLeft = unit.getMovesLeft();
    }
    FreeColGameObject oldFcgo = (FreeColGameObject) loc;
    FreeColGameObject newFcgo = (FreeColGameObject) newLoc;
    if (loc != newLoc) {
        oldFcgo.firePropertyChange(change(oldFcgo), unit, null);
        if (newLoc != null) {
            newFcgo.firePropertyChange(change(newFcgo), null, unit);
        }
        ret = true;
    }
    if (colony != null) {
        if (type != newType && newType != null) {
            String pc = ColonyChangeEvent.UNIT_TYPE_CHANGE.toString();
            colony.firePropertyChange(pc, type, newType);
            ret = true;
        } else if (role != newRole && newRole != null) {
            String pc = Tile.UNIT_CHANGE;
            colony.firePropertyChange(pc, role.toString(), newRole.toString());
            ret = true;
        }
        if (work != newWork) {
            if (work != null && oldFcgo != null && workAmount != 0) {
                oldFcgo.firePropertyChange(work.getId(), workAmount, 0);
            }
            if (newWork != null && newFcgo != null && newWorkAmount != 0) {
                newFcgo.firePropertyChange(newWork.getId(), 0, newWorkAmount);
            }
            ret = true;
        } else if (workAmount != newWorkAmount) {
            newFcgo.firePropertyChange(newWork.getId(), workAmount, newWorkAmount);
            ret = true;
        }
    }
    if (role != newRole && newRole != null) {
        unit.firePropertyChange(Unit.ROLE_CHANGE, role, newRole);
        ret = true;
    } else if (roleCount != newRoleCount && newRoleCount >= 0) {
        unit.firePropertyChange(Unit.ROLE_CHANGE, roleCount, newRoleCount);
        ret = true;
    }
    if (unit.getGoodsContainer() != null) {
        ret |= unit.getGoodsContainer().fireChanges();
    }
    if (!units.equals(unit.getUnitList())) {
        unit.firePropertyChange(Unit.CARGO_CHANGE, null, unit);
        ret = true;
    }
    if (movesLeft != newMovesLeft) {
        unit.firePropertyChange(Unit.MOVE_CHANGE, movesLeft, newMovesLeft);
        ret = true;
    }
    return ret;
}