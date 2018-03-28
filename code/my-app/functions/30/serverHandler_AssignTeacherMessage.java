public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final String studentId = getStringAttribute(STUDENT_TAG);
    final String teacherId = getStringAttribute(TEACHER_TAG);
    Unit student;
    try {
        student = serverPlayer.getOurFreeColGameObject(studentId, Unit.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    Unit teacher;
    try {
        teacher = serverPlayer.getOurFreeColGameObject(teacherId, Unit.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    if (student.getColony() == null) {
        return serverPlayer.clientError("Student not in colony: " + studentId);
    } else if (!student.isInColony()) {
        return serverPlayer.clientError("Student not working colony: " + studentId);
    } else if (teacher.getColony() == null) {
        return serverPlayer.clientError("Teacher not in colony: " + teacherId);
    } else if (!teacher.getColony().canTrain(teacher)) {
        return serverPlayer.clientError("Teacher can not teach: " + teacherId);
    } else if (student.getColony() != teacher.getColony()) {
        return serverPlayer.clientError("Student and teacher not in same colony: " + studentId);
    } else if (!student.canBeStudent(teacher)) {
        return serverPlayer.clientError("Student can not be taught by teacher: " + studentId);
    }
    return freeColServer.getInGameController().assignTeacher(serverPlayer, student, teacher);
}