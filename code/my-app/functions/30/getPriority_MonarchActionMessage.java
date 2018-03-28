public MessagePriority getPriority() {
    MessagePriority mp = null;
    switch(this.action) {
        case RAISE_TAX_ACT:
        case RAISE_TAX_WAR:
        case MONARCH_MERCENARIES:
        case HESSIAN_MERCENARIES:
            mp = Message.MessagePriority.EARLY;
            break;
        case NO_ACTION:
        case FORCE_TAX:
        case WAIVE_TAX:
        case DISPLEASURE:
            mp = Message.MessagePriority.NORMAL;
            break;
        case LOWER_TAX_OTHER:
        case LOWER_TAX_WAR:
        case ADD_TO_REF:
        case DECLARE_PEACE:
        case DECLARE_WAR:
        case SUPPORT_LAND:
        case SUPPORT_SEA:
            mp = Message.MessagePriority.LATE;
            break;
    }
    if (mp == null) {
        throw new RuntimeException("Missing priority for action: " + this.action);
    }
    return mp;
}