public void addTurns(int turns) {
    for (PathNode p = this; p != null; p = p.next) {
        p.setTurns(p.getTurns() + turns);
    }
}