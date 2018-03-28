private void multiple(Connection connection, Element element) {
    new MultipleMessage(element).applyHandler(this, connection);
}