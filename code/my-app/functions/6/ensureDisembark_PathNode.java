public void ensureDisembark() {
    PathNode p = this.getLastNode();
    if (p.isOnCarrier()) {
        p.next = new PathNode(p.location, p.movesLeft, p.turns, false, p, null);
    }
}