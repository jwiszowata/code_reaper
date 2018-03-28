public boolean buildColony(String name, Unit unit) {
    return ask(unit.getGame(), new BuildColonyMessage(name, unit));
}