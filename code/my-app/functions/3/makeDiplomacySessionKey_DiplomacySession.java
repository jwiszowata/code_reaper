private static String makeDiplomacySessionKey(Ownable o1, Ownable o2) {
    return makeSessionKey(DiplomacySession.class, o1.getOwner(), o2.getOwner());
}