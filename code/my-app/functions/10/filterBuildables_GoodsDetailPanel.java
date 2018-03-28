private <T extends BuildableType> boolean filterBuildables(List<T> input, List<T> output, GoodsType type) {
    boolean result = false;
    for (T bt : input) {
        if (bt.needsGoodsToBuild() && any(bt.getRequiredGoods(), AbstractGoods.matches(type))) {
            output.add(bt);
            result = true;
        }
    }
    return result;
}