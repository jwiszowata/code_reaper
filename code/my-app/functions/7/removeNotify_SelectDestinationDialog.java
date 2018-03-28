public void removeNotify() {
    super.removeNotify();
    removeAll();
    this.destinations.clear();
    this.onlyMyColoniesBox = null;
    this.comparatorBox = null;
}