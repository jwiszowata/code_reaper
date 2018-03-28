public Unit getInitialActiveUnit() {
    return (this.initialActiveUnitId == null) ? null : getFreeColGameObject(this.initialActiveUnitId, Unit.class);
}