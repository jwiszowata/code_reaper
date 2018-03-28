public boolean check(Unit u, PathNode path) {
    for (int i = 0; i < gds.length; i++) {
        if (!all && i > this.winner)
            break;
        if (gds[i].check(u, path)) {
            if (!all) {
                this.winner = i;
                this.goal = path;
                return true;
            }
        } else {
            if (all) {
                return false;
            }
        }
    }
    if (all) {
        this.winner = 0;
        this.goal = path;
        return true;
    }
    return false;
}