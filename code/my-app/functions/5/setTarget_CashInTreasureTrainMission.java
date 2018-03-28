public void setTarget(Location target) {
    if (target == null || target instanceof Europe || target instanceof Colony) {
        this.target = target;
    }
}