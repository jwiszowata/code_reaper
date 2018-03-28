public boolean contains(Locatable locatable) {
    return (locatable instanceof Goods) ? goodsContainer.contains((Goods) locatable) : super.contains(locatable);
}