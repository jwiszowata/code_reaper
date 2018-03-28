protected void setValues(AbstractOption<T> source) {
    setId(source.getId());
    setSpecification(source.getSpecification());
    setValue(source.getValue());
    setGroup(source.getGroup());
    isDefined = source.isDefined;
}