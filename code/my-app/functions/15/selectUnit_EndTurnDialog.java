private void selectUnit() {
    UnitWrapper wrapper = this.unitList.getSelectedValue();
    if (wrapper != null && wrapper.unit != null) {
        if (wrapper.unit.isInEurope()) {
            getGUI().showEuropePanel();
        } else {
            getGUI().setActiveUnit(wrapper.unit);
            if (wrapper.unit.getColony() != null) {
                getGUI().showColonyPanel(wrapper.unit.getColony(), wrapper.unit);
            } else if (wrapper.unit.hasTile()) {
                getGUI().setFocus(wrapper.unit.getTile());
            }
        }
    }
}