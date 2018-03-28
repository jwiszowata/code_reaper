public boolean remove(Locatable locatable) {
    return (locatable instanceof Goods) ? removeGoods((Goods) locatable) != null : super.remove(locatable);
}