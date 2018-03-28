public final Nation getRebelNation() {
    return find(getSpecification().getEuropeanNations(), matchKey(this, Nation::getREFNation));
}