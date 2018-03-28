public void updateEducation(Unit unit, boolean enable) {
    WorkLocation wl = unit.getWorkLocation();
    if (wl == null) {
        throw new RuntimeException("updateEducation(" + unit + ") unit not at work location.");
    } else if (wl.getColony() != this) {
        throw new RuntimeException("updateEducation(" + unit + ") unit not at work location in this colony.");
    }
    if (enable) {
        if (wl.canTeach()) {
            Unit student = unit.getStudent();
            if (student == null && (student = findStudent(unit)) != null) {
                unit.setStudent(student);
                student.setTeacher(unit);
                unit.setTurnsOfTraining(0);
                unit.changeWorkType(null);
            }
        } else {
            Unit teacher = unit.getTeacher();
            if (teacher == null && (teacher = findTeacher(unit)) != null) {
                unit.setTeacher(teacher);
                teacher.setStudent(unit);
            }
        }
    } else {
        if (wl.canTeach()) {
            Unit student = unit.getStudent();
            if (student != null) {
                student.setTeacher(null);
                unit.setStudent(null);
                unit.setTurnsOfTraining(0);
            }
        } else {
            Unit teacher = unit.getTeacher();
            if (teacher != null) {
                teacher.setStudent(null);
                unit.setTeacher(null);
            }
        }
    }
}