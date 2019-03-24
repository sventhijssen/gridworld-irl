package examples;

import main.GridWorld;
import main.Position;
import main.State;
import main.Vector;

import java.util.ArrayList;

public class BicycleExample
{
    private GridWorld world = new GridWorld(10, 16);
    private ArrayList<Position> trajectory = new ArrayList<>();


    public BicycleExample()
    {
        // Row 0
        world.setFeature(0,0, new double[] {0, 1, 0, 0});
        world.setFeature(0,1, new double[] {1, 0, 0, 1});
        world.setFeature(0,2, new double[] {1, 0, 0, 1});
        world.setFeature(0,3, new double[] {1, 0, 0, 1});
        world.setFeature(0,4, new double[] {1, 0, 0, 0});
        world.setFeature(0,5, new double[] {1, 0, 0, 0});
        world.setFeature(0,6, new double[] {1, 0, 0, 0});
        world.setFeature(0,7, new double[] {1, 0, 0, 0});
        world.setFeature(0,8, new double[] {1, 0, 0, 0});
        world.setFeature(0,9, new double[] {1, 0, 0, 0});
        world.setFeature(0,10, new double[] {1, 0, 0, 0});
        world.setFeature(0,11, new double[] {0, 1, 0, 0});
        world.setFeature(0,12, new double[] {1, 0, 0, 0});
        world.setFeature(0,13, new double[] {1, 0, 0, 0});
        world.setFeature(0,14, new double[] {1, 0, 0, 0});
        world.setFeature(0,15, new double[] {1, 0, 0, 0});

        // Row 1
        world.setFeature(1,0, new double[] {0, 1, 0, 0});
        world.setFeature(1,1, new double[] {1, 0, 0, 1});
        world.setFeature(1,2, new double[] {1, 0, 0, 1});
        world.setFeature(1,3, new double[] {1, 0, 0, 1});
        world.setFeature(1,4, new double[] {1, 0, 0, 0});
        world.setFeature(1,5, new double[] {1, 0, 0, 0});
        world.setFeature(1,6, new double[] {1, 0, 0, 0});
        world.setFeature(1,7, new double[] {1, 0, 0, 0});
        world.setFeature(1,8, new double[] {1, 0, 0, 0});
        world.setFeature(1,9, new double[] {1, 0, 0, 0});
        world.setFeature(1,10, new double[] {0, 0, 1, 0});
        world.setFeature(1,11, new double[] {1, 0, 0, 0});
        world.setFeature(1,12, new double[] {1, 0, 0, 0});
        world.setFeature(1,13, new double[] {1, 0, 0, 0});
        world.setFeature(1,14, new double[] {1, 0, 0, 0});
        world.setFeature(1,15, new double[] {1, 0, 0, 0});

        // Row 2
        world.setFeature(2,0, new double[] {0, 1, 0, 0});
        world.setFeature(2,1, new double[] {0, 1, 0, 0});
        world.setFeature(2,2, new double[] {0, 1, 0, 0});
        world.setFeature(2,3, new double[] {1, 0, 0, 0});
        world.setFeature(2,4, new double[] {0, 1, 0, 0});
        world.setFeature(2,5, new double[] {0, 1, 0, 0});
        world.setFeature(2,6, new double[] {0, 1, 0, 0});
        world.setFeature(2,7, new double[] {0, 1, 0, 0});
        world.setFeature(2,8, new double[] {0, 1, 0, 0});
        world.setFeature(2,9, new double[] {0, 1, 0, 0});
        world.setFeature(2,10, new double[] {0, 0, 1, 0});
        world.setFeature(2,11, new double[] {0, 1, 0, 0});
        world.setFeature(2,12, new double[] {0, 1, 0, 0});
        world.setFeature(2,13, new double[] {0, 1, 0, 0});
        world.setFeature(2,14, new double[] {0, 1, 0, 0});
        world.setFeature(2,15, new double[] {1, 0, 0, 0});

        // Row 3
        world.setFeature(3,0, new double[] {1, 0, 0, 0});
        world.setFeature(3,1, new double[] {1, 0, 0, 0});
        world.setFeature(3,2, new double[] {1, 0, 0, 0});
        world.setFeature(3,3, new double[] {1, 0, 0, 0});
        world.setFeature(3,4, new double[] {0, 0, 1, 0});
        world.setFeature(3,5, new double[] {0, 0, 1, 0});
        world.setFeature(3,6, new double[] {0, 0, 1, 0});
        world.setFeature(3,7, new double[] {0, 0, 1, 0});
        world.setFeature(3,8, new double[] {0, 0, 1, 0});
        world.setFeature(3,9, new double[] {0, 0, 1, 0});
        world.setFeature(3,10, new double[] {0, 0, 1, 0});
        world.setFeature(3,11, new double[] {0, 0, 1, 0});
        world.setFeature(3,12, new double[] {1, 0, 0, 0});
        world.setFeature(3,13, new double[] {1, 0, 0, 0});
        world.setFeature(3,14, new double[] {1, 0, 0, 0});
        world.setFeature(3,15, new double[] {1, 0, 0, 0});

        // Row 4
        world.setFeature(4,0, new double[] {0, 1, 0, 0});
        world.setFeature(4,1, new double[] {0, 1, 0, 0});
        world.setFeature(4,2, new double[] {1, 0, 0, 0});
        world.setFeature(4,3, new double[] {1, 0, 0, 0});
        world.setFeature(4,4, new double[] {0, 1, 0, 0});
        world.setFeature(4,5, new double[] {0, 1, 0, 0});
        world.setFeature(4,6, new double[] {0, 1, 0, 0});
        world.setFeature(4,7, new double[] {0, 1, 0, 0});
        world.setFeature(4,8, new double[] {0, 1, 0, 0});
        world.setFeature(4,9, new double[] {0, 1, 0, 0});
        world.setFeature(4,10, new double[] {0, 0, 1, 0});
        world.setFeature(4,11, new double[] {0, 0, 1, 0});
        world.setFeature(4,12, new double[] {0, 1, 0, 0});
        world.setFeature(4,13, new double[] {0, 1, 0, 0});
        world.setFeature(4,14, new double[] {0, 1, 0, 0});
        world.setFeature(4,15, new double[] {1, 0, 0, 0});

        // Row 5
        world.setFeature(5,0, new double[] {1, 0, 0, 0});
        world.setFeature(5,1, new double[] {1, 0, 0, 0});
        world.setFeature(5,2, new double[] {1, 0, 0, 0});
        world.setFeature(5,3, new double[] {1, 0, 0, 0});
        world.setFeature(5,4, new double[] {1, 0, 0, 0});
        world.setFeature(5,5, new double[] {1, 0, 0, 0});
        world.setFeature(5,6, new double[] {0, 0, 1, 0});
        world.setFeature(5,7, new double[] {0, 0, 1, 0});
        world.setFeature(5,8, new double[] {0, 0, 1, 0});
        world.setFeature(5,9, new double[] {0, 0, 1, 0});
        world.setFeature(5,10, new double[] {0, 0, 1, 0});
        world.setFeature(5,11, new double[] {0, 0, 1, 0});
        world.setFeature(5,12, new double[] {0, 0, 1, 0});
        world.setFeature(5,13, new double[] {1, 0, 0, 0});
        world.setFeature(5,14, new double[] {1, 0, 0, 0});
        world.setFeature(5,15, new double[] {1, 0, 0, 0});

        // Row 6
        world.setFeature(6,0, new double[] {1, 0, 0, 0});
        world.setFeature(6,1, new double[] {1, 0, 0, 0});
        world.setFeature(6,2, new double[] {1, 0, 0, 0});
        world.setFeature(6,3, new double[] {1, 0, 0, 0});
        world.setFeature(6,4, new double[] {1, 0, 0, 0});
        world.setFeature(6,5, new double[] {1, 0, 0, 0});
        world.setFeature(6,6, new double[] {1, 0, 0, 0});
        world.setFeature(6,7, new double[] {1, 0, 0, 0});
        world.setFeature(6,8, new double[] {0, 0, 1, 0});
        world.setFeature(6,9, new double[] {0, 0, 1, 0});
        world.setFeature(6,10, new double[] {0, 0, 1, 0});
        world.setFeature(6,11, new double[] {1, 0, 0, 0});
        world.setFeature(6,12, new double[] {1, 0, 0, 0});
        world.setFeature(6,13, new double[] {1, 0, 0, 0});
        world.setFeature(6,14, new double[] {1, 0, 0, 0});
        world.setFeature(6,15, new double[] {1, 0, 0, 0});

        // Row 7
        world.setFeature(7,0, new double[] {0, 1, 0, 0});
        world.setFeature(7,1, new double[] {0, 1, 0, 0});
        world.setFeature(7,2, new double[] {0, 1, 0, 0});
        world.setFeature(7,3, new double[] {1, 0, 0, 0});
        world.setFeature(7,4, new double[] {0, 1, 0, 0});
        world.setFeature(7,5, new double[] {0, 1, 0, 0});
        world.setFeature(7,6, new double[] {0, 1, 0, 0});
        world.setFeature(7,7, new double[] {0, 1, 0, 0});
        world.setFeature(7,8, new double[] {0, 1, 0, 0});
        world.setFeature(7,9, new double[] {0, 1, 0, 0});
        world.setFeature(7,10, new double[] {1, 0, 0, 0});
        world.setFeature(7,11, new double[] {0, 1, 0, 0});
        world.setFeature(7,12, new double[] {0, 1, 0, 0});
        world.setFeature(7,13, new double[] {0, 1, 0, 0});
        world.setFeature(7,14, new double[] {0, 1, 0, 0});
        world.setFeature(7,15, new double[] {1, 0, 0, 0});

        // Row 8
        world.setFeature(8,0, new double[] {1, 0, 0, 0});
        world.setFeature(8,1, new double[] {1, 0, 0, 0});
        world.setFeature(8,2, new double[] {1, 0, 0, 0});
        world.setFeature(8,3, new double[] {1, 0, 0, 0});
        world.setFeature(8,4, new double[] {1, 0, 0, 0});
        world.setFeature(8,5, new double[] {1, 0, 0, 0});
        world.setFeature(8,6, new double[] {1, 0, 0, 0});
        world.setFeature(8,7, new double[] {1, 0, 0, 0});
        world.setFeature(8,8, new double[] {1, 0, 0, 0});
        world.setFeature(8,9, new double[] {1, 0, 0, 0});
        world.setFeature(8,10, new double[] {1, 0, 0, 0});
        world.setFeature(8,11, new double[] {1, 0, 0, 0});
        world.setFeature(8,12, new double[] {1, 0, 0, 0});
        world.setFeature(8,13, new double[] {1, 0, 0, 0});
        world.setFeature(8,14, new double[] {1, 0, 0, 0});
        world.setFeature(8,15, new double[] {1, 0, 0, 0});

        // Row 9
        world.setFeature(9,0, new double[] {0, 1, 0, 0});
        world.setFeature(9,1, new double[] {0, 1, 0, 0});
        world.setFeature(9,2, new double[] {0, 1, 0, 0});
        world.setFeature(9,3, new double[] {0, 1, 0, 0});
        world.setFeature(9,4, new double[] {0, 1, 0, 0});
        world.setFeature(9,5, new double[] {0, 1, 0, 0});
        world.setFeature(9,6, new double[] {0, 1, 0, 0});
        world.setFeature(9,7, new double[] {0, 1, 0, 0});
        world.setFeature(9,8, new double[] {0, 1, 0, 0});
        world.setFeature(9,9, new double[] {0, 1, 0, 0});
        world.setFeature(9,10, new double[] {0, 1, 0, 0});
        world.setFeature(9,11, new double[] {0, 1, 0, 0});
        world.setFeature(9,12, new double[] {0, 1, 0, 0});
        world.setFeature(9,13, new double[] {0, 1, 0, 0});
        world.setFeature(9,14, new double[] {0, 1, 0, 0});
        world.setFeature(9,15, new double[] {1, 0, 0, 0});

        world.setStartPosition(0,10);
        world.setGoalPosition(5,2);
        trajectory.add(new Position(0,10));
    }

