public boolean accepts(Goods goods) {
    return carrier != null && carrier.canAdd(goods);
}