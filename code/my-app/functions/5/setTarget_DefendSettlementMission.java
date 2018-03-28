public void setTarget(Location target) {
    if (target == null || target instanceof Settlement) {
        this.target = target;
    }
}