public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(BodyTypes.PLANET, name, orbitalPeriod);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if (moon.getKey().getBodyType() == BodyTypes.MOON)
            return super.addSatellite(moon);
        else
            return false;
    }
}
