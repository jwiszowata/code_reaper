public StringTemplate getRepairLabel() {
    return StringTemplate.template("model.unit.underRepair").addAmount("%turns%", getTurnsForRepair());
}