public boolean hasSubGoals() {
    for (int i = 0; i < gds.length; i++) {
        if (!all && i > this.winner)
            break;
        if (gds[i].hasSubGoals()) {
            if (!all)
                return true;
        } else {
            if (all)
                return false;
        }
    }
    return !all;
}