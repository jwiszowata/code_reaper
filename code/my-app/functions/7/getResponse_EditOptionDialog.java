public Boolean getResponse() {
    Boolean result = super.getResponse();
    if (result && ui != null) {
        ui.updateOption();
    }
    return result;
}