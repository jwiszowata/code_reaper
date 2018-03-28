public void setTarget(Location target) {
    if (target == null || target instanceof Colony || target instanceof Europe || target instanceof Unit) {
        this.target = target;
    }
}