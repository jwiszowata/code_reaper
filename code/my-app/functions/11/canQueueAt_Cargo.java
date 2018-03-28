public boolean canQueueAt(Unit carrier, int index, List<Cargo> cargoes) {
    final int maxHolds = carrier.getCargoCapacity();
    final int newSpace = this.getNewSpace();
    for (int j = index; j < cargoes.size(); j++) {
        int holds = (j == 0) ? carrier.getCargoSpaceTaken() : maxHolds - cargoes.get(j - 1).getSpaceLeft();
        holds += newSpace;
        if (holds < 0 || holds > maxHolds)
            return false;
    }
    return true;
}