public boolean isIncitable() {
    switch(this) {
        case CEASE_FIRE:
        case PEACE:
            return true;
        default:
            break;
    }
    return false;
}