public ModListOption clone() {
    ModListOption ret = new ModListOption(getId(), getSpecification());
    ret.setValues(this);
    return ret;
}