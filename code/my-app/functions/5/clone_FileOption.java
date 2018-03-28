public FileOption clone() {
    FileOption result = new FileOption(getSpecification());
    result.setValues(this);
    return result;
}