public void disposeResources() {
    Location loc = getLocation();
    if (loc != null) {
        loc.remove(this);
    }
    if (teacher != null) {
        teacher.setStudent(null);
        teacher = null;
    }
    if (student != null) {
        student.setTeacher(null);
        student = null;
    }
    changeHomeIndianSettlement(null);
    getOwner().removeUnit(this);
    super.disposeResources();
}