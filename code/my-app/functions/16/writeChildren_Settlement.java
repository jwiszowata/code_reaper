protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    if (xw.validFor(getOwner())) {
        super.writeChildren(xw);
        for (Ability ability : getSortedAbilities()) {
            if (ability.isIndependent())
                ability.toXML(xw);
        }
        final Turn turn = getGame().getTurn();
        for (Modifier modifier : getSortedModifiers()) {
            if (modifier.hasIncrement() && modifier.isOutOfDate(turn))
                continue;
            if (modifier.isIndependent())
                modifier.toXML(xw);
        }
    }
}