public MissionState doMission() {
    while (true) {
        MissionState state = missions.get(index).doMission();
        if (state == MissionState.COMPLETED) {
            index++;
            if (index == missions.size()) {
                setRepeatCount(getRepeatCount() - 1);
                if (getRepeatCount() > 0) {
                    index = 0;
                } else {
                    return MissionState.COMPLETED;
                }
            }
            if (getUnit().getMovesLeft() > 0) {
                continue;
            }
        }
        return state;
    }
}