public boolean showNetProduction() {
    return showProduction() && unitType.getExpertProduction().isStorable();
}