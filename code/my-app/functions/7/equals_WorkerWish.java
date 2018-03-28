public boolean equals(Object other) {
    if (other instanceof WorkerWish) {
        WorkerWish ow = (WorkerWish) other;
        return super.equals(ow) && Utils.equals(this.unitType, ow.unitType) && this.expertNeeded == ow.expertNeeded;
    }
    return false;
}