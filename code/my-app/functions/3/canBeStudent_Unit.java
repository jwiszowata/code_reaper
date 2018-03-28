public boolean canBeStudent(Unit teacher) {
    return teacher != null && teacher != this && getTeachingType(teacher) != null;
}