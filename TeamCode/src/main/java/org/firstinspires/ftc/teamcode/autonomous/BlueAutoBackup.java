package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.RobotLog;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name = "BlueAutoBackup")
public class BlueAutoBackup extends LinearOpMode {
    private DistanceSensor sensorRange;
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;
    private DcMotor duckWheelRight;
    private DcMotor duckWheelLeft;
    private Servo grabber;
    private DcMotor arm;
    private DcMotor armExtension;

    @Override
    public void runOpMode() throws InterruptedException {
        sensorRange = hardwareMap.get(DistanceSensor.class, "distanceSensor");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        grabber = hardwareMap.get(Servo.class, "grabber");
        arm = hardwareMap.get(DcMotor.class, "arm");
        duckWheelLeft = hardwareMap.get(DcMotor.class, "duckWheelLeft");
        duckWheelRight = hardwareMap.get(DcMotor.class, "duckWheelRight");
        armExtension = hardwareMap.get(DcMotor.class, "armExtension");

        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        int levelOnHub = 0;
        double distance;
        boolean foundCup;

        grabber.setPosition(0);

        telemetry.addData(">>", "Press start to continue");
        telemetry.update();
        waitForStart();

        drive(-0.5, 250);
        spinWheel(1.1, 3000);
        strafe(-1, 1000);
        drive(-0.5,2000);
        strafe(-1,2000);
    }

    public void drive(double speed, long time) throws InterruptedException {
        frontLeft.setPower(speed);
        frontRight.setPower(speed);
        backLeft.setPower(speed);
        backRight.setPower(speed);
        Thread.sleep(time);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    public void turn(double speed, long time, boolean right) throws  InterruptedException {
        if (right) {
            frontRight.setPower(-speed);
            frontLeft.setPower(speed);
            backRight.setPower(-speed);
            backLeft.setPower(speed);
        } else {
            frontRight.setPower(speed);
            frontLeft.setPower(-speed);
            backRight.setPower(speed);
            backLeft.setPower(-speed);
        }
        Thread.sleep(time);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    private void spinWheel(double speed, long time) throws InterruptedException{
        duckWheelLeft.setPower(speed);
        duckWheelRight.setPower(speed);
        Thread.sleep(time);
        duckWheelLeft.setPower(0);
        duckWheelRight.setPower(0);
    }

    public double getDistanceFromCup() {
        double distance = sensorRange.getDistance(DistanceUnit.CM);
        return distance;
    }

    public boolean checkFoundCup(double distance, int threshold) {
        boolean foundCup = false;
        if (distance < threshold) {
            foundCup = true;
        } else {
            foundCup = false;
        }
        return foundCup;
    }
    private void strafe(double speed, long time) throws InterruptedException {
        frontRight.setPower(speed);
        frontLeft.setPower(-speed);
        backRight.setPower(-speed);
        backLeft.setPower(speed);
        Thread.sleep(time);
        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
    }
}