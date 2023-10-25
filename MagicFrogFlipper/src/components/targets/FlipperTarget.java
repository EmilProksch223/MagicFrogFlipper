package components.targets;

import visitors.FlipperTargetVisitor;

public abstract class FlipperTarget {
    private int pointValue;
    public abstract void accept(FlipperTargetVisitor visitor);
    public abstract int getPointValue();
    public abstract void playEvent();
}