public MissionState doMission() {
    int work = getUnit().hasAbility(Ability.EXPERT_PIONEER) ? 2 : 1;
    setTurnCount(getTurnCount() - work);
    getUnit().setMovesLeft(0);
    return (getTurnCount() <= 0) ? MissionState.COMPLETED : MissionState.OK;
}