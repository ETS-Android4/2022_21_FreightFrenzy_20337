
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
        spinWheel(0.8,  5000);;
        turn(0.65, 960);
        drive(0.5, 1470);


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
