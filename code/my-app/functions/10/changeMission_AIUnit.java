public Mission changeMission(Mission mission) {
    if (this.mission == mission)
        return this.mission;
    removeMission();
    setMission(mission);
    if (mission != null) {
        setTransportPriority(mission.getBaseTransportPriority());
    }
    return this.mission;
}