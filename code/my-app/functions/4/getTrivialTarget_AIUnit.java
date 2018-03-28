public Location getTrivialTarget() {
    PathNode path = unit.getTrivialPath();
    return (path == null) ? null : Location.upLoc(path.getLastNode().getLocation());
}