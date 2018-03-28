public void setNation(Nation newNation) {
    Nation oldNation = getNation();
    nationId = newNation.getId();
    java.util.Map<Nation, NationState> nations = getGame().getNationOptions().getNations();
    nations.put(oldNation, NationState.AVAILABLE);
    nations.put(newNation, NationState.NOT_AVAILABLE);
}