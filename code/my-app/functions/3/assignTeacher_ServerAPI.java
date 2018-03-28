public boolean assignTeacher(Unit student, Unit teacher) {
    return ask(student.getGame(), new AssignTeacherMessage(student, teacher));
}