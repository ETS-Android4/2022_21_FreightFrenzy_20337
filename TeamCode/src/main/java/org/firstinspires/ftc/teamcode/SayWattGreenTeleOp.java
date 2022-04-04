package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "SayWattGreenTeleOp")
public class SayWattGreenTeleOp extends LinearOpMode {
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;
    private DcMotor duckWheelMiddle;
    private DcMotor armMotor;

    @Override
    public void runOpMode() {
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        duckWheelMiddle = hardwareMap.get(DcMotor.class, "duckWheel");
        armMotor = hardwareMap.get(DcMotor.class, "armMotor");

        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        telemetry.addLine("Hi, I am Jeffery the Bot!\n [Press start to load me]");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {
            double SpeedOfRobot = 0.1;
            double SpeedOfArm = 0.6;
            if (gamepad1.x) {
                telemetry.addLine("Drive: Slowed Speed");
                SpeedOfRobot = 0.05;
            } else {
                telemetry.addLine("Drive: Default Speed");
                SpeedOfRobot = 0.1;
            }
            if (gamepad2.x) {
                telemetry.addLine("Arm: Slowed Speed");
                SpeedOfArm = 0.3;
            } else {
                telemetry.addLine("Arm: Default Speed");
                SpeedOfArm = 0.6;
            }

            if (gamepad1.b) {
                duckWheelMiddle.setPower(0.5);
                telemetry.addLine("DuckWheel: right");
            } else if (gamepad1.a) {
                duckWheelMiddle.setPower(-0.5);
                telemetry.addLine("DuckWheel: left");
            } else {
                duckWheelMiddle.setPower(0);
                telemetry.addLine("DuckWheel: none");
            }
            telemetry.update();

            if (gamepad2.dpad_up) {
                armMotor.setPower(SpeedOfArm);
            } else if (gamepad2.dpad_down) {
                armMotor.setPower(-SpeedOfArm);
            } else {
                armMotor.setPower(0);
            }

            if (gamepad1.dpad_up) {
                frontLeft.setPower(-SpeedOfRobot);
                frontRight.setPower(-SpeedOfRobot);
                backLeft.setPower(-SpeedOfRobot);
                backRight.setPower(-SpeedOfRobot);
            } else if (gamepad1.dpad_down) {
                frontLeft.setPower(SpeedOfRobot);
                frontRight.setPower(SpeedOfRobot);
                backLeft.setPower(SpeedOfRobot);
                backRight.setPower(SpeedOfRobot);
            } else if (gamepad2.dpad_right) {
                frontRight.setPower(SpeedOfRobot);
                frontLeft.setPower(-SpeedOfRobot);
                backRight.setPower(SpeedOfRobot);
                backLeft.setPower(-SpeedOfRobot);
            } else if (gamepad2.dpad_left) {
                frontRight.setPower(-SpeedOfRobot);
                frontLeft.setPower(SpeedOfRobot);
                backRight.setPower(-SpeedOfRobot);
                backLeft.setPower(SpeedOfRobot);
            } else {
                frontLeft.setPower(0);
                frontRight.setPower(0);
                backLeft.setPower(0);
                backRight.setPower(0);
                if (gamepad1.right_bumper) {
                    frontRight.setPower(-SpeedOfRobot);
                    frontLeft.setPower(SpeedOfArm);
                    backRight.setPower(SpeedOfArm);
                    backLeft.setPower(-SpeedOfRobot);
                } else if (gamepad1.left_bumper) {
                    frontRight.setPower(SpeedOfArm);
                    frontLeft.setPower(-SpeedOfArm);
                    backRight.setPower(-SpeedOfArm);
                    backLeft.setPower(SpeedOfArm);
                }
            }
        }
    }
}