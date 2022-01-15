package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Pushbot: Auto Drive By Time Blue", group="Pushbot")
public class BlueBotAutoDriveByTime_Linear extends LinearOpMode {

    static final double     COUNTS_PER_MOTOR_REV    = 1120;
    static final double     DRIVE_GEAR_REDUCTION    = 1.0;
    static final double     WHEEL_DIAMETER_INCHES   = 4.5;
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    private ElapsedTime runtime = new ElapsedTime();
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


        drive(-0.5, 150);
        spinWheel(-0.8,  5000);


    }

    private void spinWheel(double speed, long sleep) throws InterruptedException{
        duckWheel.setPower(speed);
        Thread.sleep(sleep);
        duckWheel.setPower(0);
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


}