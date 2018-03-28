public Stance getStanceFromTension(Tension tension) {
    int value = tension.getValue();
    switch(this) {
        case WAR:
            if (value <= Tension.Level.CONTENT.getLimit() - Tension.DELTA) {
                return Stance.CEASE_FIRE;
            }
            break;
        case CEASE_FIRE:
            if (value <= Tension.Level.HAPPY.getLimit() - Tension.DELTA) {
                return Stance.PEACE;
            }
        case ALLIANCE:
        case PEACE:
            if (value > Tension.Level.HATEFUL.getLimit() + Tension.DELTA) {
                return Stance.WAR;
            }
            break;
        case UNCONTACTED:
            break;
        default:
            this.badStance();
    }
    return this;
}