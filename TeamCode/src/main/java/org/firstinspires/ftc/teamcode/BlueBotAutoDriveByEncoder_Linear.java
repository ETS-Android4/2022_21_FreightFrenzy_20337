package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="Pushbot: Auto Drive By Encoder Blue", group="Pushbot")
public class BlueBotAutoDriveByEncoder_Linear extends LinearOpMode {

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
    public void runOpMode() {
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
        rightRear.setDirection(DcMotorSimple.Direction.FORWARD);
        leftRear.setDirection(DcMotorSimple.Direction.FORWARD);
        leftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        Rightgrabberservo.setDirection(Servo.Direction.REVERSE);
        Leftgrabberservo.setDirection(Servo.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()) {
            Rightgrabberservo.setPosition(0);
            Leftgrabberservo.setPosition(0);

            rightFront.setPower(-0.5);
            leftFront.setPower(-0.5);
            leftRear.setPower(-0.5);
            rightRear.setPower(-0.5);
        }
    }
}