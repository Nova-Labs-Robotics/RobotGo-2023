package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class TankDriveWithClasses{
    // Attributes of the TankDrive class
    DcMotor topLeft;
    DcMotor topRight;
    DcMotor bottomLeft;
    DcMotor bottomRight;

    // Constructor - Used to create our objects.
    public TankDriveWithClasses(DcMotor topLeft, DcMotor topRight, DcMotor bottomLeft, DcMotor bottomRight) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

    // A method of the TankDrive class
    public void drive(double leftPower, double rightPower){
        topLeft.setPower(leftPower);
        topRight.setPower(leftPower);
        bottomLeft.setPower(rightPower);
        bottomRight.setPower(rightPower);
    }
}
