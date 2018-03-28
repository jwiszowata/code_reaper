public List<StringTemplate> getWantedGoodsLabel(int index, Player player) {
    StringTemplate lab = null, tip = null;
    GoodsType gt;
    if (hasVisited(player) && (gt = getWantedGoods(index)) != null) {
        lab = StringTemplate.label("").add(Messages.nameKey(gt));
        String sale = player.getLastSaleString(this, gt);
        if (sale != null) {
            lab.addName(" " + sale);
            tip = player.getLastSaleTip(this, gt);
        }
    }
    if (lab == null) {
        lab = StringTemplate.key("model.indianSettlement.wantedGoodsNone");
    }
    List<StringTemplate> ret = new ArrayList<>();
    ret.add(lab);
    if (tip != null)
        ret.add(tip);
    return ret;
}