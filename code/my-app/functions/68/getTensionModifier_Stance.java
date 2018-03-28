public int getTensionModifier(Stance newStance) {
    switch(newStance) {
        case UNCONTACTED:
            badTransition(newStance);
        case ALLIANCE:
            switch(this) {
                case UNCONTACTED:
                    badTransition(newStance);
                case ALLIANCE:
                    return 0;
                case PEACE:
                    return Tension.ALLIANCE_MODIFIER;
                case CEASE_FIRE:
                    return Tension.ALLIANCE_MODIFIER + Tension.PEACE_TREATY_MODIFIER;
                case WAR:
                    return Tension.ALLIANCE_MODIFIER + Tension.CEASE_FIRE_MODIFIER + Tension.PEACE_TREATY_MODIFIER;
                default:
                    this.badStance();
            }
        case PEACE:
            switch(this) {
                case UNCONTACTED:
                    return Tension.CONTACT_MODIFIER;
                case ALLIANCE:
                    return Tension.DROP_ALLIANCE_MODIFIER;
                case PEACE:
                    return 0;
                case CEASE_FIRE:
                    return Tension.PEACE_TREATY_MODIFIER;
                case WAR:
                    return Tension.CEASE_FIRE_MODIFIER + Tension.PEACE_TREATY_MODIFIER;
                default:
                    this.badStance();
            }
        case CEASE_FIRE:
            switch(this) {
                case UNCONTACTED:
                    badTransition(newStance);
                case ALLIANCE:
                    badTransition(newStance);
                case PEACE:
                    badTransition(newStance);
                case CEASE_FIRE:
                    return 0;
                case WAR:
                    return Tension.CEASE_FIRE_MODIFIER;
                default:
                    this.badStance();
            }
        case WAR:
            switch(this) {
                case UNCONTACTED:
                    return Tension.WAR_MODIFIER;
                case ALLIANCE:
                    return Tension.WAR_MODIFIER;
                case PEACE:
                    return Tension.WAR_MODIFIER;
                case CEASE_FIRE:
                    return Tension.RESUME_WAR_MODIFIER;
                case WAR:
                    return 0;
                default:
                    this.badStance();
            }
        default:
            throw new IllegalStateException("Bogus newStance");
    }
}