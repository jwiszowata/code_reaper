public boolean isValid() {
    return (super.isValid() && !missions.isEmpty()) ? all(missions, Mission::isValid) : false;
}