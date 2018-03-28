public void displayObject(FreeColObject fco) {
    if (fco instanceof Colony) {
        canvas.showColonyPanel((Colony) fco, null);
    } else if (fco instanceof Europe) {
        canvas.showEuropePanel();
    } else if (fco instanceof IndianSettlement) {
        canvas.showIndianSettlementPanel((IndianSettlement) fco);
    } else if (fco instanceof Tile) {
        setFocus((Tile) fco);
    } else if (fco instanceof Unit) {
        Location loc = ((Unit) fco).up();
        if (loc instanceof Colony) {
            canvas.showColonyPanel((Colony) loc, (Unit) fco);
        } else {
            displayObject((FreeColObject) loc);
        }
    } else if (fco instanceof WorkLocation) {
        canvas.showColonyPanel(((WorkLocation) fco).getColony(), null);
    }
}