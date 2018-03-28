protected Mission lbFail(LogBuilder lb, boolean cont, Object... reasons) {
    if (hasTools() && getUnit().getColony() != null) {
        getAIUnit().equipForRole(getSpecification().getDefaultRole());
    }
    return super.lbFail(lb, false, reasons);
}