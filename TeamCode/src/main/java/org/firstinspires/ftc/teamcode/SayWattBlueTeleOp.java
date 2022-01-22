package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "SayWattBlueTeleOp")
public class SayWattBlueTeleOp extends LinearOpMode {
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

    rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    rightRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    leftRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    duckWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    // Put initialization blocks here.
    Rightgrabberservo.setDirection(Servo.Direction.FORWARD);
    Leftgrabberservo.setDirection(Servo.Direction.REVERSE);
    leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
    rightRear.setDirection(DcMotorSimple.Direction.REVERSE);
    waitForStart();

    while (opModeIsActive()) {
      double SpeedOfRobotUpDownLeftRight = 0.5;
      double SpeedOfRobotArm = 0;
      if (gamepad1.left_bumper) {
        telemetry.addLine("Drive: Fast Speed");
        SpeedOfRobotUpDownLeftRight = 0.9;
      } else {
        telemetry.addLine("Drive: Default Speed");
        SpeedOfRobotUpDownLeftRight = 0.5;
      }
      if (gamepad1.right_bumper) {
        telemetry.addLine("Arm: Slowed Speed");
        SpeedOfRobotArm = 0.4;
      } else {
        telemetry.addLine("Arm: Default Speed");
        SpeedOfRobotArm = 0;
      }
      telemetry.update();

      armMotor.setPower(gamepad1.right_stick_y-SpeedOfRobotArm);
      if (gamepad1.dpad_up) {
        rightFront.setPower(-SpeedOfRobotUpDownLeftRight);
        leftFront.setPower(-SpeedOfRobotUpDownLeftRight);
        leftRear.setPower(SpeedOfRobotUpDownLeftRight);
        rightRear.setPower(SpeedOfRobotUpDownLeftRight);
      } else if (gamepad1.dpad_left) {
        rightFront.setPower(-SpeedOfRobotUpDownLeftRight);
        leftFront.setPower(SpeedOfRobotUpDownLeftRight);
        rightRear.setPower(SpeedOfRobotUpDownLeftRight);
        leftRear.setPower(-SpeedOfRobotUpDownLeftRight);
      } else if (gamepad1.dpad_right) {
        rightFront.setPower(SpeedOfRobotUpDownLeftRight);
        leftFront.setPower(-SpeedOfRobotUpDownLeftRight);
        rightRear.setPower(-SpeedOfRobotUpDownLeftRight);
        leftRear.setPower(SpeedOfRobotUpDownLeftRight);
      } else if (gamepad1.dpad_down) {
        leftFront.setPower(SpeedOfRobotUpDownLeftRight);
        rightFront.setPower(SpeedOfRobotUpDownLeftRight);
        rightRear.setPower(-SpeedOfRobotUpDownLeftRight);
        leftRear.setPower(-SpeedOfRobotUpDownLeftRight);
      } else {
        rightFront.setPower(0);
        leftFront.setPower(0);
        rightRear.setPower(0);
        leftRear.setPower(0);
      }


      if (gamepad1.a) {
        duckWheel.setPower(0.9);
      } else if (gamepad1.b) {
        duckWheel.setPower(-0.9);
      } else {
        duckWheel.setPower(0);
      }
      if (gamepad1.y) {
        duckwheel2.setPower(0.9);
      } else if (gamepad1.x) {
        duckwheel2.setPower(-0.9);
      } else {
        duckwheel2.setPower(0);
      }
      if (gamepad2.right_bumper) {
        Leftgrabberservo.setPosition(1);
        Rightgrabberservo.setPosition(1);
      } else if (gamepad2.left_bumper) {
        Leftgrabberservo.setPosition(0);
        Rightgrabberservo.setPosition(0);
      }


    }

  }
}