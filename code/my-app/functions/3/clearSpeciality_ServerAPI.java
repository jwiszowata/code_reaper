public boolean clearSpeciality(Unit unit) {
    return ask(unit.getGame(), new ClearSpecialityMessage(unit));
}