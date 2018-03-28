public boolean work(Unit unit, WorkLocation workLocation) {
    return ask(unit.getGame(), new WorkMessage(unit, workLocation));
}