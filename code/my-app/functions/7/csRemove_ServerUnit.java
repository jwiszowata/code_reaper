public void csRemove(See see, Location loc, ChangeSet cs) {
    IndianSettlement is = changeHomeIndianSettlement(null);
    if (is != null)
        cs.add(See.only((ServerPlayer) getOwner()), is);
    cs.addRemove(see, loc, this);
    this.dispose();
}