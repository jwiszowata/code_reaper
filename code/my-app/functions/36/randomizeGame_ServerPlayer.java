public void randomizeGame(Random random) {
    if (!isEuropean() || isREF() || isUnknownEnemy())
        return;
    final Specification spec = getGame().getSpecification();
    int i0 = spec.getInteger(GameOptions.INITIAL_IMMIGRATION);
    immigrationRequired = (int) applyModifiers((float) i0, null, Modifier.RELIGIOUS_UNREST_BONUS);
    modifyGold(spec.getInteger(GameOptions.STARTING_MONEY));
    ((ServerEurope) getEurope()).initializeMigration(random);
    Market market = getMarket();
    StringBuilder sb = new StringBuilder();
    boolean changed = false;
    for (GoodsType type : spec.getGoodsTypeList()) {
        String prefix = "model.option." + type.getSuffix("model.goods.");
        if (spec.hasOption(prefix + ".minimumPrice") && spec.hasOption(prefix + ".maximumPrice")) {
            int min = spec.getInteger(prefix + ".minimumPrice");
            int max = spec.getInteger(prefix + ".maximumPrice");
            if (max < min) {
                int bad = min;
                min = max;
                max = bad;
            } else if (max == min)
                continue;
            int add = randomInt(null, null, random, max - min);
            if (add > 0) {
                market.setInitialPrice(type, min + add);
                market.update(type);
                market.flushPriceChange(type);
                sb.append(", ").append(type.getId()).append(" -> ").append(min + add);
                changed = true;
            }
        }
    }
    if (changed) {
        logger.finest("randomizeGame(" + getId() + ") initial prices: " + sb.toString().substring(2));
    }
}