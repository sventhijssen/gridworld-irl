package examples;

import main.GridWorld;
import main.Policy;

public interface IExample
{
    GridWorld getLearningWorld();
    Policy getExpertPolicy();
    GridWorld getTestingWorld();
}
