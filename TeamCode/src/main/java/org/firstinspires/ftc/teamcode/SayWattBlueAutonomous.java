package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="Basic: Linear OpMode")
public class SayWattBlueAutonomous extends LinearOpMode {

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

        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightRear.setDirection(DcMotorSimple.Direction.REVERSE);

        Rightgrabberservo.setPosition(0);
        Leftgrabberservo.setPosition(0);

        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

        }
    }
}
