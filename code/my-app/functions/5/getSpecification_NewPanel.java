public Specification getSpecification() {
    if (this.fixedSpecification != null)
        return this.fixedSpecification;
    return FreeCol.loadSpecification(getSelectedTC(), null, null);
}