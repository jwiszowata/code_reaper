public boolean monarchAction(MonarchAction action, boolean accept) {
    if (action == null)
        return false;
    boolean ret = false;
    switch(action) {
        case RAISE_TAX_ACT:
        case RAISE_TAX_WAR:
        case MONARCH_MERCENARIES:
        case HESSIAN_MERCENARIES:
            ret = askServer().answerMonarch(getGame(), action, accept);
            break;
        default:
            break;
    }
    if (ret) {
        updateGUI(null);
    }
    return ret;
}