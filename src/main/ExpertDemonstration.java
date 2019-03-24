package main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

public class ExpertDemonstration
{
    private  int trajectoryLength;
    private ArrayList<Ribbon> ribbons = new ArrayList<>();
    private ArrayList<Ribbon> environment = new ArrayList<>();
    private ArrayList<Integer> trajectory = new ArrayList<>();

    public ExpertDemonstration(int trajectoryLength)
    {
        this.trajectoryLength = trajectoryLength;
        this.ribbons.add(new Ribbon(0, 0, 0));
        this.ribbons.add(new Ribbon(1, 0, 0));
        this.ribbons.add(new Ribbon(0, 1, 0));
        this.ribbons.add(new Ribbon(0, 0, 1));
        this.ribbons.add(new Ribbon(1, 1, 0));
        this.ribbons.add(new Ribbon(1, 0, 1));
        this.ribbons.add(new Ribbon(0, 1, 1));

        trajectory.add(1);
        environment.add(new Ribbon(0,0,0));
    }

    public void learn() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i < trajectoryLength; i++)
        {
            // Random configuration for next ribbon
            Random rand = new Random();
            Ribbon randomRibbon = ribbons.get(rand.nextInt(ribbons.size()));
            System.out.println(randomRibbon.toString());

            // Configuration of current ribbon
            Ribbon currentRibbon = environment.get(i);
            currentRibbon.setCar(trajectory.get(i));
            System.out.println(environment.get(i));

            int c = 0;
            String s = "";
            while(sc.hasNext())
                s = sc.nextLine();
            System.out.println(s);

            if(c == 'a') // left
            {
                trajectory.add(0);
            }
            else if(c == 'w') // middle
            {
                trajectory.add(1);
            }
            else if(c == 'd') // right
            {
                trajectory.add(2);
            }
            else
            {
                throw new Exception("Undefined action.");
            }
        }
        sc.close();
    }

    private class Ribbon
    {
        private int left;
        private int middle;
        private int right;

        public Ribbon(int left, int middle, int right)
        {
            this.left = left;
            this.middle = middle;
            this.right = right;
        }

        private String getRepresentation(int number)
        {
            if(number == 0)
                return "_";
            else if(number == 1)
                return "#";
            else
                return "o";
        }

        private void setCar(int lane)
        {
            if(lane == 0)
                this.left = 2;
            else if(lane == 1)
                this.middle = 2;
            else
                this.right = 2;
        }

        @Override
        public String toString()
        {
            return String.format("|%s|%s|%s", getRepresentation(left), getRepresentation(middle), getRepresentation(right));
        }
    }
}
