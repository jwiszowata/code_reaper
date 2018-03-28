public int priceMercenaries(List<AbstractUnit> mercenaries) {
    int mercPrice = sum(mercenaries, au -> getPrice(au));
    if (!checkGold(mercPrice))
        mercPrice = getGold();
    return mercPrice;
}