public Location getTarget() {
    return (this.demanded && this.succeeded) ? getUnit().getHomeIndianSettlement() : this.colony;
}