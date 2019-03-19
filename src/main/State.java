package main;

class State
{

    private Vector features;

    State()
    {
        this(new double[] {1});
    }

    private State(double[] features)
    {
        this.setFeatures(features);
    }

    Vector getFeatures()
    {
        return features;
    }

    void setFeatures(double[] features)
    {
        this.features = new Vector(features);
    }
}
