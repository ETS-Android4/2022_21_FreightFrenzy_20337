package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "SayWattBlueTeleOp (Blocks to Java)")
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

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    boolean Turnleft;
    boolean Turnright;
    float Leftstickpower;
    float Leftstickturn;

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
      Turnleft = gamepad1.left_bumper;
      Turnright = gamepad1.right_bumper;
      Leftstickpower = gamepad1.left_stick_y;
      Leftstickturn = gamepad1.left_stick_x;
      armMotor.setPower(gamepad1.right_stick_y);

      if (gamepad1.dpad_up) {
        rightFront.setPower(-1.1);
        leftFront.setPower(-1.1);
        leftRear.setPower(1.1);
        rightRear.setPower(1.1);
      } else if (gamepad1.dpad_left) {
        rightFront.setPower(-1.1);
        leftFront.setPower(1.1);
        rightRear.setPower(1.1);
        leftRear.setPower(-1.1);
      } else if (gamepad1.dpad_right) {
        rightFront.setPower(1.1);
        leftFront.setPower(-1.1);
        rightRear.setPower(-1.1);
        leftRear.setPower(1.1);
      } else if (gamepad1.dpad_down) {
        leftFront.setPower(1.1);
        rightFront.setPower(1.1);
        rightRear.setPower(-1.1);
        leftRear.setPower(-1.1);
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