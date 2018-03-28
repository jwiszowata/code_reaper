public PathNode getFirstNode() {
    PathNode path;
    for (path = this; path.previous != null; path = path.previous) ;
    return path;
}