private void buildWishMaps(LogBuilder lb) {
    for (UnitType unitType : getSpecification().getUnitTypeList()) {
        List<WorkerWish> wl = workerWishes.get(unitType);
        if (wl == null) {
            workerWishes.put(unitType, new ArrayList<WorkerWish>());
        } else {
            wl.clear();
        }
    }
    for (GoodsType goodsType : getSpecification().getStorableGoodsTypeList()) {
        List<GoodsWish> gl = goodsWishes.get(goodsType);
        if (gl == null) {
            goodsWishes.put(goodsType, new ArrayList<GoodsWish>());
        } else {
            gl.clear();
        }
    }
    for (Wish w : getWishes()) {
        if (w instanceof WorkerWish) {
            WorkerWish ww = (WorkerWish) w;
            if (ww.getTransportable() == null) {
                appendToMapList(workerWishes, ww.getUnitType(), ww);
            }
        } else if (w instanceof GoodsWish) {
            GoodsWish gw = (GoodsWish) w;
            if (gw.getDestination() instanceof Colony) {
                appendToMapList(goodsWishes, gw.getGoodsType(), gw);
            }
        }
    }
    if (!workerWishes.isEmpty()) {
        lb.add("\n  Wishes (workers):");
        forEachMapEntry(workerWishes, e -> {
            UnitType ut = e.getKey();
            List<WorkerWish> wl = e.getValue();
            if (!wl.isEmpty()) {
                lb.add("\n    ", ut.getSuffix(), ":");
                for (WorkerWish ww : wl) {
                    lb.add(" ", ww.getDestination(), "(", ww.getValue(), ")");
                }
            }
        });
    }
    if (!goodsWishes.isEmpty()) {
        lb.add("\n  Wishes (goods):");
        forEachMapEntry(goodsWishes, e -> {
            GoodsType gt = e.getKey();
            List<GoodsWish> gl = e.getValue();
            if (!gl.isEmpty()) {
                lb.add("\n    ", gt.getSuffix(), ":");
                for (GoodsWish gw : gl) {
                    lb.add(" ", gw.getDestination(), "(", gw.getValue(), ")");
                }
            }
        });
    }
}