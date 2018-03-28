public boolean canBeTaught() {
    return asResultOf(ChangeType.EDUCATION) && turnsToLearn > 0;
}