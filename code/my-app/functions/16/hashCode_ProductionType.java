public int hashCode() {
    int hash = super.hashCode();
    hash = 31 * hash + ((this.unattended) ? 1 : 0);
    hash = 31 * hash + Utils.hashCode(this.productionLevel);
    if (this.outputs != null) {
        for (AbstractGoods ag : this.outputs) {
            hash = 31 * hash + Utils.hashCode(ag);
        }
    }
    if (this.inputs != null) {
        for (AbstractGoods ag : this.inputs) {
            hash = 31 * hash + Utils.hashCode(ag);
        }
    }
    return hash;
}