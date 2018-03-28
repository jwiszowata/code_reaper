public void csSetTax(int tax, ChangeSet cs) {
    setTax(tax);
    if (recalculateBellsBonus()) {
        cs.add(See.only(this), this);
    } else {
        cs.addPartial(See.only(this), this, "tax", String.valueOf(this.getTax()));
    }
}