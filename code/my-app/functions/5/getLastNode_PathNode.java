public PathNode getLastNode() {
    PathNode path;
    for (path = this; path.next != null; path = path.next) ;
    return path;
}