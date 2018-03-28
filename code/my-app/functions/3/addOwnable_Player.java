public boolean addOwnable(Ownable o) {
    return (o instanceof Settlement) ? addSettlement((Settlement) o) : (o instanceof Unit) ? addUnit((Unit) o) : false;
}