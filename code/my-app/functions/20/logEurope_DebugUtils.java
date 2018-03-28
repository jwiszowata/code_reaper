private static void logEurope(AIMain aiMain, LogBuilder lb, String label, List<Unit> units) {
    if (units.isEmpty())
        return;
    lb.add("\n->", label, "\n");
    for (Unit u : units) {
        lb.add("\n", u.getDescription(Unit.UnitLabelType.NATIONAL));
        if (u.isDamaged()) {
            lb.add(" (", Messages.message(u.getRepairLabel()), ")");
        } else {
            lb.add("    ");
            AIUnit aiu = aiMain.getAIUnit(u);
            if (!aiu.hasMission()) {
                lb.add(" (", Messages.message("none"), ")");
            } else {
                lb.add(aiu.getMission().toString().replaceAll("\n", "    \n"));
            }
        }
    }
    lb.add("\n");
}