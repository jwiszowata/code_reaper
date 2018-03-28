public void setTarget(Location target) {
    if (target == null || target instanceof Colony || target instanceof Tile) {
        this.target = target;
        this.colonyValue = (target instanceof Tile) ? getColonyValue((Tile) target) : -1;
    }
}