public boolean hasNativeEthnicity() {
    try {
        return getGame().getSpecification().getNation(ethnicity).getType().isIndian();
    } catch (Exception e) {
        return false;
    }
}