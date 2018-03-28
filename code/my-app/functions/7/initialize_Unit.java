private void initialize() {
    Player owner = getOwner();
    if (owner != null && isPerson()) {
        setNationality(owner.getNationId());
        setEthnicity(owner.getNationId());
    }
}