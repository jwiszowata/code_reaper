public int getTotalColonists() {
    return workingAmateurs + workingProfessionals.getColonists() + notWorking + teachers + otherStudents - students;
}