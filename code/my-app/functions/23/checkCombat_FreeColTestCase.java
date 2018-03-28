public void checkCombat(String name, List<CombatResult> crs, CombatResult... results) {
    int i = 0;
    for (CombatResult cr : results) {
        CombatResult expect = (i < crs.size()) ? crs.get(i) : null;
        if (expect != cr)
            break;
        i++;
    }
    if (i == results.length) {
        if (crs.size() == i)
            return;
        i++;
    }
    String err = name + ", failed at " + i + ":";
    for (CombatResult cr : results) {
        err += " " + cr;
    }
    err += " !=";
    for (CombatResult cr : crs) {
        err += " " + cr;
    }
    fail(err);
}