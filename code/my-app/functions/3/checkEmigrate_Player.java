public boolean checkEmigrate() {
    return (isColonial()) ? getImmigrationRequired() <= immigration : false;
}