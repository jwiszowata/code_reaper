private void error(Element element) {
    final ErrorMessage errorMessage = new ErrorMessage(getGame(), element);
    getGUI().showErrorMessage(errorMessage.getTemplate(), errorMessage.getMessage());
}