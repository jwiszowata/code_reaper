public void abortInvalidMissions() {
    for (AIUnit au : getAIUnits()) {
        Mission mission = au.getMission();
        String reason = (mission == null) ? null : mission.invalidReason();
        if (reason != null)
            au.setMission(null);
    }
}