package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Autonomous Red Bot BDW")
public class RedBotAutoDrivebyTime_BlueSide extends LinearOpMode {
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;
    private DcMotor duckWheelBackleft;



    @Override
    public void runOpMode() throws InterruptedException {


        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        duckWheelBackleft = hardwareMap.get(DcMotor.class, "LeftDuckWheel");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();


        drive(-0.5, 600);
        spinWheel(-0.8,  5000);
        turn(-0.85, 1150);
        drive(0.5, 2600);

    }

    private void spinWheel(double speed, long sleep) throws InterruptedException{
        duckWheelBackleft.setPower(speed);
        Thread.sleep(sleep);
        duckWheelBackleft.setPower(0);
    }

    private void drive(double speed, long sleep) throws InterruptedException {
        frontRight.setPower(speed);
        backRight.setPower(speed);
        frontLeft.setPower(speed);
        backLeft.setPower(speed);
        Thread.sleep(sleep);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
    }
    private void turn(double speed, long sleep) throws InterruptedException {
        frontRight.setPower(speed);
        backRight.setPower(speed);
        frontLeft.setPower(-speed);
        backLeft.setPower(-speed);
        Thread.sleep(sleep);
        frontRight.setPower(0);
        backRight.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
    }
}
