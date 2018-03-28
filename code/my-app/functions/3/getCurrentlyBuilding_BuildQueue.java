public T getCurrentlyBuilding() {
    return (this.queue.isEmpty()) ? null : this.queue.get(0);
}