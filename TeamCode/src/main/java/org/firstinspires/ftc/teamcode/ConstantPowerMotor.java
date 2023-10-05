package org.firstinspires.ftc.teamcode;

/*
Problem Statement: Run a motor at different constant speeds based on gamepad buttons
A-> 0.25 (run motor at quarter of full power)
B-> 0.50
X-> 0.75
Y-> 1.00 (run motor at full power)
 */

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class ConstantPowerMotor extends LinearOpMode {
    // 1. Declaring our variables, initialize our motors; null means nothing
    private DcMotor myMotor = null;
    @Override
    public void runOpMode() throws InterruptedException {
        //2. Initialize our telemetry (with a simple statement)
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //3. Add our motor to our config map. Call it myMotor (pay attention if it is different name)
        //Two args: 1. Class (e.g. DcMotor class) 2. name of the motor in quotes
        myMotor = hardwareMap.get(DcMotor.class, "myMotor");

        //4. Set our motor direction
        myMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        //5. waitForStart() acts like a "wall"; DS "play" button starts and the code runs afterwards
        waitForStart();

        //6. While loop
        while (opModeIsActive()) {

            //7. We need a way to detect the different button presses
            //these declarations are optional
            boolean aButtonPressed = gamepad1.a;
            boolean bButtonPressed = gamepad1.b;
            boolean xButtonPressed = gamepad1.x;
            boolean yButtonPressed = gamepad1.y;

            //8. Check if our buttons have been pressed
            if (aButtonPressed == true) {
                myMotor.setPower(0.25); //setPower method makes the motor spin
            } else if (bButtonPressed == true) {
                myMotor.setPower(0.50);
            } else if (xButtonPressed == true) {
                myMotor.setPower(0.75);
            } else if (yButtonPressed == true) {
                myMotor.setPower(1.00);
            } else {
                //Otherwise switch it off
                myMotor.setPower(0.0);
            }
            // 9. Deliver Telemetry to the phone so that we can see the value of the motors
            //telemetry.addData("A Button", gamepad1.a);
            telemetry.addData("Button A", aButtonPressed);
            telemetry.addData("Button B", bButtonPressed);
            telemetry.addData("Button X", xButtonPressed);
            telemetry.addData("Button Y", yButtonPressed);
            telemetry.addData("Motor Speed", myMotor.getPower());
            telemetry.update(); //prints it to the screen
        }
    }
}


