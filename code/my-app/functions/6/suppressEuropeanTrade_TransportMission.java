public void suppressEuropeanTrade(GoodsType type, LogBuilder lb) {
    for (Cargo c : tCopy()) {
        if (c.isEuropeanTrade(type))
            removeCargo(c);
    }
}