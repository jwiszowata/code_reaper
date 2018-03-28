public void setTarget(Location target) {
    if (target == null || target instanceof Settlement || target instanceof Tile) {
        this.target = target;
    }
}