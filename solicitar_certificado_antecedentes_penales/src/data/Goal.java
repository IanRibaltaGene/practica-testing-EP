package data;

import exception.NullGoalException;

final public class Goal {
    goalTypes type;

    public Goal(goalTypes type) throws NullGoalException {
        if(type == null){
            throw new NullGoalException("Type must not be null");
        }
        this.type=type;
    }

    public goalTypes getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goal goal = (Goal) o;

        return getType() == goal.getType();
    }

    @Override
    public int hashCode() {
        return getType().hashCode();
    }
}
