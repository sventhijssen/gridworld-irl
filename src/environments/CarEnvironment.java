package environments;

import main.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class CarEnvironment implements IEnvironment
{
    private ArrayList<Action> actions = new ArrayList<>();
    private GridWorld gridWorld;
    private ArrayList<Position> trajectory = new ArrayList<>();

    public CarEnvironment()
    {
        actions.add(new Action(+1, -1)); // Left
        actions.add(new Action(+1, 0)); // Straight
        actions.add(new Action(+1, +1)); // Right

        Position startPosition = new Position(0,1);

        ArrayList<Position> goalPositions = new ArrayList<>();
        goalPositions.add(new Position(15,0));
        goalPositions.add(new Position(15,1));
        goalPositions.add(new Position(15,2));

        gridWorld = new GridWorld(16, 3, actions, startPosition, goalPositions);

        // Row 0
        gridWorld.setFeature(0,0,  new double[] {0});
        gridWorld.setFeature(0,1,  new double[] {0});
        gridWorld.setFeature(0,2,  new double[] {0});

        // Row 1
        gridWorld.setFeature(1,0,  new double[] {0});
        gridWorld.setFeature(1,1,  new double[] {0});
        gridWorld.setFeature(1,2,  new double[] {0});

        // Row 2
        gridWorld.setFeature(2,0,  new double[] {1});
        gridWorld.setFeature(2,1,  new double[] {0});
        gridWorld.setFeature(2,2,  new double[] {0});

        // Row 3
        gridWorld.setFeature(3,0,  new double[] {1});
        gridWorld.setFeature(3,1,  new double[] {0});
        gridWorld.setFeature(3,2,  new double[] {0});

        // Row 4
        gridWorld.setFeature(4,0,  new double[] {0});
        gridWorld.setFeature(4,1,  new double[] {0});
        gridWorld.setFeature(4,2,  new double[] {0});

        // Row 5
        gridWorld.setFeature(5,0,  new double[] {0});
        gridWorld.setFeature(5,1,  new double[] {0});
        gridWorld.setFeature(5,2,  new double[] {0});

        // Row 6
        gridWorld.setFeature(6,0,  new double[] {0});
        gridWorld.setFeature(6,1,  new double[] {1});
        gridWorld.setFeature(6,2,  new double[] {0});

        // Row 7
        gridWorld.setFeature(7,0,  new double[] {0});
        gridWorld.setFeature(7,1,  new double[] {1});
        gridWorld.setFeature(7,2,  new double[] {0});

        // Row 8
        gridWorld.setFeature(8,0,  new double[] {0});
        gridWorld.setFeature(8,1,  new double[] {0});
        gridWorld.setFeature(8,2,  new double[] {0});

        // Row 9
        gridWorld.setFeature(9,0,  new double[] {0});
        gridWorld.setFeature(9,1,  new double[] {0});
        gridWorld.setFeature(9,2,  new double[] {0});

        // Row 10
        gridWorld.setFeature(10,0,  new double[] {1});
        gridWorld.setFeature(10,1,  new double[] {0});
        gridWorld.setFeature(10,2,  new double[] {0});

        // Row 11
        gridWorld.setFeature(11,0,  new double[] {1});
        gridWorld.setFeature(11,1,  new double[] {1});
        gridWorld.setFeature(11,2,  new double[] {0});

        // Row 12
        gridWorld.setFeature(12,0,  new double[] {0});
        gridWorld.setFeature(12,1,  new double[] {1});
        gridWorld.setFeature(12,2,  new double[] {0});

        // Row 13
        gridWorld.setFeature(13,0,  new double[] {0});
        gridWorld.setFeature(13,1,  new double[] {0});
        gridWorld.setFeature(13,2,  new double[] {0});

        // Row 14
        gridWorld.setFeature(14,0,  new double[] {0});
        gridWorld.setFeature(14,1,  new double[] {0});
        gridWorld.setFeature(14,2,  new double[] {0});

        // Row 15
        gridWorld.setFeature(15,0,  new double[] {0});
        gridWorld.setFeature(15,1,  new double[] {0});
        gridWorld.setFeature(15,2,  new double[] {0});
    }

    @Override
    public ArrayList<Position> getNeighbours(Position current)
    {
        ArrayList<Position> neighbours = new ArrayList<>();
        Position neighbour;
        for(Action action: getActions())
        {
            neighbour = action.getNewPosition(current);
            if(gridWorld.isWithinBoundaries(neighbour))
                neighbours.add(neighbour);
        }
        return neighbours;
    }

    @Override
    public ArrayList<Action> getActions()
    {
        return this.actions;
    }

    private String getRepresentation(Position current)
    {
        StringBuilder out = new StringBuilder();
        for(int i = gridWorld.getNumberOfRows()-1; i >= 0; i--)
        {
            for(int j = 0; j < gridWorld.getNumberOfColumns(); j++)
            {
                Vector features = gridWorld.getFeatures(i, j);
                if(current.getRow() == i && current.getColumn() == j)
                    out.append("O");
                else if(features.getValues()[0] == 0)
                    out.append("+");
                else
                    out.append("#");
                if(j == 2)
                    out.append("\r\n");
            }
        }
        return out.toString();
    }

    public ArrayList<Position> learn() throws Exception
    {
        ArrayList<Position> trajectory = new ArrayList<>();

        Position current = gridWorld.getStartPosition();
        Action action;

        while(!gridWorld.hasReachedGoal(current))
        {
            System.out.println(getRepresentation(current));
            //System.out.println(current);
            System.out.print("Next action: ");
            Scanner scanner = new Scanner(System.in);
            char c = scanner.next().charAt(0);
            action = getActionFromInput(c);
            current = action.getNewPosition(current);
            trajectory.add(current);
            System.out.println(getRepresentation(current));
        }

        return trajectory;
    }

    public Action getActionFromInput(char c) throws Exception
    {
        if(c == 'a')
            return actions.get(0);
        else if(c == 'w')
            return actions.get(1);
        else if(c == 'd')
            return actions.get(2);
        else
            throw new Exception("Undefined action.");
    }

    @Override
    public int getNumberOfActions()
    {
        return actions.size();
    }

    @Override
    public GridWorld getGridWorld()
    {
        return this.gridWorld;
    }
}
