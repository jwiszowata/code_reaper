private void add(LocationData data) {
    workingProfessionals.add(data.workingProfessionals);
    workingAmateurs += data.workingAmateurs;
    otherWorkingAmateurs.add(data.otherWorkingAmateurs);
    teachers += data.teachers;
    students += data.students;
    otherStudents += data.otherStudents;
    notWorking += data.notWorking;
    if (data.otherStudents > 0) {
        otherStudentsName = data.otherStudentsName;
    }
}