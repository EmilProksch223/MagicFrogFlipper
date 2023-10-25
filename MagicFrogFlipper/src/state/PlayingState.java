package state;

import components.Flipper;
import components.targets.Bumper;
import components.targets.FlipperTarget;
import components.targets.Hole;
import components.targets.Ramp;
import components.targets.Target;
import visitors.FlipperTargetVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayingState extends FlipperState {

    private FlipperTargetVisitor targetVisitor = new FlipperTargetVisitor();
    private Random random = new Random();
    private String message = "Der Ball wird hochgeschossen!\n";

    public PlayingState(Flipper flipper) {
        super(flipper);
    }

    private void processTargets() {
        List<FlipperTarget> targets = new ArrayList<>();
        targets.add(new Bumper());
        targets.add(new Hole());
        targets.add(new Ramp());
        targets.add(new Target());

        List<FlipperTarget> selectedTargets = new ArrayList<>();
        selectedTargets.add(targets.get(random.nextInt(targets.size())));

        if (random.nextDouble() < 0.5) {
            selectedTargets.add(targets.get(random.nextInt(targets.size())));
            if (random.nextDouble() < 0.25) {
                selectedTargets.add(targets.get(random.nextInt(targets.size())));
            }
        }

        for (FlipperTarget target : selectedTargets) {
            target.accept(targetVisitor);
        }

        System.out.printf("%d\n", targetVisitor.getCurrentPoints());
    }

    @Override
    public void insertCoin() {
        Flipper flipper = getFlipper();
        System.out.printf("Münze wurde eingeworfen! ");
        flipper.addOneCredit();
        System.out.printf("Sie haben %d Credits.\n", flipper.getCredit());
    }

    @Override
    public void start() {
        System.out.println("Sie befinden sich bereits im Spiel!");
    }

    @Override
    public void leftControl() {
        System.out.println("Left flipper activated!");
        processTargets();
    }

    @Override
    public void rightControl() {
        System.out.println("Right flipper activated!");
        processTargets();
    }

    @Override
    public void bothControl() {
        System.out.println("Both flippers activated!");
        processTargets();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
