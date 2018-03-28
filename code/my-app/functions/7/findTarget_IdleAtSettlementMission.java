public Location findTarget() {
    if (isSafe())
        return null;
    final Unit unit = getAIUnit().getUnit();
    PathNode path = unit.findOurNearestOtherSettlement();
    return (path == null) ? null : Location.upLoc(path.getLastNode().getLocation());
}