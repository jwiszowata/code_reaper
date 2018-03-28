public boolean setNationType(NationType nationType) {
    return ask(null, new SetNationTypeMessage(null, nationType));
}