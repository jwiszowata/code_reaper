public boolean isUndead() {
    Unit u = getFirstUnit();
    return u != null && u.isUndead();
}