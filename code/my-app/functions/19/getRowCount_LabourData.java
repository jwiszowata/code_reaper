public int getRowCount() {
    boolean isSummary = getUnitData().isSummary();
    int rows = 0;
    if (workingProfessionals.getColonists() > 0)
        rows++;
    if (workingAmateurs > 0)
        rows++;
    if (!isSummary && otherWorkingAmateurs.getColonists() > 0)
        rows++;
    if (teachers > 0)
        rows++;
    if (students > 0)
        rows++;
    if (!isSummary && otherStudents > 0)
        rows++;
    if (notWorking > 0)
        rows++;
    return rows;
}