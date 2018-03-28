public UnitType getTeachingType(UnitType teacherType) {
    final Specification spec = getSpecification();
    final UnitType taught = teacherType.getSkillTaught();
    final int taughtLevel = taught.getSkill();
    if (getSkill() >= taughtLevel)
        return null;
    List<UnitType> todo = new ArrayList<>();
    for (UnitChange uc : spec.getUnitChanges(UnitChangeType.EDUCATION, this)) {
        if (uc.to == taught)
            return taught;
        if (uc.to.getSkill() < taughtLevel)
            todo.add(uc.to);
    }
    for (UnitType ut : todo) {
        if (ut.getTeachingType(teacherType) != null)
            return ut;
    }
    return null;
}