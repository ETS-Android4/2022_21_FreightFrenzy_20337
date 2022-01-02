package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "SayWattBlueTeleOp (Blocks to Java)")
public class SayWattBlueTeleOp extends LinearOpMode {

  private DcMotor Rightfront;
  private DcMotor Leftfront;
  private DcMotor rightrear;
  private DcMotor leftrear;
  private DcMotor duckwheel;
  private Servo Rightgrabberservo;
  private Servo Leftgrabberservo;
  private DcMotor AAAAAARM;
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

    Rightfront = hardwareMap.get(DcMotor.class, "Rightfront");
    Leftfront = hardwareMap.get(DcMotor.class, "Leftfront");
    rightrear = hardwareMap.get(DcMotor.class, "rightrear");
    leftrear = hardwareMap.get(DcMotor.class, "leftrear");
    duckwheel = hardwareMap.get(DcMotor.class, "duckwheel");
    Rightgrabberservo = hardwareMap.get(Servo.class, "Rightgrabberservo");
    Leftgrabberservo = hardwareMap.get(Servo.class, "Leftgrabberservo");
    AAAAAARM = hardwareMap.get(DcMotor.class, "AAAAAARM");
    duckwheel2 = hardwareMap.get(DcMotor.class, "duckwheel2");

    Rightfront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    Leftfront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    rightrear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    leftrear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    duckwheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    // Put initialization blocks here.
    Rightgrabberservo.setDirection(Servo.Direction.FORWARD);
    Leftgrabberservo.setDirection(Servo.Direction.REVERSE);
    waitForStart();
    Leftfront.setDirection(DcMotorSimple.Direction.REVERSE);
    rightrear.setDirection(DcMotorSimple.Direction.REVERSE);
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        Turnleft = gamepad1.left_bumper;
        Turnright = gamepad1.right_bumper;
        Leftstickpower = gamepad1.left_stick_y;
        Leftstickturn = gamepad1.left_stick_x;
        // Put loop blocks here.
        telemetry.update();
        AAAAAARM.setPower(gamepad1.right_stick_y);
        if (gamepad1.dpad_up) {
          Rightfront.setPower(-0.5);
          Leftfront.setPower(-0.5);
          leftrear.setPower(0.5);
          rightrear.setPower(0.5);
        } else if (gamepad1.dpad_left) {
          Rightfront.setPower(-0.5);
          Leftfront.setPower(0.5);
          rightrear.setPower(0.5);
          leftrear.setPower(-0.5);
        } else {
          if (gamepad1.dpad_right) {
            Rightfront.setPower(0.5);
            Leftfront.setPower(-0.5);
            rightrear.setPower(-0.5);
            leftrear.setPower(0.5);
          } else {
            Rightfront.setPower(0);
            Leftfront.setPower(0);
            rightrear.setPower(0);
            leftrear.setPower(0);
          }
          if (gamepad1.dpad_down) {
            Leftfront.setPower(0.5);
            Rightfront.setPower(0.5);
            rightrear.setPower(-0.5);
            leftrear.setPower(-0.5);
          }
        }
        if (gamepad1.a) {
          duckwheel.setPower(0.7);
        } else if (gamepad1.b) {
          duckwheel.setPower(-0.7);
        } else {
          duckwheel.setPower(0);
        }
        if (gamepad1.y) {
          duckwheel2.setPower(0.7);
        } else if (gamepad1.x) {
          duckwheel2.setPower(-0.7);
        } else {
          duckwheel2.setPower(0);
        }
        if (gamepad2.right_bumper) {
          Leftgrabberservo.setPosition(1);
          Rightgrabberservo.setPosition(1);
        } else if (gamepad2.left_bumper) {
          Leftgrabberservo.setPosition(0);
          Rightgrabberservo.setPosition(0);
        } else {
        }
      }
    }
  }
}
