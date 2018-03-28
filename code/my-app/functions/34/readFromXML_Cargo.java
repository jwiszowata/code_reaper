public void readFromXML(AIMain aiMain, FreeColXMLReader xr) throws XMLStreamException {
    final Game game = aiMain.getGame();
    String tid = xr.readId();
    TransportableAIObject tao = null;
    if (tid != null) {
        AIObject aio = aiMain.getAIObject(tid);
        if (aio == null) {
            if (tid.startsWith(Unit.TAG)) {
                tao = new AIUnit(aiMain, tid);
            } else if (tid.startsWith(AIGoods.TAG)) {
                tao = new AIGoods(aiMain, tid);
            }
        } else {
            tao = (TransportableAIObject) aio;
        }
    }
    if (tao == null) {
        throw new XMLStreamException("Transportable expected: " + tid);
    }
    this.transportable = tao;
    this.carrier = xr.getAttribute(game, CARRIER_TAG, Unit.class, (Unit) null);
    this.tries = xr.getAttribute(TRIES_TAG, 0);
    this.spaceLeft = xr.getAttribute(SPACELEFT_TAG, -1);
    this.wrapped = null;
    this.plan = new CargoPlan();
    this.plan.twait = xr.getLocationAttribute(game, TWAIT_TAG, false);
    this.plan.cwait = xr.getLocationAttribute(game, CWAIT_TAG, false);
    this.plan.cdst = xr.getLocationAttribute(game, CDST_TAG, false);
    this.plan.tdst = xr.getLocationAttribute(game, TDST_TAG, false);
    this.plan.turns = xr.getAttribute(TURNS_TAG, -1);
    this.plan.mode = xr.getAttribute(MODE_TAG, CargoMode.class, (CargoMode) null);
    this.plan.fallback = xr.getAttribute(FALLBACK_TAG, false);
    xr.closeTag(TAG);
}