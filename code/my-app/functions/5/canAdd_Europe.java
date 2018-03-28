public boolean canAdd(Locatable locatable) {
    if (locatable instanceof Goods)
        return true;
    return super.canAdd(locatable);
}