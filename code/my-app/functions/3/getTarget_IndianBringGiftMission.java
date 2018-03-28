public Location getTarget() {
    return (this.collected) ? this.colony : getUnit().getHomeIndianSettlement();
}