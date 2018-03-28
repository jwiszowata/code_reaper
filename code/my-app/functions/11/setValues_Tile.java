public void setValues(UnitType skill, List<GoodsType> wanted) {
    this.skill = skill;
    if (wanted == null) {
        this.wantedGoods = null;
    } else if (this.wantedGoods == null) {
        this.wantedGoods = new ArrayList<GoodsType>(wanted);
    } else {
        this.wantedGoods.clear();
        this.wantedGoods.addAll(wanted);
    }
}