public Unit getUnit() {
    return this.goods.getGame().getFreeColGameObject(this.unitId, Unit.class);
}