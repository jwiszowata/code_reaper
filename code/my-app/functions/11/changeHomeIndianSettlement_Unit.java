public IndianSettlement changeHomeIndianSettlement(IndianSettlement indianSettlement) {
    if (this.indianSettlement != null) {
        this.indianSettlement.removeOwnedUnit(this);
    }
    IndianSettlement ret = this.indianSettlement;
    this.indianSettlement = indianSettlement;
    if (indianSettlement != null) {
        indianSettlement.addOwnedUnit(this);
    }
    return ret;
}