public void removeMission() {
    if (this.mission != null) {
        this.mission.dispose();
        this.mission = null;
    }
}