    public boolean hasReachedGoal()
    {
        return (getPosition().equals(world.getGoalPosition()));
    }

    public Position getPosition()
    {
        return trajectory.get(trajectory.size()-1);
    }


    @Override
    public String toString()
    {
        StringBuilder out = new StringBuilder();
        for(int i=world.getRows()-1; i >= 0; i--)
        {
            for(int j=world.getColumns()-1; j >= 0; j--)
            {
                State state = world.getState(i, j);
                if(getPosition().getRow() == i && getPosition().getColumn() == j)
                    out.append("O");
                else if(state.getFeatures().getData()[0] == 1 && state.getFeatures().getData()[3] != 1)
                    out.append("+");
                else if(state.getFeatures().getData()[1] == 1)
                    out.append("#");
                else if(state.getFeatures().getData()[2] == 1)
                    out.append("~");
                else if(state.getFeatures().getData()[3] == 1)
                    out.append("*");
                if(j == 0)
                    out.append("\r\n");
            }
        }
        return out.toString();
    }

    public ArrayList<Position> getTrajectory()
    {
        return this.trajectory;
    }

    public void setNextPosition(char c)
    {
        Position position = getPosition();
        // left
        if(c == 'a')
            position = new Position(position.getRow(), position.getColumn()+1);
        // up
        else if(c == 'w')
            position = new Position(position.getRow()+1, position.getColumn());
        // right
        else if(c == 'd')
            position = new Position(position.getRow(), position.getColumn()-1);
        // down
        else if(c == 's')
            position = new Position(position.getRow()-1, position.getColumn());
        trajectory.add(position);
    }

    public Vector getFeatureExpectations()
    {
        return world.getFeatureExpectations(trajectory);
    }

    public GridWorld getWorld()
    {
        return this.world;
    }
}
