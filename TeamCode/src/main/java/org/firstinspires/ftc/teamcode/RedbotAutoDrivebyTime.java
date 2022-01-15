package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Autonomous Red Bot RDW")
public class RedbotAutoDrivebyTime extends LinearOpMode {
    private DcMotor frontright;
    private DcMotor frontleft;
    private DcMotor backright;
    private DcMotor backleft;
    private DcMotor duckWheelBackright;
    private Servo Leftgrabberservo;
    private DcMotor arm;
    private DcMotor armExtension;


    @Override
    public void runOpMode() throws InterruptedException {


        frontright = hardwareMap.get(DcMotor.class, "frontright");
        frontleft = hardwareMap.get(DcMotor.class, "frontleft");
        backright = hardwareMap.get(DcMotor.class, "backright");
        backleft = hardwareMap.get(DcMotor.class, "backleft");
        duckWheelBackright = hardwareMap.get(DcMotor.class, "duckWheelBackright");
        Leftgrabberservo = hardwareMap.get(Servo.class, "Leftgrabberservo");
        arm = hardwareMap.get(DcMotor.class, "arm");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        frontleft.setDirection(DcMotorSimple.Direction.FORWARD);
        backright.setDirection(DcMotorSimple.Direction.REVERSE);
        backleft.setDirection(DcMotorSimple.Direction.FORWARD);
        frontright.setDirection(DcMotorSimple.Direction.REVERSE);
        Leftgrabberservo.setDirection(Servo.Direction.FORWARD);

        waitForStart();


        drive(-0.5, 150);
        spinWheel(-0.8,  5000);
        turn(0.85, 800);
        drive(0.5, 1800);

    }

    private void spinWheel(double speed, long sleep) throws InterruptedException{
        duckWheelBackright.setPower(speed);
        Thread.sleep(sleep);
        duckWheelBackright.setPower(0);
    }

    private void drive(double speed, long sleep) throws InterruptedException {
        frontright.setPower(speed);
        backright.setPower(speed);
        frontleft.setPower(speed);
        backleft.setPower(speed);
        Thread.sleep(sleep);
        frontright.setPower(0);
        backright.setPower(0);
        frontleft.setPower(0);
        backleft.setPower(0);
    }
        private void turn(double speed, long sleep) throws InterruptedException {
            frontright.setPower(speed);
            backright.setPower(speed);
            frontleft.setPower(-speed);
            backleft.setPower(-speed);
            Thread.sleep(sleep);
            frontright.setPower(0);
            backright.setPower(0);
            frontleft.setPower(0);
            backleft.setPower(0);
    }
}
