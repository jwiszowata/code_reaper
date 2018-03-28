public Direction getNewDirection(Direction oldDirection) {
    switch(this) {
        case STRAIGHT_AHEAD:
            return oldDirection;
        case RIGHT_TURN:
            switch(oldDirection) {
                case NE:
                    return Direction.SE;
                case SE:
                    return Direction.SW;
                case SW:
                    return Direction.NW;
                case NW:
                    return Direction.NE;
                default:
                    return oldDirection;
            }
        case LEFT_TURN:
            switch(oldDirection) {
                case NE:
                    return Direction.NW;
                case SE:
                    return Direction.NE;
                case SW:
                    return Direction.SE;
                case NW:
                    return Direction.SW;
                default:
                    return oldDirection;
            }
    }
    return oldDirection;
}