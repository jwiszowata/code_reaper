private void csTeach(ChangeSet cs) {
    final ServerPlayer owner = (ServerPlayer) getColony().getOwner();
    for (Unit teacher : getUnitList()) {
        Unit student = teacher.getStudent();
        if (student != null && student.getTeacher() != teacher) {
            logger.warning("Bogus teacher/student assignment.");
            teacher.setStudent(null);
            student = null;
        }
        if (student == null && csAssignStudent(teacher, cs)) {
            student = teacher.getStudent();
        }
        teacher.setTurnsOfTraining((student == null) ? 0 : teacher.getTurnsOfTraining() + 1);
        cs.add(See.only(owner), teacher);
    }
}