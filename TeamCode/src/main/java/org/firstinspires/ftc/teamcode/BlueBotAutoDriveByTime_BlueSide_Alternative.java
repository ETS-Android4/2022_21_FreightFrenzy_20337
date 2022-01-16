package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Autonomous Blue Side Stgraight")
public class BlueBotAutoDriveByTime_BlueSide_Alternative extends LinearOpMode{
    private DcMotor rightFront;
    private DcMotor leftFront;
    private DcMotor rightRear;
    private DcMotor leftRear;
    private DcMotor duckWheel;
    private Servo Rightgrabberservo;
    private Servo Leftgrabberservo;
    private DcMotor armMotor;
    private DcMotor duckwheel2;


    @Override
    public void runOpMode() throws InterruptedException {

        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightRear = hardwareMap.get(DcMotor.class, "rightRear");
        leftRear = hardwareMap.get(DcMotor.class, "leftRear");
        duckWheel = hardwareMap.get(DcMotor.class, "duckwheel");
        Rightgrabberservo = hardwareMap.get(Servo.class, "Rightgrabberservo");
        Leftgrabberservo = hardwareMap.get(Servo.class, "Leftgrabberservo");
        armMotor = hardwareMap.get(DcMotor.class, "AAAAAARM");
        duckwheel2 = hardwareMap.get(DcMotor.class, "duckwheel2");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        rightRear.setDirection(DcMotorSimple.Direction.REVERSE);
        leftRear.setDirection(DcMotorSimple.Direction.FORWARD);
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        Rightgrabberservo.setDirection(Servo.Direction.REVERSE);
        Leftgrabberservo.setDirection(Servo.Direction.FORWARD);

        waitForStart();


        drive(0.5, 600);
        turn(0.85, 800);
        drive(0.5, 2050);


    }

    private void spinWheel(double speed, long sleep) throws InterruptedException{
        duckwheel2.setPower(speed);
        Thread.sleep(sleep);
        duckwheel2.setPower(0);
    }

    private void drive(double speed, long sleep) throws InterruptedException{
        rightFront.setPower(speed);
        rightRear.setPower(speed);
        leftFront.setPower(speed);
        leftRear.setPower(speed);
        Thread.sleep(sleep);
        rightFront.setPower(0);
        rightRear.setPower(0);
        leftFront.setPower(0);
        leftRear.setPower(0);
    }

    private void turn(double speed, long sleep) throws InterruptedException {
        rightFront.setPower(-speed);
        rightRear.setPower(-speed);
        leftFront.setPower(speed);
        leftRear.setPower(speed);
        Thread.sleep(sleep);
        rightFront.setPower(0);
        rightRear.setPower(0);
        leftFront.setPower(0);
        leftRear.setPower(0);
    }
}
