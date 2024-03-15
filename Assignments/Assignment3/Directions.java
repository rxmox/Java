package edu.ucalgary.oop;

// Enum for the directions of the robot
// an enum is a special "class" that represents a group of constants (unchangeable variables, like final variables).
// You should use enum types any time you need to represent a fixed set of constants.
// In this case, the fixed set of constants are the directions of the robot.
// The enum class can be accessed by using the dot notation: Directions.E
// method toString() is used to return the string representation of the enum constant
public enum Directions {
    E {
        public String toString() 
        {return "East";
    }
    },
    N {
        public String toString() 
        {return "North";
    }
    },
    NE {
        public String toString() {return "Northeast";
    }
    },
    NW {
        public String toString() 
        {return "Northwest";
    }
    },
    S {
        public String toString() 
        {return "South";
    }
    },
    SE {
        public String toString() 
        {return "Southeast";
    }
    },
    SW {
        public String toString() 
        {return "Southwest";
    }
    },
    W {
        public String toString() 
        {return "West";
    }
    };
    
    public abstract String toString();
}

