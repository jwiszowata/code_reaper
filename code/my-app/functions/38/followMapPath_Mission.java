private MoveType followMapPath(PathNode path, LogBuilder lb) {
    final Unit unit = getUnit();
    final Location target = path.getLastNode().getLocation();
    for (; path != null; path = path.next) {
        if (unit.isDisposed()) {
            lb.add(", died going to ", Location.upLoc(path.getLocation()));
            return MoveType.MOVE_NO_REPAIR;
        } else if (unit.getMovesLeft() <= 0) {
            lbAt(lb);
            lb.add(", en route to ", Location.upLoc(target));
            return MoveType.MOVE_NO_MOVES;
        }
        if (path.getLocation() instanceof Europe) {
            if (AIMessage.askMoveTo(aiUnit, path.getLocation())) {
                lb.add(", sailed to Europe");
                return MoveType.MOVE_HIGH_SEAS;
            } else {
                lb.add(", failed to sail for Europe");
                return MoveType.MOVE_ILLEGAL;
            }
        }
        MoveType mt = unit.getMoveType(path.getDirection());
        if (mt == MoveType.MOVE_NO_MOVES) {
            unit.setMovesLeft(0);
            lbAt(lb);
            return MoveType.MOVE_NO_MOVES;
        }
        if (!mt.isProgress()) {
            return mt;
        }
        if (!aiUnit.move(path.getDirection())) {
            lbAt(lb);
            lb.add(", failed to move to ", Location.upLoc(path.getLocation()));
            return MoveType.MOVE_ILLEGAL;
        }
    }
    return MoveType.MOVE;
}