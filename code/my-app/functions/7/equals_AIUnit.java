public boolean equals(Object other) {
    if (other instanceof AIUnit) {
        AIUnit oa = (AIUnit) other;
        return super.equals(oa) && Utils.equals(this.unit, oa.unit) && Utils.equals(this.mission, oa.mission);
    }
    return false;
}