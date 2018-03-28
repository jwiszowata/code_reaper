public boolean confirmLeaveColony(Unit unit) {
    Colony colony = unit.getColony();
    StringTemplate message = colony.getReducePopulationMessage();
    if (message != null) {
        showInformationMessage(message);
        return false;
    }
    return confirmAbandonEducation(unit, true);
}