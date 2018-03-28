public UnitListOption clone() {
    UnitListOption ret = new UnitListOption(getId(), getSpecification());
    ret.setValues(this);
    return ret;
}