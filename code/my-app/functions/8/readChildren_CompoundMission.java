protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    missions.clear();
    while (xr.moreTags()) {
        Mission mission = MissionManager.getMission(getGame(), xr);
        if (mission != null)
            missions.add(mission);
    }
}