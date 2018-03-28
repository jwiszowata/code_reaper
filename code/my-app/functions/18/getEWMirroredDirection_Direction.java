public Direction getEWMirroredDirection() {
    switch(this) {
        case NW:
            return Direction.NE;
        case W:
            return Direction.E;
        case SW:
            return Direction.SE;
        case NE:
            return Direction.NW;
        case E:
            return Direction.W;
        case SE:
            return Direction.SW;
        default:
            return this;
    }
}