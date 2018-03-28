public void setCurrentlyBuilding(T buildable) {
    if (buildable == null) {
        clear();
    } else {
        if (buildable instanceof BuildingType && this.queue.contains(buildable)) {
            this.queue.remove(buildable);
        }
        this.queue.add(0, buildable);
    }
}