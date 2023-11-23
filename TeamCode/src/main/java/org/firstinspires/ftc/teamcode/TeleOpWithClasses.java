package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class TeleOpWithClasses extends LinearOpMode {
    // Declare Drive Motors
    DcMotor topLeft;
    DcMotor topRight;
    DcMotor bottomLeft;
    DcMotor bottomRight;

    // Declare Arm Motor
    DcMotor armMotor;

    double leftPower;
    double rightPower;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        topLeft = hardwareMap.get(DcMotor.class, "topLeft");
        topRight = hardwareMap.get(DcMotor.class, "topRight");
        bottomLeft = hardwareMap.get(DcMotor.class, "bottomLeft");
        bottomRight = hardwareMap.get(DcMotor.class, "bottomRight");
        armMotor = hardwareMap.get(DcMotor.class, "armMotor");

        topLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        topRight.setDirection(DcMotorSimple.Direction.FORWARD);
        bottomLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        bottomRight.setDirection(DcMotorSimple.Direction.REVERSE);
        armMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        TankDriveWithClasses myTankDrive = new TankDriveWithClasses(topLeft, topRight, bottomLeft, bottomRight);
        ArmWithClasses myArm = new ArmWithClasses(armMotor);
        waitForStart();//----------------------

        while(opModeIsActive()){
            leftPower = -gamepad1.left_stick_y;
            rightPower = -gamepad1.right_stick_y;
            myTankDrive.drive(leftPower, rightPower);

            if(gamepad1.a){
                myArm.raiseArm();
            }
            if(gamepad1.b){
                myArm.lowerArm();
            }

            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }
}
