public ModOption clone() {
    ModOption result = new ModOption(getSpecification());
    result.setId(this.getId());
    result.value = this.value;
    return result;
}