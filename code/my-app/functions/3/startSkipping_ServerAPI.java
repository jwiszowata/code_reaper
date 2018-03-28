public boolean startSkipping() {
    return send(TrivialMessage.END_TURN_MESSAGE);
}