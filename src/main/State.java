package main;

public class State
{

    private Vector features;

    State()
    {
        this(new double[] {1});
    }

    public State(double[] features)
    {
        this.setFeatures(features);
    }

    public Vector getFeatures()
    {
        return features;
    }

    void setFeatures(double[] features)
    {
        this.features = new Vector(features);
    }
}
