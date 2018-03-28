private Map<GoodsType, Map<WorkLocation, Integer>> createProductionMap() {
    Map<GoodsType, Map<WorkLocation, Integer>> production = new HashMap<>();
    for (WorkLocation wl : colony.getAvailableWorkLocationsList()) {
        for (GoodsType g : spec().getGoodsTypeList()) {
            int p = wl.getGenericPotential(g);
            if (p > 0) {
                Map<WorkLocation, Integer> m = production.get(g);
                if (m == null) {
                    m = new HashMap<>();
                    production.put(g, m);
                }
                m.put(wl, p);
            }
        }
    }
    return production;
}