public double calculateStrength(boolean naval) {
    return AbstractUnit.calculateStrength(getSpecification(), (naval) ? this.navalUnits : this.landUnits);
}