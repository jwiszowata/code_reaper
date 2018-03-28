protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    if (market != null)
        market.toXML(xw);
    if (xw.validFor(this)) {
        for (Ability ability : transform(getSortedAbilities(), Ability::isIndependent)) {
            ability.toXML(xw);
        }
        Turn turn = getGame().getTurn();
        for (Modifier modifier : transform(getSortedModifiers(), m -> m.isTemporary() && !m.isOutOfDate(turn))) {
            modifier.toXML(xw);
        }
        for (Player p : sort(tension.keySet())) {
            xw.writeStartElement(TENSION_TAG);
            xw.writeAttribute(PLAYER_TAG, p);
            xw.writeAttribute(VALUE_TAG, tension.get(p).getValue());
            xw.writeEndElement();
        }
        if (bannedMissions != null) {
            for (Player p : sort(bannedMissions)) {
                xw.writeStartElement(BAN_MISSIONS_TAG);
                xw.writeAttribute(PLAYER_TAG, p.getId());
                xw.writeEndElement();
            }
        }
        for (Entry<String, Stance> e : mapEntriesByKey(stance)) {
            Stance s = e.getValue();
            if (s == Stance.UNCONTACTED)
                continue;
            xw.writeStartElement(STANCE_TAG);
            xw.writeAttribute(PLAYER_TAG, e.getKey());
            xw.writeAttribute(VALUE_TAG, s);
            xw.writeEndElement();
        }
        for (HistoryEvent event : getHistory()) {
            event.toXML(xw);
        }
        for (TradeRoute route : sort(getTradeRoutes())) {
            route.toXML(xw);
        }
        if (highSeas != null)
            highSeas.toXML(xw);
        xw.writeToListElement(FOUNDING_FATHERS_TAG, foundingFathers);
        xw.writeToListElement(OFFERED_FATHERS_TAG, offeredFathers);
        if (europe != null)
            europe.toXML(xw);
        if (monarch != null)
            monarch.toXML(xw);
        for (ModelMessage m : getModelMessages()) m.toXML(xw);
        if (lastSales != null) {
            for (LastSale ls : sort(lastSales.values())) {
                ls.toXML(xw);
            }
        }
    } else {
        Player player = xw.getClientPlayer();
        Tension t = getTension(player);
        if (t != null) {
            xw.writeStartElement(TENSION_TAG);
            xw.writeAttribute(PLAYER_TAG, player);
            xw.writeAttribute(VALUE_TAG, t.getValue());
            xw.writeEndElement();
        }
        if (missionsBanned(player)) {
            xw.writeStartElement(BAN_MISSIONS_TAG);
            xw.writeAttribute(PLAYER_TAG, player.getId());
            xw.writeEndElement();
        }
        Stance s = getStance(player);
        if (s != null && s != Stance.UNCONTACTED) {
            xw.writeStartElement(STANCE_TAG);
            xw.writeAttribute(PLAYER_TAG, player);
            xw.writeAttribute(VALUE_TAG, s);
            xw.writeEndElement();
        }
    }
}