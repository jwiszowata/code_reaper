public boolean couldCarry(Goods g) {
    return canCarryGoods() && getCargoCapacity() >= g.getSpaceTaken();
}