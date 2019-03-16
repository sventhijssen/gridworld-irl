import java.util.Arrays;

public class DistributionFactory
{
    public static double[] getProbabilityDistribution(int length)
    {
        double[] distribution = new double[length];
        for(int i=0; i < length-1; i++)
        {
            double rnd = Math.random();
            distribution[i] = rnd;
            while (Arrays.stream(distribution).sum() > 1)
            {
                rnd = Math.random();
                distribution[i] = rnd;
            }
        }
        distribution[length-1] = 1 - Arrays.stream(distribution).sum();
        return distribution;
    }
}
