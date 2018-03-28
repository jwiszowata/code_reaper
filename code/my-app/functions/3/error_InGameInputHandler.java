private void error(ErrorMessage message) {
    invokeLater(() -> igc().error(message.getTemplate(), message.getMessage()));
}