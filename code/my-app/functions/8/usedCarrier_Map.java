private boolean usedCarrier(PathNode path) {
    while (path != null) {
        if (path.isOnCarrier())
            return true;
        path = path.previous;
    }
    return false;
}