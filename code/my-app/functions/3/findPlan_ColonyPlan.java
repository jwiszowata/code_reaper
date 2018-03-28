private WorkLocationPlan findPlan(GoodsType goodsType, List<WorkLocationPlan> plans) {
    return find(plans, wlp -> wlp.getGoodsType() == goodsType);
}