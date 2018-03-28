public NoAddReason getNoAddReason(Locatable locatable) {
    if (locatable instanceof Unit) {
        if (((Unit) locatable).getOwner() != getOwner()) {
            return NoAddReason.OWNED_BY_ENEMY;
        }
    } else if (locatable instanceof Goods) {
        return NoAddReason.NONE;
    }
    return super.getNoAddReason(locatable);
}