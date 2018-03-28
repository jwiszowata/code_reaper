public boolean csCheckTeach(Unit teacher, ChangeSet cs) {
    final ServerPlayer owner = (ServerPlayer) getColony().getOwner();
    Unit student = teacher.getStudent();
    if (student != null && teacher.getTurnsOfTraining() >= teacher.getNeededTurnsOfTraining()) {
        csTrainStudent(teacher, student, cs);
        cs.add(See.only(owner), student);
        if (teacher.getStudent() == null)
            csAssignStudent(teacher, cs);
        return true;
    }
    return false;
}