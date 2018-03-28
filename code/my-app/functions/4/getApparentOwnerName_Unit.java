public StringTemplate getApparentOwnerName() {
    Player own = (isOwnerHidden()) ? getGame().getUnknownEnemy() : owner;
    return own.getNationLabel();
}