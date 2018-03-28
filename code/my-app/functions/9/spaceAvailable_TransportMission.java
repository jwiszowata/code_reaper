public boolean spaceAvailable(TransportableAIObject t) {
    final List<Cargo> ts = tCopy();
    final int newSpace = t.getSpaceTaken();
    for (int i = ts.size() - 1; i >= 0; i--) {
        if (ts.get(i).getSpaceLeft() < newSpace)
            return false;
    }
    return true;
}