public boolean add(Locatable locatable) {
    return (locatable instanceof Goods) ? addGoods((Goods) locatable) : super.add(locatable);
}