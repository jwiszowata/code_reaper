public static final HistoryEventType getEventTypeFromStance(Stance stance) {
    switch(stance) {
        case WAR:
            return HistoryEventType.DECLARE_WAR;
        case CEASE_FIRE:
            return HistoryEventType.CEASE_FIRE;
        case PEACE:
            return HistoryEventType.MAKE_PEACE;
        case ALLIANCE:
            return HistoryEventType.FORM_ALLIANCE;
        default:
            break;
    }
    return null;
}