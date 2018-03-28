public ChangeSet addAttack(See see, Unit attacker, Unit defender, boolean success) {
    changes.add(new AttackChange(see, attacker, defender, success));
    return this;
}