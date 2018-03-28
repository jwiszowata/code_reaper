public boolean nativeGift(Unit unit, Colony colony) {
    return ask(unit.getGame(), new NativeGiftMessage(unit, colony));
}