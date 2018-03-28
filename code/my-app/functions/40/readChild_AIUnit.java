protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final AIMain aiMain = getAIMain();
    final String tag = xr.getLocalName();
    mission = null;
    if (BuildColonyMission.TAG.equals(tag)) {
        mission = new BuildColonyMission(aiMain, this, xr);
    } else if (CashInTreasureTrainMission.TAG.equals(tag)) {
        mission = new CashInTreasureTrainMission(aiMain, this, xr);
    } else if (DefendSettlementMission.TAG.equals(tag)) {
        mission = new DefendSettlementMission(aiMain, this, xr);
    } else if (IdleAtSettlementMission.TAG.equals(tag)) {
        mission = new IdleAtSettlementMission(aiMain, this, xr);
    } else if (IndianBringGiftMission.TAG.equals(tag)) {
        mission = new IndianBringGiftMission(aiMain, this, xr);
    } else if (IndianDemandMission.TAG.equals(tag)) {
        mission = new IndianDemandMission(aiMain, this, xr);
    } else if (MissionaryMission.TAG.equals(tag)) {
        mission = new MissionaryMission(aiMain, this, xr);
    } else if (PioneeringMission.TAG.equals(tag)) {
        mission = new PioneeringMission(aiMain, this, xr);
    } else if (PrivateerMission.TAG.equals(tag)) {
        mission = new PrivateerMission(aiMain, this, xr);
    } else if (ScoutingMission.TAG.equals(tag)) {
        mission = new ScoutingMission(aiMain, this, xr);
    } else if (TransportMission.TAG.equals(tag)) {
        mission = new TransportMission(aiMain, this, xr);
    } else if (UnitSeekAndDestroyMission.TAG.equals(tag)) {
        mission = new UnitSeekAndDestroyMission(aiMain, this, xr);
    } else if (UnitWanderHostileMission.TAG.equals(tag)) {
        mission = new UnitWanderHostileMission(aiMain, this, xr);
    } else if (UnitWanderMission.TAG.equals(tag)) {
        mission = new UnitWanderMission(aiMain, this, xr);
    } else if (WishRealizationMission.TAG.equals(tag)) {
        mission = new WishRealizationMission(aiMain, this, xr);
    } else if (WorkInsideColonyMission.TAG.equals(tag)) {
        mission = new WorkInsideColonyMission(aiMain, this, xr);
    } else {
        super.readChild(xr);
    }
}