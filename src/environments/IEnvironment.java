package environments;

import main.Action;
import main.GridWorld;
import main.Position;

import java.util.ArrayList;
import java.util.Collection;

public interface IEnvironment
{
    ArrayList<Position> getNeighbours(Position current);
    ArrayList<Action> getActions();
    ArrayList<Position> learn() throws Exception;
    int getNumberOfActions();
    Action getActionFromInput(char c) throws Exception;
    GridWorld getGridWorld();
}
