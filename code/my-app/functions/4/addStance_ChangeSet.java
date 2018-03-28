public ChangeSet addStance(See see, Player first, Stance stance, Player second) {
    changes.add(new StanceChange(see, first, stance, second));
    return this;
}